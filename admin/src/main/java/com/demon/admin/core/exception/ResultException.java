package com.demon.admin.core.exception;

import com.demon.admin.core.enums.ResultEnum;

/**
 * @Auther: oneperfect
 * @Date: 2019/03/08
 */
public class ResultException extends RuntimeException {

    private Integer code;

    /**
     * 统一异常处理
     * @param resultEnum 状态枚举
     */
    public ResultException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    /**
     * 统一异常处理
     * @param code 状态码
     * @param message 提示信息
     */
    public ResultException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
