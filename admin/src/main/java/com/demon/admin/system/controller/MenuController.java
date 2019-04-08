package com.demon.admin.system.controller;

import com.demon.admin.system.domain.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: oneperfect
 * @Date: 2019/4/4
 */
@Controller
@RequestMapping("menu")
public class MenuController {

    @GetMapping("/index")
    public String index(Model model, Menu menu) {
        String search = "";
        if(menu.getStatus() != null) {
            search += "status=" + menu.getStatus();
        }
        if(menu.getTitle() != null) {
            search += "&title=" + menu.getTitle();
        }
        if(menu.getUrl() != null) {
            search += "&url=" + menu.getUrl();
        }
        model.addAttribute("search", search);
        return "/system/menu/index";
    }
}
