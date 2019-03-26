package na.config;

import na.config.prop.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.na.controller,com.na.filter,com.na.ini")
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {
  @Autowired private AppConfig appConfig;

  /**
   * 初始化单个视图解析器（JSP视图），如需需要添加诸如pdf和Excel解析可以声明在此方法后声明多个视图解析器
   *
   * @return
   */
  @Bean(name = "internalResourceViewResolver")
  public ViewResolver iniViewResolver() {
    InternalResourceViewResolver viewResolver =
        new InternalResourceViewResolver(appConfig.getPrefix(), appConfig.getSuffix());
    return viewResolver;
  }

  /**
   * 配置默认servlet（即当jsp页面访问图片等静态资源时，spring直接交给默认的tomcat servlet处理）
   *
   * @param defaultservlethandlerconfigurer
   */
  @Override
  public void configureDefaultServletHandling(
      DefaultServletHandlerConfigurer defaultservlethandlerconfigurer) {
    defaultservlethandlerconfigurer.enable();
  }
}
