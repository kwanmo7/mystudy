package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.DaoException;
import bitcamp.myapp.vo.Board;
import bitcamp.util.DBConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDaoImpl implements BoardDao {

  DBConnectionPool threadConnection;
  int category;

  public BoardDaoImpl(DBConnectionPool threadConnection, int category) {
    this.threadConnection = threadConnection;
    this.category = category;
  }

  @Override
  public void add(Board board) {
    Connection connection = null;
    try {
      connection = threadConnection.getConnection();
      try (PreparedStatement pstmt = connection.prepareStatement(
          "insert into boards(title,content,writer,category) values(?,?,?,?)")) {
        pstmt.setString(1, board.getTitle());
        pstmt.setString(2, board.getContent());
        pstmt.setString(3, board.getWriter());
        pstmt.setInt(4, this.category);

        pstmt.executeUpdate();
      }
    } catch (Exception e) {
      throw new DaoException("데이터 등록 중 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    Connection connection = null;
    try {
      connection = threadConnection.getConnection();
      try (PreparedStatement pstmt = connection.prepareStatement(
          "delete from boards where board_no = ?")) {
        pstmt.setInt(1, no);
        return pstmt.executeUpdate();
      }
    } catch (Exception e) {
      throw new DaoException("데이터 삭제 중 오류", e);
    }
  }

  @Override
  public List<Board> findAll() {
    Connection connection = null;
    try {
      connection = threadConnection.getConnection();
      try (PreparedStatement pstmt = connection.prepareStatement(
          "select * from boards where category=? order by board_no desc")) {
        pstmt.setInt(1, this.category);
        try (ResultSet rs = pstmt.executeQuery()) {
          ArrayList<Board> list = new ArrayList<>();
          while (rs.next()) {
            Board board = new Board();
            board.setNo(rs.getInt("board_no"));
            board.setTitle(rs.getString("title"));
            board.setContent(rs.getString("content"));
            board.setWriter(rs.getString("writer"));
            board.setCreatedDate(rs.getDate("created_date"));
            list.add(board);
          }
          return list;
        }
      }
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Board findBy(int no) {
    Connection connection = null;
    try {
      connection = threadConnection.getConnection();
      try (PreparedStatement pstmt = connection.prepareStatement(
          "select * from boards where board_no =?")) {
        pstmt.setInt(1, no);
        try (ResultSet rs = pstmt.executeQuery()) {
          if (rs.next()) {
            Board board = new Board();
            board.setNo(rs.getInt("board_no"));
            board.setTitle(rs.getString("title"));
            board.setContent(rs.getString("content"));
            board.setWriter(rs.getString("writer"));
            board.setCreatedDate(rs.getDate("created_date"));
            return board;
          }
          return null;
        }
      }
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Board board) {
    Connection connection = null;
    try {
      connection = threadConnection.getConnection();
      try (PreparedStatement pstmt = connection.prepareStatement(
          "update boards set title=?, content=?, writer = ? where board_no = ?")) {
        pstmt.setString(1, board.getTitle());
        pstmt.setString(2, board.getContent());
        pstmt.setString(3, board.getWriter());
        pstmt.setInt(4, board.getNo());
        return pstmt.executeUpdate();
      }
    } catch (Exception e) {
      throw new DaoException("데이터 갱신 중 오류", e);
    }
  }
}
