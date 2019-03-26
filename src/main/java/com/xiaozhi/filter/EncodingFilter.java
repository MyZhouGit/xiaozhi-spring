package com.xiaozhi.filter;

import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/** 全局编码过滤器，过滤器是在spring mvc捕获请求前拦截，拦截器是spring mvc拦截到请求拦截，注意区分 */
@WebFilter(
    filterName = "encodingFilter",
    urlPatterns = "/*",
    initParams = {
      @WebInitParam(name = "encoding", value = "UTF-8") // 忽略资源
    })
public class EncodingFilter extends CharacterEncodingFilter {}
