package com.demon.admin.core.enums;

import lombok.Getter;

/**
 * @Author: oneperfect
 * @Date: 2019/4/3
 */
@Getter
public enum MenuTypeEnum {

    TOP_LEVEL((byte)1, "一级菜单"),
    SUB_LEVEL((byte)2, "子级菜单"),
    NOT_MENU((byte)3, "不是菜单");

    public Byte code;
    public String message;

    MenuTypeEnum(Byte code, String message) {
        this.code = code;
        this.message = message;
    }}
