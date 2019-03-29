package com.demon.admin.core.enums;

import lombok.Getter;
/**
 * 数据库角色状态字段
 * @Author: oneperfect
 * @Date: 2019/3/22
 */

@Getter
public enum UserIsRoleEnum {

    YES((byte)1, "是后台管理员"),
    NO((byte)2, "不是后台管理员");

    private Byte code;
    private String message;

    UserIsRoleEnum(Byte code, String message) {
        this.code = code;
        this.message = message;
    }
}
