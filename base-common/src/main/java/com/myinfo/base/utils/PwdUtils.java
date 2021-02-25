package com.myinfo.base.utils;

import java.util.Random;

/**
 * 密码工具类
 * @author 盛凯 2021-2-25
 */
public class PwdUtils {

    /**
     * 生成加密后的密码
     * @param pwd 原始密码
     * @param salt 密码盐
     * @param hashNum 散列次数
     * @return
     */
    public static String buildMd5Pwd(String pwd, String salt, Integer hashNum) {
        //加密拼接
        String str = pwd + salt;
        int num = hashNum == null ? 1 : hashNum;
        String result = str;
        for(int i=0; i<num; i++) {
            result = MD5Util.encrypt(result);
        }
        return result;
    }

    /**
     * 生成密码盐
     * @param num 位数
     * @return
     */
    public static String buildSalt(int num) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$^&*()";
        StringBuffer result = new StringBuffer();
        Random random = new Random();
        for(int i=0; i<num; i++) {
            int index = random.nextInt(str.length());
            result.append(str.charAt(index));
        }
        return result.toString();
    }
}
