// 기본 View Resolver 사용하기
package bitcamp.app2;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/c01_2")
public class Controller01_2 {

  // 테스트:
  // http://localhost:9999/eomcs-spring-webmvc/app2/c01_1/h1
  @GetMapping("h1")
  // @ResponseBody // 뷰 이름을 리턴 할 때는 이 애노테이션을 붙이면 안된다.
  public String handler1(Model model) {

    model.addAttribute("name", "홍길동");
    model.addAttribute("age", 20);

    return "c01_1";
    // 기본 ViewResolver는 리턴 값으로 받은 view name으로 JSP를 찾는다
    // 즉 view name을 JSP uRL로 간주
    // 따라서 위의 return 문의 view name은 다음 JSP 경로와 같다
    // => /컨텍스트경로/jsp/c01_1.jsp

    // 절대 경로로 시작할때 - '/' 로 시작할때
    // ex) return "/jsp/c01_1.jsp"
    //     view URL = /루트경로 + view name
    //              = /jsp/c01_1.jsp
    //
    // 상대 경로로 시작할때 - '/' 로 시작하지 않을 때
    // ex) return "jsp/c01_1.jsp"
    //     view URL = 현재 경로 URL + view name
    //              = /웹어플리케이션경로/app2/c01_1 + jsp/c01_1.jsp
    //              = /웹어플리케이션경로/app2/c01_1/jsp/c01_1.jsp

    // 기본 ViewResolver는 리턴 값으로 URL을 받아
    // 웹 애플리케이션 디렉토리에서 JSP를 찾는다.
    // 웹 애플리케이션이 경로가 /eomcs-spring-webmvc 라면,
    // JSP 경로는 다음과 같다.
    // ==> /eomcs-spring-webmvc/jsp/c01_1.jsp
    //
    // InternalResourceViewResolver로 교체한 다음의 JSP URL은?
    // => /WEB-INF/jsp2//jsp/c01_1.jsp.jsp
  }

  // 테스트:
  // http://localhost:9999/eomcs-spring-webmvc/app2/c01_1/h2
  @GetMapping("h2")
  public void handler2(Model model) {
    model.addAttribute("name", "홍길동2");
    model.addAttribute("age", 30);
    

    // view name = c01_2/h2
    // 최종 계산된 JSP경로 = /WEB-INF/jsp/ + c01_2/h2 + .jsp
    //                     = /WEB-INF/jsp/c01_2/h2.jsp
  }

  // 테스트:
  // http://localhost:9999/eomcs-spring-webmvc/app2/c01_1/h3
  @GetMapping("h3")
  public Map<String, Object> handler3() {

    Map<String, Object> map = new HashMap<>();

    map.put("name", "홍길동3");
    map.put("age", 40);

    return map;
    // view name = c01_2/h3
    // JSP URL = /WEB-INF/jsp/c01_2/h3.jsp
  }
  @GetMapping("h4")
  public ModelAndView handler4() {

    ModelAndView mv = new ModelAndView();
    mv.addObject("name", "홍길동3");
    mv.addObject("age", 40);
    mv.setViewName("c01_2/h4");

    // ModelAndView 객체에 값과 뷰 이름을 담아 리턴하면
    // 프론트 컨트롤러는 ModelAndView 객체에 보관되어 있는 값들을
    // ServletRequest 보관소로 옮기고,
    // 설정된 뷰 이름을 ViewResolver에게 넘긴다.
    //
    return mv;
  }

  // 테스트:
  // http://localhost:9999/eomcs-spring-webmvc/app2/c01_2/h5
  @GetMapping("h5")
  public ModelAndView handler5() {

    ModelAndView mv = new ModelAndView();
    mv.addObject("name", "홍길동3");
    mv.addObject("age", 40);

    // ModelAndView 객체에 값과 뷰 이름을 담아 리턴하면
    // 프론트 컨트롤러는 ModelAndView 객체에 보관되어 있는 값들을
    // ServletRequest 보관소로 옮기고,
    // 뷰 이름을 지정하지 않으면 request handler의 path를 ViewResolver에게 넘긴다.
    // => /c01_2/h5
    // InternalResourceViewResolver 는 위 URL을 다음과 같이 바꾼다.
    // => /WEB-INF/jsp2/c01_2/h5.jsp
    // 그런 후에 해당 URL의 JSP를 실행한다.
    return mv;
  }


}


