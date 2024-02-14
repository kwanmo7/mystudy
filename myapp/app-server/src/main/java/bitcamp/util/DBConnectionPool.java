package bitcamp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnectionPool implements ConnectionPool {

  // 개별 스레드용 DB 커넥션 저장소
  private static final ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

  ArrayList<Connection> connections = new ArrayList<>();

  private String jdbcUrl;
  private String username;
  private String password;

  public DBConnectionPool(String jdbcUrl, String username, String password) {
    this.jdbcUrl = jdbcUrl;
    this.username = username;
    this.password = password;
  }

  public Connection getConnection() throws SQLException {
    Connection con = connectionThreadLocal.get();
    if (con == null) {
      if (connections.size() > 0) {
        con = connections.remove(0);
        System.out.printf("%s : DB 커넥션풀에서 꺼냄\n", Thread.currentThread().getName());
      } else {
        con = new ConnectionProxy(DriverManager.getConnection(jdbcUrl, username, password), this);
        System.out.printf("%s : DB 커넥션 생성\n", Thread.currentThread().getName());
      }
      connectionThreadLocal.set(con);
    } else {
      System.out.printf("%s : 기존에 보관했던 DB 커넥션 사용\n", Thread.currentThread().getName());
    }
    return con;
  }

  public void returnConnection(Connection con) {
    connectionThreadLocal.remove();
    connections.add(con);
    System.out.printf("%s : DB 커넥션 반환\n", Thread.currentThread().getName());
  }

  public void closeAll() {
    for (Connection connection : connections) {
      ((ConnectionProxy) connection).realClose();
    }
  }
}
