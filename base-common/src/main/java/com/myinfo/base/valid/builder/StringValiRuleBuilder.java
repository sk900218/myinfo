package com.myinfo.base.valid.builder;

import com.myinfo.base.valid.ValidRule;
import com.myinfo.base.valid.rules.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 字符串校验规则
 * @author 盛凯 2020-12-25
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StringValiRuleBuilder extends ValiRuleBuilder {

    public StringValiRuleBuilder(String field, String name) {
        super(field, name);
    }

    @Override
    public StringValiRuleBuilder notNull() {
        return (StringValiRuleBuilder)super.notNull();
    }
    @Override
    public StringValiRuleBuilder notNull(String msg) {
        return (StringValiRuleBuilder)super.notNull(msg);
    }

    /**
     * 字符串固定值
     * @param spec
     */
    public StringValiRuleBuilder spec(String[] spec) {
        ValidRule validRule = new StringSpecValidRule(spec);
        this.addRule(validRule);
        return this;
    }

    /**
     * 字符串固定值
     * @param msg 返回说明
     * @param spec
     */
    public StringValiRuleBuilder spec(String msg, String[] spec) {
        ValidRule validRule = new StringSpecValidRule(msg, spec);
        this.addRule(validRule);
        return this;
    }

    /**
     * 字符串数组固定值
     * @param spec
     */
    public StringValiRuleBuilder arrSpec(String[] spec) {
        ValidRule validRule = new StringArrSpecValidRule(spec);
        this.addRule(validRule);
        return this;
    }

    /**
     * 字符串数组固定值
     * @param msg 返回说明
     * @param spec
     */
    public StringValiRuleBuilder arrSpec(String msg, String[] spec) {
        ValidRule validRule = new StringArrSpecValidRule(msg, spec);
        this.addRule(validRule);
        return this;
    }

    /**
     * 字符串最大长度
     * @param size
     */
    public StringValiRuleBuilder maxSize(int size) {
        ValidRule validRule = new StringSizeValidRule(null, size);
        this.addRule(validRule);
        return this;
    }

    /**
     * 字符串最大长度
     * @param msg 返回说明
     * @param size
     */
    public StringValiRuleBuilder maxSize(String msg, int size) {
        ValidRule validRule = new StringSizeValidRule(msg, null, size);
        this.addRule(validRule);
        return this;
    }

    /**
     * 字符串最小长度
     * @param size
     */
    public StringValiRuleBuilder minSize(int size) {
        ValidRule validRule = new StringSizeValidRule(size, null);
        this.addRule(validRule);
        return this;
    }

    /**
     * 字符串最小长度
     * @param msg 返回说明
     * @param size
     */
    public StringValiRuleBuilder minSize(String msg, int size) {
        ValidRule validRule = new StringSizeValidRule(msg, size, null);
        this.addRule(validRule);
        return this;
    }

    /**
     * 字符串范围长度
     * @param minSize 最小长度
     * @param maxSize 最大长度
     */
    public StringValiRuleBuilder rangeSize(int minSize, int maxSize) {
        ValidRule validRule = new StringSizeValidRule(minSize, maxSize);
        this.addRule(validRule);
        return this;
    }

    /**
     * 字符串范围长度
     * @param msg 返回说明
     * @param minSize 最小长度
     * @param maxSize 最大长度
     */
    public StringValiRuleBuilder rangeSize(String msg, int minSize, int maxSize) {
        ValidRule validRule = new StringSizeValidRule(msg, minSize, maxSize);
        this.addRule(validRule);
        return this;
    }

    /**
     * 校验手机号
     */
    public StringValiRuleBuilder mobile() {
        ValidRule validRule = new MobileValidRule();
        this.addRule(validRule);
        return this;
    }

    /**
     * 校验手机号
     * @param msg 返回说明
     */
    public StringValiRuleBuilder mobile(String msg) {
        ValidRule validRule = new MobileValidRule(msg);
        this.addRule(validRule);
        return this;
    }

    /**
     * 校验银行卡号
     */
    public StringValiRuleBuilder bankCard() {
        ValidRule validRule = new BankCardValidRule();
        this.addRule(validRule);
        return this;
    }

    /**
     * 校验银行卡号
     * @param msg 返回说明
     */
    public StringValiRuleBuilder bankCard(String msg) {
        ValidRule validRule = new BankCardValidRule(msg);
        this.addRule(validRule);
        return this;
    }

}
