package com.demon.core.vo;

import lombok.Data;

/**
 * 定义了页面返回数据的部分参数
 * @Auther: oneperfect
 * @Date: 2019/03/07
 */
@Data
public class ResultVo<T> {

    // 提示信息
    private String message;
    // 状态码
    private Integer code;
    // 数据信息
    private T data;

}
