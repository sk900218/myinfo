package com.myinfo.base.valid.builder;

import com.myinfo.base.valid.ValidParam;
import com.myinfo.base.valid.ValidRule;
import com.myinfo.base.valid.rules.NotNullValidRule;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 校验规则生成
 * @author 2020-12-25
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ValiRuleBuilder extends ValidParam {

    public ValiRuleBuilder(String field, String name) {
        super(field, name);
    }

    /**
     * 不允许为空
     * @return
     */
    public ValiRuleBuilder notNull() {
        ValidRule validRule = new NotNullValidRule();
        this.addRule(validRule);
        return this;
    }

    /**
     * 不允许为空
     * @param msg 返回说明
     * @return
     */
    public ValiRuleBuilder notNull(String msg) {
        ValidRule validRule = new NotNullValidRule(msg);
        this.addRule(validRule);
        return this;
    }

}
