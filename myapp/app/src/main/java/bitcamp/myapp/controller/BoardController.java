package bitcamp.myapp.controller;

import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/board")
public class BoardController {

  private BoardDao boardDao;
  private AttachedFileDao attachedFileDao;
  private String uploadDir;

  public BoardController(BoardDao boardDao,
      AttachedFileDao attachedFileDao, ServletContext sc) {
    this.boardDao = boardDao;
    this.attachedFileDao = attachedFileDao;
    uploadDir = sc.getRealPath("/upload/board");
  }

  @GetMapping("form")
  public void form(int category, Model model)
      throws Exception {
    model.addAttribute("boardName", category == 1 ? "게시글" : "가입인사");
    model.addAttribute("category", category);
  }

  @Transactional
  @PostMapping("add")
  public String add(
      Board board,
      MultipartFile[] attachedFiles,
      HttpSession session,
      Model model) throws Exception {

    model.addAttribute("category", board.getCategory());

    try {
      Member loginUser = (Member) session.getAttribute("loginUser");
      if (loginUser == null) {
        throw new Exception("로그인하시기 바랍니다!");
      }
      board.setWriter(loginUser);

      ArrayList<AttachedFile> files = new ArrayList<>();

      if (board.getCategory() == 1) {
        for (MultipartFile file : attachedFiles) {
          if (file.getSize() == 0) {
            continue;
          }
          String filename = UUID.randomUUID().toString();
          file.transferTo(new File(this.uploadDir + "/" + filename));
          files.add(new AttachedFile().filePath(filename));
        }
      }
      boardDao.add(board);

      if (files.size() > 0) {
        for (AttachedFile attachedFile : files) {
          attachedFile.setBoardNo(board.getNo());
        }
        attachedFileDao.addAll(files);
      }

      return "redirect:list";

    } catch (Exception e) {
      throw e;
    }
  }

  @GetMapping("list")
  public void list(
      int category,
      Model model) throws Exception {
    model.addAttribute("boardName", category == 1 ? "게시글" : "가입인사");
    model.addAttribute("list", boardDao.findAll(category));
    model.addAttribute("category", category);
  }

  @Transactional
  @GetMapping("delete")
  public String delete(
      int category,
      int no,
      HttpSession session) throws Exception {
    try {
      Member loginUser = (Member) session.getAttribute("loginUser");
      if (loginUser == null) {
        throw new Exception("로그인하시기 바랍니다!");
      }
      Board board = boardDao.findBy(no);
      if (board == null) {
        throw new Exception("번호가 유효하지 않습니다.");

      } else if (board.getWriter().getNo() != loginUser.getNo()) {
        throw new Exception("권한이 없습니다.");
      }

      List<AttachedFile> files = attachedFileDao.findAllByBoardNo(no);

      attachedFileDao.deleteAll(no);
      boardDao.delete(no);

      for (AttachedFile file : files) {
        new File(this.uploadDir + "/" + file.getFilePath()).delete();
      }

      return "redirect:list?category=" + category;

    } catch (Exception e) {
      throw e;
    }
  }

  @GetMapping("file/delete")
  public String fileDelete(
      int category,
      int no,
      HttpSession session) throws Exception {
    Member loginUser = (Member) session.getAttribute("loginUser");
    if (loginUser == null) {
      throw new Exception("로그인하시기 바랍니다!");
    }
    AttachedFile file = attachedFileDao.findByNo(no);
    if (file == null) {
      throw new Exception("첨부파일 번호가 유효하지 않습니다.");
    }

    Member writer = boardDao.findBy(file.getBoardNo()).getWriter();
    if (writer.getNo() != loginUser.getNo()) {
      throw new Exception("권한이 없습니다.");
    }

    attachedFileDao.delete(no);
    new File(this.uploadDir + "/" + file.getFilePath()).delete();

    return "redirect:../view?category=" + category + "&no=" + file.getBoardNo();
  }


  @Transactional
  @PostMapping("update")
  public String update(
      Board board,
      MultipartFile[] attachedFiles,
      HttpSession session,
      Model model) throws Exception {
    model.addAttribute("category", board.getCategory());
    try {
      Member loginUser = (Member) session.getAttribute("loginUser");
      if (loginUser == null) {
        throw new Exception("로그인하시기 바랍니다!");
      }

      Board old = boardDao.findBy(board.getNo());
      if (old == null) {
        throw new Exception("번호가 유효하지 않습니다.");

      } else if (old.getWriter().getNo() != loginUser.getNo()) {
        throw new Exception("권한이 없습니다.");
      }
      ArrayList<AttachedFile> files = new ArrayList<>();
      if (board.getCategory() == 1) {
        for (MultipartFile file : attachedFiles) {
          if (file.getSize() == 0) {
            continue;
          }
          String filename = UUID.randomUUID().toString();
          file.transferTo(new File(this.uploadDir + "/" + filename));
          files.add(new AttachedFile().filePath(filename));
        }
      }

      boardDao.update(board);
      if (files.size() > 0) {
        for (AttachedFile attachedFile : files) {
          attachedFile.setBoardNo(board.getNo());
        }
        attachedFileDao.addAll(files);
      }
      return "redirect:list";

    } catch (Exception e) {
      throw e;
    }
  }


  @GetMapping("view")
  public void view(
      int category,
      int no,
      Model model) throws Exception {

    Board board = boardDao.findBy(no);
    if (board == null) {
      throw new Exception("번호가 유효하지 않습니다.");
    }
    model.addAttribute("boardName", category == 1 ? "게시글" : "가입인사");
    model.addAttribute("category", category);
    model.addAttribute("board", board);
  }
}
