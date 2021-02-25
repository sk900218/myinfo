package com.myinfo.base.valid.rules;

import com.myinfo.base.valid.ValidParam;
import com.myinfo.base.valid.ValidResult;
import com.myinfo.base.valid.ValidRule;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Integer固定值校验
 * @author 盛凯 2020-12-25
 */
@Getter
@Setter
public class IntegerSpecValidRule extends ValidRule {

    //特定值
    protected Integer[] spec;

    /**
     * 特定值
     * @param spec
     */
    public IntegerSpecValidRule(Integer[] spec) {
        this.spec = spec;
    }

    /**
     * 特定值
     * @param msg
     * @param spec
     */
    public IntegerSpecValidRule(String msg, Integer[] spec) {
        super(msg);
        this.spec = spec;
    }

    @Override
    public ValidResult vali(Object obj, ValidParam validParam) {
        ValidResult result = new ValidResult();
        result.setResult(false);

        String msg = StringUtils.isEmpty(super.msg) ? "[" + validParam.getName() + "]值错误，请输入[" + StringUtils.join(this.spec, ",") + "]" : super.msg;

        //校验
        Integer val = (Integer)obj;

        if(spec != null) {
            //特定值
            List<Integer> list = Arrays.asList(spec);
            if(list.contains(val)) {
                result.setResult(true);
            } else {
                result.setMessage(msg);
            }
        }

        return result;
    }

}
