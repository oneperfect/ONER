package com.demon.admin.system.controller;

import com.demon.admin.core.constant.AdminConst;
import com.demon.admin.core.enums.MenuTypeEnum;
import com.demon.admin.core.enums.UserStatusEnum;
import com.demon.admin.core.shiro.ShiroUtil;
import com.demon.admin.system.domain.Menu;
import com.demon.admin.system.domain.User;
import com.demon.admin.system.service.MenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
                    if(UserStatusEnum.OK.getCode().equals(menu.getStatus())){
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

    @GetMapping("/index")
    public String index() {
        return "/system/main/index";
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
