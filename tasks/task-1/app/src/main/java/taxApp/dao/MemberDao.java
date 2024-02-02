package taxApp.dao;

import java.util.List;
import taxApp.vo.Member;

public interface MemberDao {

  void add(Member member);

  int delete(int no);

  List<Member> findAll();

  Member findBy(int no);

  int update(Member member);
}
