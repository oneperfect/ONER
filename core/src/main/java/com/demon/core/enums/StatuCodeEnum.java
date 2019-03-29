package com.demon.core.enums;

import lombok.Getter;

/**
 * 通用状态信息
 * @Auther: oneperfect
 * @Date: 2019/03/08
 */

@Getter
public enum StatuCodeEnum {

    SUCCESS(200, "成功"),
    ERROR(400, "错误");

    private Integer code;

    private String message;

    StatuCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
