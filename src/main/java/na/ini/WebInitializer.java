package na.ini;

import na.config.IocConfig;
import na.config.MvcConfig;
import org.apache.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/** 全局启动类，相当于web.xml的作用 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
    implements WebApplicationInitializer {
  private Logger logger = Logger.getLogger(WebInitializer.class);

  // Spring IoC容器配置
  @Override
  protected Class<?>[] getRootConfigClasses() {
    // 可以返回Spring的Java配置文件数组
    return new Class<?>[] {IocConfig.class};
  }

  // DispatcherServlet的URI映射关系配置
  @Override
  protected Class<?>[] getServletConfigClasses() {
    // 可以返回Spring的Java配置文件数组
    return new Class<?>[] {MvcConfig.class};
  }

  // DispatchServlet拦截请求匹配
  @Override
  protected String[] getServletMappings() {
    return new String[] {"*.html", "*.do"};
  }

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    logger.info("系统启动成功。。。。。。。。");
    super.onStartup(servletContext);
  }
}
