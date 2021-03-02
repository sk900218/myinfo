package com.myinfo.base.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Gson工具类
 * @author 盛凯 2020-12-22
 */
public class GsonUtils {

    /**
     * 生成普通gson对象
     * @return
     */
    public static Gson build() {
        return new GsonBuilder().create();
    }

    /**
     * 生成带格式化的gson对象
     * @return
     */
    public static Gson buildFormat() {
        return new GsonBuilder().setPrettyPrinting().create();
    }

    /**
     * 生成日期格式化后的gson对象
     * @param pattern 年月日时分秒，如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Gson buildToFormatDate(String pattern) {
        return new GsonBuilder().setDateFormat(pattern).create();
    }

    /**
     * 对象返回json串
     * @param obj
     * @return
     */
    public static String objToJson(Object obj) {
        return build().toJson(obj);
    }

    /**
     * json字符串打印
     * @param json
     * @return
     */
    public static String jsonPrint(String json) {
        JsonElement je = new JsonParser().parse(json);
        return buildFormat().toJson(je).toString();
    }

}
