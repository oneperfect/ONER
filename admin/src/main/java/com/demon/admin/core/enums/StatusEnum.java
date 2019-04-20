package com.demon.admin.core.enums;

import lombok.Getter;

/**
 * @Author: oneperfect
 * @Date: 2019/4/3
 */
@Getter
public enum StatusEnum {

    OK((byte)1, "启用"),
    FREEZED((byte)2, "冻结"),
    DELETE((byte)3, "删除");

    private Byte code;
    private String message;

    StatusEnum(Byte code, String message) {
        this.code = code;
        this.message = message;
    }}
