package bitcamp.util;

import java.sql.Connection;

public class TransactionManager {

  ConnectionPool connectionPool;

  public TransactionManager(ConnectionPool connectionPool) {
    this.connectionPool = connectionPool;
  }

  public void startTransaction() throws Exception {
    connectionPool.getConnection().setAutoCommit(false);
    System.out.printf("[%s] Transaction Start\n", Thread.currentThread().getName());
  }

  public void commit() throws Exception {
    connectionPool.getConnection().commit();
    complete();
  }

  public void rollback() throws Exception {
    connectionPool.getConnection().rollback();
    complete();
  }

  private void complete() throws Exception {
    Connection connection = connectionPool.getConnection();
    connection.setAutoCommit(true);
    connection.close();
    System.out.printf("[%s] Transaction End\n", Thread.currentThread().getName());

  }
}
