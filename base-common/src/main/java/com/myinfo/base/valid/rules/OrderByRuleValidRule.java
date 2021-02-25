package com.myinfo.base.valid.rules;

import com.myinfo.base.valid.ValidParam;
import com.myinfo.base.valid.ValidResult;
import com.myinfo.base.valid.ValidRule;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

/**
 * 排序校验规则字符串是否正确
 * @author 盛凯 2021-1-4
 */
@Getter
@Setter
public class OrderByRuleValidRule extends ValidRule {

    public OrderByRuleValidRule() {}

    public OrderByRuleValidRule(String msg) {
        super(msg);
    }

    @Override
    public ValidResult vali(Object obj, ValidParam validParam) {
        ValidResult result = new ValidResult();
        result.setResult(false);

        //校验
        String val = (String)obj;
        String[] arr = {"asc", "desc"};

        for(String t : arr) {
            if(t.equals(val)) {
                //找到对应值
                result.setResult(true);
                return result;
            }
        }
        //非法传值
        if(StringUtils.isEmpty(this.msg)) {
            result.setMessage("[" + validParam.getName() + "]请输入正确的值！");
        } else {
            result.setMessage(this.msg);
        }

        return result;
    }

}
