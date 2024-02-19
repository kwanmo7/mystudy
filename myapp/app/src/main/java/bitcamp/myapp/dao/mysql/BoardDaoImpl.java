package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.DaoException;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;
import bitcamp.util.DBConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDaoImpl implements BoardDao {

  DBConnectionPool threadConnection;

  public BoardDaoImpl(DBConnectionPool threadConnection) {
    this.threadConnection = threadConnection;
  }

  @Override
  public void add(Board board) {
    try (Connection connection = threadConnection.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(
            "insert into boards(title,content,writer,category) values(?,?,?,?)",
            PreparedStatement.RETURN_GENERATED_KEYS)) {
      pstmt.setString(1, board.getTitle());
      pstmt.setString(2, board.getContent());
      pstmt.setInt(3, board.getWriter().getNo());
      pstmt.setInt(4, board.getCategory());

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
  public List<Board> findAll(int category) {
    try (Connection connection = threadConnection.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(
            "select\n"
                + " b.board_no,\n"
                + " b.title,\n"
                + " b.created_date,\n"
                + " count(file_no) file_count,\n"
                + " m.member_no,\n"
                + " m.name\n"
                + "from boards b left outer join board_files bf on b.board_no = bf.board_no\n"
                + " inner join members m on b.writer=m.member_no\n"
                + "where b.category=?\n"
                + "group by\n"
                + " board_no\n"
                + "order by\n"
                + " board_no desc")) {
      pstmt.setInt(1, category);
      try (ResultSet rs = pstmt.executeQuery()) {
        ArrayList<Board> list = new ArrayList<>();
        while (rs.next()) {
          Board board = new Board();
          Member member = new Member();
          board.setNo(rs.getInt("board_no"));
          board.setTitle(rs.getString("title"));
          member.setNo(rs.getInt("member_no"));
          member.setName(rs.getString("name"));
          board.setWriter(member);
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
            "select "
                + " b.board_no, b.title, b.content, b.created_date, m.member_no, m.name"
                + " from boards b inner join members m on b.writer = m.member_no"
                + " where board_no =?")) {
      pstmt.setInt(1, no);
      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          Board board = new Board();
          Member member = new Member();
          board.setNo(rs.getInt("board_no"));
          board.setTitle(rs.getString("title"));
          board.setContent(rs.getString("content"));
          member.setNo(rs.getInt("member_no"));
          member.setName(rs.getString("name"));
          board.setWriter(member);
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
            "update boards set title=?, content=? where board_no = ?")) {
      pstmt.setString(1, board.getTitle());
      pstmt.setString(2, board.getContent());
      pstmt.setInt(3, board.getNo());
      return pstmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException("데이터 갱신 중 오류", e);
    }
  }
}
