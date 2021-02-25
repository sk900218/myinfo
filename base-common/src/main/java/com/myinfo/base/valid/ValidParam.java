package com.myinfo.base.valid;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * 参数校验
 * @author 盛凯 2020-12-25
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ValidParam {

    //字段
    private String field;
    //字段名
    private String name;
    //规则集合
    private ArrayList<ValidRule> ruleList;

    public ValidParam(String field, String name) {
        this.field = field;
        this.name = name;
    }

    /**
     * 添加规则
     * @param rule
     */
    public ValidParam addRule(ValidRule rule) {
        if(ruleList == null) {
            ruleList = new ArrayList<>();
        }
        ruleList.add(rule);
        return this;
    }

}
