package bitcamp.myapp.config;

import java.io.File;
import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class AppWebApplicationInitializer1 /*implements WebApplicationInitializer*/ {

  public void onStartup(ServletContext servletContext) throws ServletException {
    // 리스너 적용
    AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
    rootContext.register(RootConfig.class);
    rootContext.refresh();
    rootContext.setServletContext(servletContext);
    servletContext.addListener(new ContextLoaderListener(rootContext));

    // DispatcherServlet 적용
    AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
    appContext.register(AppConfig.class);
    appContext.setParent(rootContext);
    appContext.setServletContext(servletContext);
    appContext.refresh();

    Dynamic registration = servletContext.addServlet("app", new DispatcherServlet(appContext));
    registration.addMapping("/app/*");
    registration.setLoadOnStartup(1);
    registration.setMultipartConfig(new MultipartConfigElement(new File("./temp").getAbsolutePath(),
        1024 * 1024 * 10,
        1024 * 1024 * 100,
        1024 * 1024));

    // 필터 적용
    CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8");
    FilterRegistration.Dynamic filterRegistration = servletContext.addFilter(
        "characterEncodingFilter", characterEncodingFilter);
    filterRegistration.addMappingForServletNames(
        EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE),
        false,
        "app"
    );
  }

}
