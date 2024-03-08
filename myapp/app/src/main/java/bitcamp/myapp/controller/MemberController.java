package bitcamp.myapp.controller;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import java.io.File;
import java.util.Map;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

  private MemberDao memberDao;
  private String uploadDir;

  public MemberController(MemberDao memberDao, ServletContext sc) {
    this.memberDao = memberDao;
    uploadDir = sc.getRealPath("/upload");
  }

  @RequestMapping("/member/form")
  public String form() throws Exception {
    return "/member/form.jsp";
  }

  @RequestMapping("/member/add")
  public String add(
      Member member,
      @RequestParam("file") Part file
  ) throws Exception {
    if (file.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      member.setPhoto(filename);
      file.write(this.uploadDir + "/" + filename);
    }
    memberDao.add(member);
    return "redirect:list";
  }

  @RequestMapping("/member/delete")
  public String delete(@RequestParam("no") int no) throws Exception {
    Member member = memberDao.findBy(no);
    if (member == null) {
      throw new Exception("회원 번호가 유효하지 않습니다.");
    }

    memberDao.delete(no);
    String filename = member.getPhoto();
    if (filename != null) {
      new File(this.uploadDir + "/" + filename).delete();
    }
    return "redirect:list";
  }

  @RequestMapping("/member/list")
  public String list(Map<String, Object> map)
      throws Exception {
    map.put("list", memberDao.findAll());
    return "/member/list.jsp";
  }


  @RequestMapping("/member/update")
  public String update(
      Member member,
      @RequestParam("file") Part file
  ) throws Exception {
    Member old = memberDao.findBy(member.getNo());
    if (old == null) {
      throw new Exception("회원 번호가 유효하지 않습니다.");
    }
    if (file.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      member.setPhoto(filename);
      file.write(this.uploadDir + "/" + filename);
      new File(this.uploadDir + "/" + old.getPhoto()).delete();
    } else {
      member.setPhoto(old.getPhoto());
    }
    memberDao.update(member);
    return "redirect:list";
  }

  @RequestMapping("/member/view")
  public String view(@RequestParam("no") int no, Map<String, Object> map) throws Exception {
    Member member = memberDao.findBy(no);
    if (member == null) {
      throw new Exception("회원 번호가 유효하지 않습니다.");
    }
    map.put("member", member);
    return "/member/view.jsp";
  }
}
