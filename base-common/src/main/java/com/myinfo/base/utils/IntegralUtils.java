package com.myinfo.base.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 积分工具类
 * @author 盛凯 2021-1-13
 */
public class IntegralUtils {

    /**
     * 积分转金额
     * @param rate 比例
     * @param integral 积分
     * @return
     */
    public static BigDecimal integralToMoney(int rate, int integral) {
        BigDecimal result = new BigDecimal(integral / (double)rate).setScale(2, RoundingMode.FLOOR);
        return result;
    }

    /**
     * 金额转积分
     * @param rate 比例
     * @param money 金额
     * @return
     */
    public static Integer moneyToIntegral(int rate, BigDecimal money) {
        Integer result = BigDecimal.valueOf(money.doubleValue() * rate).setScale(0, RoundingMode.FLOOR).intValue();
        return result;
    }

}
