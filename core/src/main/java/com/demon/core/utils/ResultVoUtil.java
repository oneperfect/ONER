package com.demon.core.utils;

import com.demon.core.enums.StatuCodeEnum;
import com.demon.core.url.URL;
import com.demon.core.vo.ResultVo;

/**
 * 封装页面返回数据的工具类
 * @Auther: oneperfect
 * @Date: 2019/03/07
 */
public class ResultVoUtil {

    public static final ResultVo SAVE_SUCCESS = success("保存成功");

    /**
     * 操作成功
     * @param message 提示信息
     * @param object 数据对象
     * @return 页面数据
     */
    public static ResultVo success(String message, Object object) {
        ResultVo resultVo = new ResultVo();
        resultVo.setMessage(message);
        resultVo.setData(object);
        resultVo.setCode(StatuCodeEnum.SUCCESS.getCode());
        return resultVo;
    }

    /**
     * 操作成功，返回默认信息
     * @param message 提示信息
     * @return
     */
    public static ResultVo success(String message) {
        Object Object = null;
        return success(message, Object);
    }

    /**
     * 操作成功，返回地址信息
     * @param message 提示信息
     * @param url 地址信息
     * @return
     */
    public static ResultVo success(String message, URL url) {
        return success(message, url.getUrl());
    }

    /**
     * 操作失败，返回错误信息
     * @param statuCode
     * @param message
     * @return
     */
    public static ResultVo error(Integer statuCode, String message){
        ResultVo resultVo = new ResultVo();
        resultVo.setMessage(message);
        resultVo.setCode(statuCode);
        return resultVo;
    }

    /**
     * 操作有误，使用默认400错误码
     * @param message 提示信息
     */
    public static ResultVo error(String message){
        Integer code = StatuCodeEnum.ERROR.getCode();
        return error(code, message);
    }

}
