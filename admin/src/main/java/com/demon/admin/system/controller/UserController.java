package com.demon.admin.system.controller;

import com.demon.admin.system.service.UserService;
import com.demon.core.config.ProjectProperties;
import com.demon.core.utils.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author: oneperfect
 * @Date: 2019/4/8
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/picture")
    public void picture(String p, HttpServletResponse response) throws IOException {
        String defaultPath = "/assets/images/user-picture.jpg";
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
