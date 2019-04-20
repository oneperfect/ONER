package com.demon.admin.system.validator;

import com.demon.admin.system.domain.Dept;
import com.demon.admin.system.domain.User;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @Author: oneperfect
 * @Date: 2019/4/9
 */
public class UserForm extends User implements Serializable {

    private Object entity;
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @NotEmpty(message = "用户昵称不能为空")
    @Size(min = 2, max = 20, message = "用户昵称：请输至少2个字符")
    private String nickname;

    private String confirm;
    @NotNull(message = "所在部门不能为空")
    private Dept dept;
}
