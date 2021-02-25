package com.myinfo.base.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 数组工具类
 * @author 盛凯 2020-12-31
 */
public class ArrayUtils {

    /**
     * 校验数组是否为空
     * @param objs
     * @return
     */
    public static boolean isEmpty(Object[] objs) {
        return objs == null || objs.length == 0 || objs[0] == null || StringUtils.isEmpty((String)objs[0]);
    }

}
