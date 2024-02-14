package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import java.util.List;

// 게시글의 '변경'메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성
public class BoardModifyHandler extends AbstractMenuHandler {

  private BoardDao boardDao;
  private AttachedFileDao attachedFileDao;

  public BoardModifyHandler(BoardDao boardDao, AttachedFileDao attachedFileDao) {
    this.boardDao = boardDao;
    this.attachedFileDao = attachedFileDao;
  }

  @Override
  protected void action(Prompt prompt) {
    try {
      int no = prompt.inputInt("번호? ");
      Board oldBoard = boardDao.findBy(no);
      if (oldBoard == null) {
        prompt.println("게시글 번호가 유효하지 않습니다.");
        return;
      }
      Board board = new Board();
      board.setNo(oldBoard.getNo()); // 기존 게시글의 번호를 그대로 설정
      board.setTitle(prompt.input("제목(%s)? ", oldBoard.getTitle()));
      board.setContent(prompt.input("내용(%s)? ", oldBoard.getContent()));
      board.setWriter(prompt.input("작성자(%s)? ", oldBoard.getWriter()));
      board.setCreatedDate(oldBoard.getCreatedDate());

      String str = prompt.input("첨부파일 수정하시겠습니까?(Y/N) ");
      if (str.equalsIgnoreCase("Y")) {
        List<AttachedFile> files = attachedFileDao.findAllByBoardNo(no);
        while (true) {
          prompt.println("1.파일 추가");
          prompt.println("2.파일 삭제");
          prompt.println("3.목록 보기");
          prompt.println("0.수정 종료");
          str = prompt.input(">");
          if (str.equals("1")) {
            while (true) {
              String filepath = prompt.input("파일?(종료 : 그냥 엔터)");
              if (filepath.length() == 0) {
                break;
              }
              files.add(new AttachedFile().setFile(no, filepath));
            }
            attachedFileDao.addAll(files);
          } else if (str.equals("2")) {
            while (true) {
              String fileNo = prompt.input("파일번호?(종료 : 그냥 엔터)");
              if (fileNo.length() == 0) {
                break;
              }
              attachedFileDao.delete(Integer.parseInt(fileNo));
            }
          } else if (str.equals("3")) {
            files.forEach(file ->
                prompt.printf("파일번호 : %s\n 파일경로 : %s\n",
                    file.getNo(), file.getFilePath()));
          } else if (str.equals("0")) {
            break;
          } else {
            prompt.println("번호를 잘못 입력 했습니다.");
          }
        }
      }
      boardDao.update(board);
      prompt.println("게시글을 변경했습니다.");
    } catch (Exception e) {
      prompt.println("변경 오류");
    }
  }
}
