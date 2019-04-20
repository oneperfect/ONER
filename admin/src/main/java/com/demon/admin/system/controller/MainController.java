package com.demon.admin.system.controller;

import com.demon.admin.core.constant.AdminConst;
import com.demon.admin.core.enums.MenuTypeEnum;
import com.demon.admin.core.enums.ResultEnum;
import com.demon.admin.core.enums.StatusEnum;
import com.demon.admin.core.exception.ResultException;
import com.demon.admin.core.shiro.ShiroUtil;
import com.demon.admin.system.domain.Menu;
import com.demon.admin.system.domain.User;
import com.demon.admin.system.service.MenuService;
import com.demon.admin.system.service.UserService;
import com.demon.admin.system.validator.UserForm;
import com.demon.core.utils.ResultVoUtil;
import com.demon.core.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: oneperfect
 * @Date: 2019/02/28
 */

@Controller
@RequestMapping("/main")
public class MainController implements ErrorController{

    @Autowired
    private MenuService menuService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String main(Model model) {
        // 获取当前登录用户的数据
        User user = ShiroUtil.getSubject();
        // 菜单键值对(ID->菜单)
        Map<Long, Menu> keyMenu = new HashMap<>();

        // 管理员实时更新菜单
        if(AdminConst.ADMIN_ID.equals(user.getId())){
            Sort sort = new Sort(Sort.Direction.ASC, "sort");
            List<Menu> menus = menuService.getList(sort);
            menus.forEach(menu -> keyMenu.put(menu.getId(), menu));
        }else{
            // 其他用户需从相应的角色中获取菜单资源
            user.getRoles().forEach(role -> {
                role.getMenus().forEach(menu -> {
                    if(StatusEnum.OK.getCode().equals(menu.getStatus())){
                        keyMenu.put(menu.getId(), menu);
                    }
                });
            });
        }

        // 封装菜单树形数据
        Map<Long,Menu> treeMenu = new HashMap<>();
        keyMenu.forEach((id, menu) -> {
            if(!MenuTypeEnum.NOT_MENU.getCode().equals(menu.getType())){
                if(keyMenu.get(menu.getPid()) != null){
                    keyMenu.get(menu.getPid()).getChildren().put(Long.valueOf(menu.getSort()), menu);
                }else{
                    if(MenuTypeEnum.TOP_LEVEL.getCode().equals(menu.getType())){
                        treeMenu.put(Long.valueOf(menu.getSort()), menu);
                    }
                }
            }
        });

        model.addAttribute("user", user);
        model.addAttribute("treeMenu", treeMenu);
        return "/main";
    }

    /**
     * 跳转到系统主页
     */
    @GetMapping("/index")
    public String index() {
        return "/system/main/index";
    }

    /**
     * 跳转到修改密码页面
     */
    @GetMapping("/edit_pwd")
    public String editPwd() {
        return "/system/main/edit_pwd";
    }

    /**
     * 用户修改自己的密码
     */
    @PostMapping("/update_pwd")
    @ResponseBody
    public ResultVo updatePwd(String original, String password, String confirm) {
        // 获取当前登录用户的数据
        User user = ShiroUtil.getSubject();
        // 加密用户输入的原始密码
        String originalPwd = ShiroUtil.encryption(original, user.getSalt());
        // 判断密码是否匹配
        if(original.isEmpty() || "".equals(original.trim()) || !user.getPassword().equals(originalPwd)) {
            throw new ResultException(ResultEnum.USER_OLD_PWD_ERROR);
        }

        // 判断新密码是否有效
        if(password.isEmpty() || "".equals(password.trim())) {
            throw new ResultException(ResultEnum.USER_PWD_NULL);
        }

        // 判断两次密码是否一致
        if(!password.equals(confirm)) {
            throw new ResultException(ResultEnum.USER_INEQUALITY);
        }

        // 保存新密码
        User newUser = userService.findById(user.getId());
        String newSalt = ShiroUtil.randomSalt();
        String newPwd = ShiroUtil.encryption(password, newSalt);
        newUser.setPassword(newPwd);
        newUser.setSalt(newSalt);
        // 保存新用户数据
        userService.save(newUser);

        return ResultVoUtil.success("保存成功");
    }

    /**
     * 跳转到个人信息页面
     */
    @GetMapping("/user_info")
    public String userInfo(Model model) {
        User user = ShiroUtil.getSubject();
        model.addAttribute("user", user);
        return "/system/main/user_info";
    }

    /**
     * 用户修改自己的数据
     */
    @PostMapping("update_user_info")
    @ResponseBody
    public ResultVo updateUserInfo(@Validated UserForm userForm) {

        return null;
    }

    /**
     * 修改用户头像
     */
    @PostMapping("update_user_picture")
    @ResponseBody
    public ResultVo updateUserPicture(@Validated UserForm userForm) {

        return null;
    }

    /**
     * 处理错误页面
     */
    @GetMapping("/error")
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
        return "/main/error";
    }

}
