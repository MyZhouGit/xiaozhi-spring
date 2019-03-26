package com.xiaozhi.config.prop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/** 全局应用设置 */
@Component
@PropertySource("classpath:app.properties")
public class AppConfig {

  @Value("${debug}") // 是否为调试模式
  private boolean debug;

  public boolean isDebug() {
    return debug;
  }

  public void setDebug(boolean debug) {
    this.debug = debug;
  }

  @Value("${view-prefix}")
  private String prefix; // jsp视图访问路径前缀

  public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  @Value("${view-suffix}") // jsp视图访问路径后缀
  private String suffix;

  public String getSuffix() {
    return suffix;
  }

  public void setSuffix(String suffix) {
    this.suffix = suffix;
  }

  @Value("${error-view}")
  private String errorView; // 系统报错后固定转发错误页面

  public String getErrorView() {
    return errorView;
  }

  public void setErrorView(String errorView) {
    this.errorView = errorView;
  }
}
