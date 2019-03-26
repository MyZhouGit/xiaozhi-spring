package com.xiaozhi.controller;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.xiaozhi.config.prop.AppConfig;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@ControllerAdvice(basePackages = "com.na.controller")
public class ExceptionAdvice {

  @Autowired private AppConfig appConfig;

  private Logger logger = Logger.getLogger(ExceptionAdvice.class);

  /**
   * controller层的全局异常捕获
   *
   * @param exception
   * @param request
   * @return
   */
  @ExceptionHandler(value = {IOException.class, RuntimeException.class})
  @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
  public ModelAndView exception(Exception exception, WebRequest request) {
    logger.error(
        "拦截到Spring异常，异常信息为"
            + exception.getMessage()
            + "---堆栈信息为"
            + ExceptionUtil.stacktraceToOneLineString(exception, 100),
        exception);
    ModelAndView returnView = new ModelAndView();
    logger.info("返回errorView-----" + appConfig.getErrorView());
    returnView.setViewName(appConfig.getErrorView());
    return returnView;
  }
}
