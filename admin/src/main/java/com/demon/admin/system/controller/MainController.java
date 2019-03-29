package com.demon.admin.system.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: oneperfect
 * @Date: 2019/02/28
 */

@Controller
@RequestMapping("/main")
public class MainController implements ErrorController{

    @GetMapping("/")
    public String main() {
        return "/main";
    }

    @GetMapping("/index")
    public String index() {
        return "/system/main/index";
    }


    /**
     * 处理错误页面
     */
    @RequestMapping("/error")
    public String handleError(Model model, HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String errorMsg = "好像出错了呢！";
        if (statusCode == 404) {
            errorMsg = "页面找不到了！好像是去火星了~";
        }

        model.addAttribute("statusCode", statusCode);
        model.addAttribute("msg", errorMsg);
        return "/error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}
