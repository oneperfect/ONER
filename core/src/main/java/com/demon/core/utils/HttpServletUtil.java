package com.demon.core.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet工具类
 * @Auther: oneperfect
 * @Date: 2019/03/07
 */
public class HttpServletUtil {

    /**
     * 获取ServletRequestAttributes对象
     */
    public static ServletRequestAttributes getServletRequest() {
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

    /**
     * 获取HTTPServletRequest对象
     */
    public static HttpServletRequest getRequest() {
        return getServletRequest().getRequest();
    }

    /**
     * 获取HTTPServletResponse对象
     */
    public static HttpServletResponse getResponse() {
        return getServletRequest().getResponse();
    }

}
