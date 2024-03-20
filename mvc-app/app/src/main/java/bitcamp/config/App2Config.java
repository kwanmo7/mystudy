package bitcamp.config;

import bitcamp.app2.Interceptor1;
import bitcamp.app2.Interceptor2;
import bitcamp.app2.Interceptor3;
import bitcamp.app2.Interceptor4;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.util.UrlPathHelper;

@ComponentScan(value = "bitcamp.app2")
public class App2Config implements WebMvcConfigurer {

  // DispatcherServlet의 기본 ViewResolver를 교체하기
  // 1) XML 설정
  // <bean id="viewResolver"
  //       class="org.springframework.web.servlet.view.InternalResourceViewResolver">
  //   <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
  //   <property name="prefix" value="/WEB-INF/jsp/"/>
  //   <property name="suffix" value=".jsp"/>
  // </bean>
  //
  // 2) Java Config 설정
  @Bean
  public ViewResolver viewResolver(){
    InternalResourceViewResolver vr = new InternalResourceViewResolver(
        "/WEB-INF/jsp/", ".jsp");
    return vr;
  }


  // @MatrixVariable 애노테이션 처리를 활성화시킨다.
  // => 이 작업을 수행하려면 MVC 관련 설정 작업을 수행할 수 있도록
  // WebMvcConfigurer 인터페이스를 구현해야 한다.
  // => 그리고 다음 메서드를 오버라이딩 하여 기존 설정을 변경한다.
  //
  // DispatcherServlet 이 MVC 관련 설정을 처리하는 과정
  // => WebMVC 설정을 활성화시켰는지 검사한다.
  // => 활성화시켰으면, IoC 컨테이너가 관리하는 객체 중에서
  // WebMvcConfigurer 구현체를 찾는다.
  // 관리하는 객체?
  // - IoC 컨테이너에 들어 있는 객체
  // - @Component, @Service, @Controller, @RestController, @Repository
  // 애노테이션이 붙은 클래스들은 IoC 컨테이너가 자동으로 객체를 생성하여 보관한다.
  // - 하지만 WebMvcConfigurer 구현체는 Java Config 클래스이기 때문에
  // 일반 객체로 표시하지 말고, @Configuration 을 붙여
  // Java Config 클래스임을 명확히 하는 것이 유지보수에 좋다.
  // 물론, @Configuration 가 붙은 클래스도 객체가 생성되어 IoC 컨테이너에 보관되는 것은 같다.
  //
  // => 객체를 찾았으면, WebMvcConfigurer 규칙에 따라 메서드를 호출하여
  // 설정을 추가하거나 기존 설정을 변경한다.
  // => WebMVC 설정을 활성화시키지 않으면,
  // WebMvcConfigurer 구현체가 있다 하더라도 무시한다.
  // => WebMVC 설정을 활성화시키는 방법
  // 1) XML 설정
  // <mvc:annotation-driven/>
  // 2) Java Config 설정
  // @EnableWebMvc 애노테이션 표시
  //
  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
    UrlPathHelper urlPathHelper = new UrlPathHelper();
    urlPathHelper.setRemoveSemicolonContent(false);

    // DispatcherServlet의 MVC Path 관련 설정을 변경
    configurer.setUrlPathHelper(urlPathHelper);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 인터셉터를 적용할 경로를 지정하지 않으면 모든 request handler에 대해 적용 됨
    registry.addInterceptor(new Interceptor1());

    
    // /c04_1/ 바로 밑에 있는 것만 포함
    // ex) /c04_1/a/1 <- 이런것은 불가
    registry.addInterceptor(new Interceptor2()).addPathPatterns("/c04_1/*");
    
    // /c04_1/하위에 있는 모든 하위 경로를 포함
    // ex) /c04_1/a/1 <- 포함
    registry.addInterceptor(new Interceptor3()).addPathPatterns("/c04_1/**");

    registry.addInterceptor(new Interceptor4()).addPathPatterns("/c04_1/**")
            .excludePathPatterns("/c04_1/a/**");
  }
}
