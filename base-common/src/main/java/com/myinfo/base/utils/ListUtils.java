package com.myinfo.base.utils;

import java.util.List;

public class ListUtils {

    /**
     * 校验list是否为空
     * @param list
     * @return
     */
    public static boolean isEmpty(List list) {
        return !(list != null && list.size() > 0);
    }

}
