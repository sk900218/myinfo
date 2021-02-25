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
 * 字符串固定值校验
 * @author 盛凯 2020-12-25
 */
@Getter
@Setter
public class StringSpecValidRule extends ValidRule {

    //固定值
    protected String[] spec;

    /**
     * 特定值
     * @param spec
     */
    public StringSpecValidRule(String[] spec) {
        this.spec = spec;
    }

    /**
     * 特定值
     * @param msg
     * @param spec
     */
    public StringSpecValidRule(String msg, String[] spec) {
        super(msg);
        this.spec = spec;
    }

    @Override
    public ValidResult vali(Object obj, ValidParam validParam) {
        ValidResult result = new ValidResult();
        result.setResult(false);

        String msg = StringUtils.isEmpty(super.msg) ? "[" + validParam.getName() + "]值错误，请输入[" + StringUtils.join(this.spec, ",") + "]" : super.msg;

        String val = (String)obj;

        if(this.spec != null) {
            //特定值
            List<String> list = Arrays.asList(this.spec);
            if(list.contains(val)) {
                result.setResult(true);
            } else {
                result.setMessage(msg);
            }
        }


        return result;
    }
}
