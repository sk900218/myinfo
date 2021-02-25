package com.myinfo.base.valid.builder;

import com.myinfo.base.valid.ValidRule;
import com.myinfo.base.valid.rules.DateBetweenValidRule;
import com.myinfo.base.valid.rules.DatePrevNextValidRule;
import com.myinfo.base.valid.rules.DateTimePrevNextValidRule;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 日期时间校验
 * @author 盛凯 2021-1-4
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DateValiRuleBuilder extends ValiRuleBuilder {

    public DateValiRuleBuilder(String field, String name) {
        super(field, name);
    }

    @Override
    public DateValiRuleBuilder notNull() {
        return (DateValiRuleBuilder)super.notNull();
    }
    @Override
    public DateValiRuleBuilder notNull(String msg) {
        return (DateValiRuleBuilder)super.notNull(msg);
    }

    /**
     * 最大时间
     * @param val
     */
    public DateValiRuleBuilder maxTime(Date val) {
        ValidRule validRule = new DateBetweenValidRule(null, val);
        this.addRule(validRule);
        return this;
    }

    /**
     * 最大时间
     * @param msg 返回说明
     * @param val
     */
    public DateValiRuleBuilder maxTime(String msg, Date val) {
        ValidRule validRule = new DateBetweenValidRule(msg, null, val);
        this.addRule(validRule);
        return this;
    }

    /**
     * 最小时间
     * @param val
     */
    public DateValiRuleBuilder minTime(Date val) {
        ValidRule validRule = new DateBetweenValidRule(val, null);
        this.addRule(validRule);
        return this;
    }

    /**
     * 最小时间
     * @param msg 返回说明
     * @param val
     */
    public DateValiRuleBuilder minTime(String msg, Date val) {
        ValidRule validRule = new DateBetweenValidRule(msg, val, null);
        this.addRule(validRule);
        return this;
    }

    /**
     * 范围时间
     * @param startDate 最小值
     * @param endDate 最大值
     */
    public DateValiRuleBuilder rangeTime(Date startDate, Date endDate) {
        ValidRule validRule = new DateBetweenValidRule(startDate, endDate);
        this.addRule(validRule);
        return this;
    }

    /**
     * 范围时间
     * @param msg 返回说明
     * @param startDate 最小值
     * @param endDate 最大值
     */
    public DateValiRuleBuilder rangeTime(String msg, Date startDate, Date endDate) {
        ValidRule validRule = new DateBetweenValidRule(msg, startDate, endDate);
        this.addRule(validRule);
        return this;
    }

    /**
     * 小于时间
     * @param date 日期
     */
    public DateValiRuleBuilder lessTime(Date date) {
        ValidRule validRule = new DateTimePrevNextValidRule(-1, date);
        this.addRule(validRule);
        return this;
    }

    /**
     * 小于时间
     * @param msg 返回说明
     * @param date 日期
     */
    public DateValiRuleBuilder lessTime(String msg, Date date) {
        ValidRule validRule = new DateTimePrevNextValidRule(msg, -1, date);
        this.addRule(validRule);
        return this;
    }

    /**
     * 等于时间
     * @param date 日期
     */
    public DateValiRuleBuilder equalsTime(Date date) {
        ValidRule validRule = new DateTimePrevNextValidRule(0, date);
        this.addRule(validRule);
        return this;
    }

    /**
     * 等于时间
     * @param msg 返回说明
     * @param date 日期
     */
    public DateValiRuleBuilder equalsTime(String msg, Date date) {
        ValidRule validRule = new DateTimePrevNextValidRule(msg, 0, date);
        this.addRule(validRule);
        return this;
    }

    /**
     * 大于时间
     * @param date 日期
     */
    public DateValiRuleBuilder greaterTime(Date date) {
        ValidRule validRule = new DateTimePrevNextValidRule(1, date);
        this.addRule(validRule);
        return this;
    }

    /**
     * 大于时间
     * @param msg 返回说明
     * @param date 日期
     */
    public DateValiRuleBuilder greaterTime(String msg, Date date) {
        ValidRule validRule = new DateTimePrevNextValidRule(msg, 1, date);
        this.addRule(validRule);
        return this;
    }

    /**
     * 小于日期
     * @param date 日期
     */
    public DateValiRuleBuilder lessDate(Date date) {
        ValidRule validRule = new DatePrevNextValidRule(-1, date);
        this.addRule(validRule);
        return this;
    }

    /**
     * 小于日期
     * @param msg 返回说明
     * @param date 日期
     */
    public DateValiRuleBuilder lessDate(String msg, Date date) {
        ValidRule validRule = new DatePrevNextValidRule(msg, -1, date);
        this.addRule(validRule);
        return this;
    }

    /**
     * 等于日期
     * @param date 日期
     */
    public DateValiRuleBuilder equalsDate(Date date) {
        ValidRule validRule = new DatePrevNextValidRule(0, date);
        this.addRule(validRule);
        return this;
    }

    /**
     * 等于日期
     * @param msg 返回说明
     * @param date 日期
     */
    public DateValiRuleBuilder equalsDate(String msg, Date date) {
        ValidRule validRule = new DatePrevNextValidRule(msg, 0, date);
        this.addRule(validRule);
        return this;
    }

    /**
     * 大于日期
     * @param date 日期
     */
    public DateValiRuleBuilder greaterDate(Date date) {
        ValidRule validRule = new DatePrevNextValidRule(1, date);
        this.addRule(validRule);
        return this;
    }

    /**
     * 大于日期
     * @param msg 返回说明
     * @param date 日期
     */
    public DateValiRuleBuilder greaterDate(String msg, Date date) {
        ValidRule validRule = new DatePrevNextValidRule(msg, 1, date);
        this.addRule(validRule);
        return this;
    }
}
