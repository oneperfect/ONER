package com.demon.core.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Auther: oneperfect
 * @Date: 2019/03/07
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println(request.getServletPath());
        // 每一个项目对于登陆的实现逻辑都有所区别，我这里使用最简单的Session提取uid来验证登陆。
        HttpSession session = request.getSession();
        // 获取登陆时放入session的uid
        Object uid = session.getAttribute("uid");
        //如果session中没有user，表示没登陆
        if (uid == null) {
            // 这个方法返回false表示忽略当前请求，如果一个用户调用了需要登陆才能使用的接口，
            // 如果他没有登陆这里会直接忽略掉
            // 当然你可以利用response给用户返回一些提示信息，告诉他没登陆
            response.sendRedirect(request.getContextPath() + "/login/");
            return false;
        } else {
            // 如果session里有user，表示该用户已经登陆，放行，用户即可继续调用自己需要的接口
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {

    }
}
