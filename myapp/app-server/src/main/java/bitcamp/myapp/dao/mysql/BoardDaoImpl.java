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
    try (Connection connection = threadConnection.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(
            "insert into boards(title,content,writer,category) values(?,?,?,?)",
            PreparedStatement.RETURN_GENERATED_KEYS)) {
      pstmt.setString(1, board.getTitle());
      pstmt.setString(2, board.getContent());
      pstmt.setString(3, board.getWriter());
      pstmt.setInt(4, this.category);

      pstmt.executeUpdate();
      // 자동 생성된 PK값을 가져와서 Board객체에 저장
      try (ResultSet keyRs = pstmt.getGeneratedKeys()) {
        keyRs.next();
        board.setNo(keyRs.getInt(1));
      }

    } catch (Exception e) {
      throw new DaoException("데이터 등록 중 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try (Connection connection = threadConnection.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(
            "delete from boards where board_no = ?")) {
      pstmt.setInt(1, no);
      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 중 오류", e);
    }
  }

  @Override
  public List<Board> findAll() {
    try (Connection connection = threadConnection.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(
            "select\n"
                + " b.board_no,\n"
                + " b.title,\n"
                + " b.writer,\n"
                + " b.created_date,\n"
                + " count(file_no) file_count\n"
                + "from boards b left outer join board_files bf on b.board_no = bf.board_no\n"
                + "where b.category=?\n"
                + "group by\n"
                + " board_no\n"
                + "order by\n"
                + " board_no desc")) {
      pstmt.setInt(1, this.category);
      try (ResultSet rs = pstmt.executeQuery()) {
        ArrayList<Board> list = new ArrayList<>();
        while (rs.next()) {
          Board board = new Board();
          board.setNo(rs.getInt("board_no"));
          board.setTitle(rs.getString("title"));
          board.setWriter(rs.getString("writer"));
          board.setCreatedDate(rs.getDate("created_date"));
          board.setFileCount(rs.getInt("file_count"));
          list.add(board);
        }
        return list;
      }
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Board findBy(int no) {
    try (Connection connection = threadConnection.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(
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
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Board board) {
    try (Connection connection = threadConnection.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(
            "update boards set title=?, content=?, writer = ? where board_no = ?")) {
      pstmt.setString(1, board.getTitle());
      pstmt.setString(2, board.getContent());
      pstmt.setString(3, board.getWriter());
      pstmt.setInt(4, board.getNo());
      return pstmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException("데이터 갱신 중 오류", e);
    }
  }
}
