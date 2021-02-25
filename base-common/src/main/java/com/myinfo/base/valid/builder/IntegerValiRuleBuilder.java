package com.myinfo.base.valid.builder;

import com.myinfo.base.valid.ValidRule;
import com.myinfo.base.valid.rules.IntegerArrSpecValidRule;
import com.myinfo.base.valid.rules.IntegerRangeValidRule;
import com.myinfo.base.valid.rules.IntegerSpecValidRule;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 字符串校验规则
 * @author 盛凯 2020-12-25
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IntegerValiRuleBuilder extends ValiRuleBuilder {

    public IntegerValiRuleBuilder(String field, String name) {
        super(field, name);
    }

    @Override
    public IntegerValiRuleBuilder notNull() {
        return (IntegerValiRuleBuilder)super.notNull();
    }
    @Override
    public IntegerValiRuleBuilder notNull(String msg) {
        return (IntegerValiRuleBuilder)super.notNull(msg);
    }

    /**
     * 固定值
     * @param spec
     */
    public IntegerValiRuleBuilder spec(Integer[] spec) {
        ValidRule validRule = new IntegerSpecValidRule(spec);
        this.addRule(validRule);
        return this;
    }

    /**
     * 固定值
     * @param msg 返回说明
     * @param spec
     */
    public IntegerValiRuleBuilder spec(String msg, Integer[] spec) {
        ValidRule validRule = new IntegerSpecValidRule(msg, spec);
        this.addRule(validRule);
        return this;
    }

    /**
     * 最大值
     * @param val
     */
    public IntegerValiRuleBuilder maxVal(int val) {
        ValidRule validRule = new IntegerRangeValidRule(null, val);
        this.addRule(validRule);
        return this;
    }

    /**
     * 最大值
     * @param msg 返回说明
     * @param val
     */
    public IntegerValiRuleBuilder maxVal(String msg, int val) {
        ValidRule validRule = new IntegerRangeValidRule(msg, null, val);
        this.addRule(validRule);
        return this;
    }

    /**
     * 最小值
     * @param val
     */
    public IntegerValiRuleBuilder minVal(int val) {
        ValidRule validRule = new IntegerRangeValidRule(val, null);
        this.addRule(validRule);
        return this;
    }

    /**
     * 最小值
     * @param msg 返回说明
     * @param val
     */
    public IntegerValiRuleBuilder minVal(String msg, int val) {
        ValidRule validRule = new IntegerRangeValidRule(msg, val, null);
        this.addRule(validRule);
        return this;
    }

    /**
     * 范围内值
     * @param minVal 最小值
     * @param maxVal 最大值
     */
    public IntegerValiRuleBuilder rangeVal(int minVal, int maxVal) {
        ValidRule validRule = new IntegerRangeValidRule(minVal, maxVal);
        this.addRule(validRule);
        return this;
    }

    /**
     * 范围内值
     * @param msg 返回说明
     * @param minVal 最小值
     * @param maxVal 最大值
     */
    public IntegerValiRuleBuilder rangeVal(String msg, int minVal, int maxVal) {
        ValidRule validRule = new IntegerRangeValidRule(msg, minVal, maxVal);
        this.addRule(validRule);
        return this;
    }

    /**
     * 整型数组固定值
     * @param spec
     */
    public IntegerValiRuleBuilder arrSpec(Integer[] spec) {
        ValidRule validRule = new IntegerArrSpecValidRule(spec);
        this.addRule(validRule);
        return this;
    }

    /**
     * 整型数组固定值
     * @param msg 返回说明
     * @param spec
     */
    public IntegerValiRuleBuilder arrSpec(String msg, Integer[] spec) {
        ValidRule validRule = new IntegerArrSpecValidRule(msg, spec);
        this.addRule(validRule);
        return this;
    }

}
