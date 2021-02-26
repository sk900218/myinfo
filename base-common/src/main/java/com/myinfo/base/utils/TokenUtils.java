package com.myinfo.base.utils;

import java.util.Random;

/**
 * 令牌工具
 * @author 盛凯 2021-2-26
 */
public class TokenUtils {

    public static String buildToken() {
        String token = System.currentTimeMillis() + "" + new Random().nextInt(6);
        return MD5Util.encrypt(token);
    }

}
