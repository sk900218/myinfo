package com.myinfo.base.valid.rules;

import com.myinfo.base.valid.ValidParam;
import com.myinfo.base.valid.ValidResult;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * Integer数组固定值校验
 * @author 盛凯 2020-12-25
 */
@Slf4j
@Getter
@Setter
public class IntegerArrSpecValidRule extends IntegerSpecValidRule {

    //特定值
    protected Integer[] spec;

    /**
     * 特定值
     * @param spec
     */
    public IntegerArrSpecValidRule(Integer[] spec) {
        super(spec);
    }

    /**
     * 特定值
     * @param msg
     * @param spec
     */
    public IntegerArrSpecValidRule(String msg, Integer[] spec) {
        super(msg, spec);
    }

    @Override
    public ValidResult vali(Object obj, ValidParam validParam) {
        ValidResult result = new ValidResult();
        result.setResult(true);

        String msg = StringUtils.isEmpty(super.msg) ? "[" + validParam.getName() + "]请输入正确的值！" : super.msg;

        //校验
        Integer[] val = null;
        try {
            val = (Integer[])obj;
        } catch (ClassCastException e) {
            log.error("类型转换异常！{}", val);
            result.setResult(false);
            result.setMessage(msg);
            return result;
        }

        for(Integer v : val) {
            result = super.vali(v, validParam);
            if(!result.getResult()) {
                return result;
            }
        }

        return result;
    }

}
