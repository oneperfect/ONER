package com.demon.admin.core.shiro;

import com.demon.core.utils.GlobalUtil;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @Auther: oneperfect
 * @Date: 2019/03/14
 */
public class ShiroUtil {
    /**
     * 加密算法
     */
    private static final String hashAlgorithmName = "SHA-256";

    /**
     * 加密次数
     */
    private static final Integer hashInerations = 996;

    /**
     * 密码加密
     * @param password 密码
     * @param salt 盐值
     * @return 返回加密后的新密码
     */
    public static String encryption(String password, String salt) {
        return new SimpleHash(hashAlgorithmName, password, salt, hashInerations).toString();
    }

    /**
     * 获取随机盐值
     * @return 返回盐值字符串
     */
    public static String randomSalt() {
        return GlobalUtil.randomString(6);
    }

}
