package com.myinfo.base.valid.rules;

import com.myinfo.base.valid.ValidParam;
import com.myinfo.base.valid.ValidResult;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * 字符串校验
 * @author 盛凯 2020-12-25
 */
@Slf4j
@Getter
@Setter
public class StringArrSpecValidRule extends StringSpecValidRule {

    /**
     * 特定值
     * @param spec
     */
    public StringArrSpecValidRule(String[] spec) {
        super(spec);
    }

    /**
     * 特定值
     * @param msg
     * @param spec
     */
    public StringArrSpecValidRule(String msg, String[] spec) {
        super(msg, spec);
    }

    @Override
    public ValidResult vali(Object obj, ValidParam validParam) {
        ValidResult result = new ValidResult();
        result.setResult(true);

        String msg = StringUtils.isEmpty(super.msg) ? "[" + validParam.getName() + "]请输入正确的值！" : super.msg;

        //校验
        String[] val = null;
        try {
            val = (String[])obj;
        } catch (ClassCastException e) {
            log.error("类型转换异常！{}", val);
            result.setResult(false);
            result.setMessage(msg);
            return result;
        }

        for(String v : val) {
            result = super.vali(v, validParam);
            if(!result.getResult()) {
                return result;
            }
        }

        return result;
    }

}
