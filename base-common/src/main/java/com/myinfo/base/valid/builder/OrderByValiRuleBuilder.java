package com.myinfo.base.valid.builder;

import com.myinfo.base.valid.ValidRule;
import com.myinfo.base.valid.rules.OrderByFieldValidRule;
import com.myinfo.base.valid.rules.OrderByRuleValidRule;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 排序校验规则
 * @author 盛凯 2021-1-4
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderByValiRuleBuilder extends ValiRuleBuilder {

    public OrderByValiRuleBuilder(String field, String name) {
        super(field, name);
    }

    @Override
    public OrderByValiRuleBuilder notNull() {
        return (OrderByValiRuleBuilder)super.notNull();
    }
    @Override
    public OrderByValiRuleBuilder notNull(String msg) {
        return (OrderByValiRuleBuilder)super.notNull(msg);
    }

    /**
     * 校验排序字段的正确性
     * @param clazz 实体类class
     */
    public OrderByValiRuleBuilder field(Class clazz) {
        ValidRule validRule = new OrderByFieldValidRule(clazz);
        this.addRule(validRule);
        return this;
    }

    /**
     * 校验排序字段的正确性
     * @param msg 返回说明
     * @param clazz 实体类class
     */
    public OrderByValiRuleBuilder field(String msg, Class clazz) {
        ValidRule validRule = new OrderByFieldValidRule(msg, clazz);
        this.addRule(validRule);
        return this;
    }

    /**
     * 校验正、倒序正确性
     */
    public OrderByValiRuleBuilder ascOrDesc() {
        ValidRule validRule = new OrderByRuleValidRule();
        this.addRule(validRule);
        return this;
    }

    /**
     * 校验正、倒序正确性
     * @param msg 返回说明
     */
    public OrderByValiRuleBuilder ascOrDesc(String msg) {
        ValidRule validRule = new OrderByRuleValidRule(msg);
        this.addRule(validRule);
        return this;
    }
}
