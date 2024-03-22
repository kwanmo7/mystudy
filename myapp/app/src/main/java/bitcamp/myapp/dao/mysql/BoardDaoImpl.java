package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDao {

  SqlSessionFactory sqlSessionFactory;

  public BoardDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void add(Board board) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
      sqlSession.insert("BoardDao.add", board);
    }
  }

  @Override
  public int delete(int no) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
      return sqlSession.delete("BoardDao.delete", no);
    }
  }

  @Override
  public List<Board> findAll(int category) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("BoardDao.findAll", category);
    }
  }

  @Override
  public Board findBy(int no) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectOne("BoardDao.findBy", no);
    }
  }

  @Override
  public int update(Board board) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
      return sqlSession.update("BoardDao.update", board);
    }
  }
}
