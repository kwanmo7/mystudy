package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;
import java.sql.Connection;
import java.util.List;

public class BoardDaoImpl implements BoardDao {

  Connection connection;
  int category;

  public BoardDaoImpl(Connection connection, int category) {
    this.connection = connection;
    this.category = category;
  }

  @Override
  public void add(Board board) {

  }

  @Override
  public int delete(int no) {
    return 0;
  }

  @Override
  public List<Board> findAll() {
    return null;
  }

  @Override
  public Board findBy(int no) {
    return null;
  }

  @Override
  public int update(Board board) {
    return 0;
  }
}
