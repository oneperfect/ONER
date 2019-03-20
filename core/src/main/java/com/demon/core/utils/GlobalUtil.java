package com.demon.core.utils;

import java.util.Random;

/**
 * @Auther: oneperfect
 * @Date: 2019/03/14
 */
public class GlobalUtil {

    public static String randomString(int length) {
        Random random = new Random();
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            int range = random.nextInt(75) + 48;
            chars[i] = (char) range;
        }
        return chars.toString();
    }
}
