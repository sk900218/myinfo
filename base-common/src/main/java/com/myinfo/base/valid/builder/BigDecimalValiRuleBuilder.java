package com.myinfo.base.valid.builder;

import com.myinfo.base.valid.ValidRule;
import com.myinfo.base.valid.rules.BigDecimalRangeValidRule;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 字符串校验规则
 * @author 盛凯 2020-12-25
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BigDecimalValiRuleBuilder extends ValiRuleBuilder {

    public BigDecimalValiRuleBuilder(String field, String name) {
        super(field, name);
    }

    @Override
    public BigDecimalValiRuleBuilder notNull() {
        return (BigDecimalValiRuleBuilder)super.notNull();
    }
    @Override
    public BigDecimalValiRuleBuilder notNull(String msg) {
        return (BigDecimalValiRuleBuilder)super.notNull(msg);
    }

    /**
     * 最大值
     * @param val
     */
    public BigDecimalValiRuleBuilder maxVal(BigDecimal val) {
        ValidRule validRule = new BigDecimalRangeValidRule(null, val);
        this.addRule(validRule);
        return this;
    }

    /**
     * 最大值
     * @param msg 返回说明
     * @param val
     */
    public BigDecimalValiRuleBuilder maxVal(String msg, BigDecimal val) {
        ValidRule validRule = new BigDecimalRangeValidRule(msg, null, val);
        this.addRule(validRule);
        return this;
    }

    /**
     * 最小值
     * @param val
     */
    public BigDecimalValiRuleBuilder minVal(BigDecimal val) {
        ValidRule validRule = new BigDecimalRangeValidRule(val, null);
        this.addRule(validRule);
        return this;
    }

    /**
     * 最小值
     * @param msg 返回说明
     * @param val
     */
    public BigDecimalValiRuleBuilder minVal(String msg, BigDecimal val) {
        ValidRule validRule = new BigDecimalRangeValidRule(msg, val, null);
        this.addRule(validRule);
        return this;
    }

    /**
     * 范围内值
     * @param minVal 最小值
     * @param maxVal 最大值
     */
    public BigDecimalValiRuleBuilder rangeVal(BigDecimal minVal, BigDecimal maxVal) {
        ValidRule validRule = new BigDecimalRangeValidRule(minVal, maxVal);
        this.addRule(validRule);
        return this;
    }

    /**
     * 范围内值
     * @param msg 返回说明
     * @param minVal 最小值
     * @param maxVal 最大值
     */
    public BigDecimalValiRuleBuilder rangeVal(String msg, BigDecimal minVal, BigDecimal maxVal) {
        ValidRule validRule = new BigDecimalRangeValidRule(msg, minVal, maxVal);
        this.addRule(validRule);
        return this;
    }

}
