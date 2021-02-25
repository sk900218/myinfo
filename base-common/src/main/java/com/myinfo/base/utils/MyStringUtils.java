package com.myinfo.base.utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * @author 盛凯 2021-1-4
 */
public class MyStringUtils {

    private static Pattern linePattern = Pattern.compile("_(\\w)");
    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    /**
     * 下划线转驼峰
     * @param str
     * @return
     */
    public static String lineToHump(String str) {
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 驼峰转下划线
     * @param str
     * @return
     */
    public static String humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 获取小写英文+数字随机数
     * @param num 位数
     * @return
     */
    public static String getSmallEnglishAndNumberRandom(int num) {
        String str = "abcdefghijklmnopqrstuvwxyz0123456789";
        return buildRandom(str, num);
    }

    /**
     * 生成随机字符
     * @param str 被随机的字符
     * @param num 位数
     * @return
     */
    public static String buildRandom(String str, int num) {
        StringBuffer result = new StringBuffer();
        Random random = new Random();
        for(int i=0; i<num; i++) {
            int index = random.nextInt(str.length());
            result.append(str.charAt(index));
        }
        return result.toString();
    }

    /**
     * 生成以数组为内容的N位随机数
     * @param num
     * @return
     */
    public static String getNumberRandom(int num) {
        String str = "0123456789";
        return buildRandom(str, num);
    }

}
