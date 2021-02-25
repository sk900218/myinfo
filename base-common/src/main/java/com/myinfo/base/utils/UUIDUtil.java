package com.myinfo.base.utils;

import java.util.UUID;

/**
 * 生成数据库表主键
 * @author 盛凯 2021-2-24
 **/
public class UUIDUtil {
    /**
     * 用来生成数据库表的主键ID
     * @return
     */
	public static String buildUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }
}
