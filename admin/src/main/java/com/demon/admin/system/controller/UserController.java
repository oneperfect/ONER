package com.demon.admin.system.controller;

import com.demon.admin.system.domain.Dept;
import com.demon.admin.system.domain.User;
import com.demon.admin.system.service.DeptService;
import com.demon.admin.system.service.UserService;
import com.demon.core.config.ProjectProperties;
import com.demon.core.utils.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: oneperfect
 * @Date: 2019/4/8
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DeptService deptService;

    /**
     * 跳转到用户列表
     */
    @GetMapping("/index")
    public String index(Model model, User user) {
        // 获取部门及下属部门
        Dept dept = user.getDept();
        List<Long> depts = null;
        if(dept != null) {
            depts = new ArrayList<>();
            depts.add(dept.getId());
            List<Dept> deptList = deptService.findByPidsLike(dept.getId());
            for(Dept dl: deptList) {
                depts.add(dl.getId());
            }
        }

        // 获取用户列表
        Page<User> pageList = userService.findPageList(user, depts);

        // 封装数据
        model.addAttribute("list", pageList.getContent());
        model.addAttribute("page", pageList);
        model.addAttribute("dept", dept);
        return "/system/user/index";
    }

    @GetMapping("/picture")
    public void picture(String p, HttpServletResponse response) throws IOException {
        String defaultPath = "/assets/images/user-picture01.jpg";
        if(!StringUtils.isEmpty(p) || defaultPath.equals(p)) {
            ProjectProperties properties = SpringContextUtil.getBean(ProjectProperties.class);
            String uploadPath = properties.getFileUploadPath();
            String staticPath = properties.getStaticPathPattern().replace("*", "");
            String fp = uploadPath + p.replace(staticPath, "");
            File file = new File(fp);
            if(file.exists()) {
                FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());
                return;
            }
        }
        Resource resource = new ClassPathResource("static" + defaultPath);
        FileCopyUtils.copy(resource.getInputStream(), response.getOutputStream());
    }


}
