package com.myinfo.base.consts;

/**
 * 系统常量
 */
public class SystemConst {

    /*注意：密码盐长度和密码散列次数，一旦修改，所有用户将变得不可用*/
    //密码盐长度
    public static final int PASSWORD_SALT_LENGTH = 6;
    //密码散列次数
    public static final int PASSWORD_HASH_NUMBER = 1024;

    /*服务相关*/
    //用户服务名称
    public static final String EUREKA_USER_SERVER = "user-server";
}
