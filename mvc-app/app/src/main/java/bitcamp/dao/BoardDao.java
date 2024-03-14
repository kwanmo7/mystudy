package bitcamp.dao;

import bitcamp.vo.Board;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {

  private static Log log = LogFactory.getLog(BoardDao.class);
  ArrayList<Board> boards = new ArrayList<>();

  public BoardDao() {
    log.debug("BoardDao() 호출됨!");
    boards.add(new Board(1, "게시물입니다.111"));
    boards.add(new Board(2, "게시물입니다.222"));
    boards.add(new Board(3, "게시물입니다.333"));
    boards.add(new Board(4, "게시물입니다.444"));
    boards.add(new Board(5, "게시물입니다.555"));
  }

  public List<Board> findAll() {
    return boards;
  }

  public void insert(Board board) {
    boards.add(board);
  }

  public Board findBy(int no) {
    for (Board board : boards) {
      if (board.getNo() == no)
        return board;
    }
    return null;
  }
}
