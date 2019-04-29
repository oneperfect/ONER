package com.demon.core.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.thymeleaf.util.StringUtils;

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

    /**
     * 获取请求参数
     */
    public static String getParameter(String parameter) {
        return getRequest().getParameter(parameter);
    }

    /**
     * 获取请求参数，带默认参数
     */
    public static String getParameter(String parameter, String defParameter) {
        String para = getRequest().getParameter(parameter);
        return StringUtils.isEmpty(para) ? defParameter : para;
    }

    /**
     * 获取请求参数，返回Integer类型
     */
    public static Integer getParameterInt(String parameter) {
        return Integer.valueOf(getParameter(parameter));
    }

    /**
     * 获取请求参数，返回Integer类型默认值
     */
    public static Integer getParameterInt(String parameter, Integer defParameter) {
        return Integer.valueOf(getParameter(parameter, String.valueOf(defParameter)));
    }



}
