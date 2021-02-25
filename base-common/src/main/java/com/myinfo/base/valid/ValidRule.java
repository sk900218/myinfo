package com.myinfo.base.valid;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 校验规则
 * @author 盛凯 2020-12-24
 */
@NoArgsConstructor
@AllArgsConstructor
public abstract class ValidRule {

    protected String msg;

    /**
     * 校验
     * @param obj 校验对象
     * @return
     */
    public abstract ValidResult vali(Object obj, ValidParam validParam);

}
