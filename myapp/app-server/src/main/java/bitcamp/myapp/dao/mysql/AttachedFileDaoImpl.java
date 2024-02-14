package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.DaoException;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.util.DBConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AttachedFileDaoImpl implements AttachedFileDao {

  DBConnectionPool threadConnection;

  public AttachedFileDaoImpl(DBConnectionPool threadConnection) {
    this.threadConnection = threadConnection;
  }

  @Override
  public void add(AttachedFile file) {
    try (Connection connection = threadConnection.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(
            "insert into board_files(file_path,board_no) values(?,?)")) {
      pstmt.setString(1, file.getFilePath());
      pstmt.setInt(2, file.getBoardNo());

      pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 등록 중 오류", e);
    }
  }

  @Override
  public int addAll(List<AttachedFile> files) {
    try (Connection connection = threadConnection.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(
            "insert into board_files(file_path,board_no) values(?,?)")) {
      StringBuilder sb = new StringBuilder();
      for (AttachedFile file : files) {
        pstmt.setString(1, file.getFilePath());
        pstmt.setInt(2, file.getBoardNo());
        pstmt.addBatch();
        pstmt.clearParameters();
      }
      pstmt.executeBatch();
      pstmt.clearBatch();
      return 0;
    } catch (Exception e) {
      throw new DaoException("데이터 등록 중 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try (Connection connection = threadConnection.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(
            "delete from board_files where file_no = ?")) {
      pstmt.setInt(1, no);
      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 중 오류", e);
    }
  }

  @Override
  public int deleteAll(int no) {
    try (Connection connection = threadConnection.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(
            "delete from board_files where board_no = ?")) {
      pstmt.setInt(1, no);
      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 중 오류", e);
    }
  }

  @Override
  public List<AttachedFile> findAllByBoardNo(int no) {
    try (Connection connection = threadConnection.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(
            "select file_no,file_path,board_no "
                + "from board_files where board_no=? order by file_no asc")) {
      pstmt.setInt(1, no);
      try (ResultSet rs = pstmt.executeQuery()) {
        ArrayList<AttachedFile> list = new ArrayList<>();
        while (rs.next()) {
          AttachedFile file = new AttachedFile();
          file.setNo(rs.getInt("file_no"));
          file.setFilePath(rs.getString("file_path"));
          file.setBoardNo(rs.getInt("board_no"));
          list.add(file);
        }
        return list;
      }
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }
}
