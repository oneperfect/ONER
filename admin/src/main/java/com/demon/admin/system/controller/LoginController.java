package com.demon.admin.system.controller;

import com.demon.admin.core.enums.ResultEnum;
import com.demon.admin.core.exception.ResultException;
import com.demon.core.url.URL;
import com.demon.core.utils.ResultVoUtil;
import com.demon.core.vo.ResultVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Auther: oneperfect
 * @Date: 2019/02/28
 */

@Controller
@RequestMapping("/login")
public class LoginController {

    /**
     * 跳转到登录界面
     */
    @GetMapping("/")
    public String login() {
        return "/login";
    }

    /**
     * 登录操作
     */
    @PostMapping("/enter")
    @ResponseBody
    public ResultVo enter(String username,
                          String password,
                          String captcha,
                          String rememberMe) {
        // 判断账号密码是否为空
        if (StringUtils.isEmpty(username)
                || StringUtils.isEmpty(password)) {
            throw new ResultException(ResultEnum.USER_NAME_PWD_NULL);
        }

        // 获取Subject主体对象
        Subject subject = SecurityUtils.getSubject();

        // 封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        // 执行登录
        try {
            if(rememberMe != null) {
                token.setRememberMe(true);
            } else {
                token.setRememberMe(false);
            }
            subject.login(token);
            // 判断是否拥有后台角色
//            User user = ShiroUtil.getSubject();
//            if (user.getIsRole().equals(UserIsRoleEnum.YES.getCode())) {
//                return ResultVoUtil.success("登录成功", new URL("/main/index));
//            } else {
//                return ResultVoUtil.error("您不是后台管理员！");
//            }

            return ResultVoUtil.success("登录成功", new URL("/main/index"));

        }catch(Exception e) {
            return ResultVoUtil.error("用户名或密码输入错误！");
        }
    }

}
