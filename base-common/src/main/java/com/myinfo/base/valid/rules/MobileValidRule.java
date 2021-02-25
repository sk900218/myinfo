package com.myinfo.base.valid.rules;


import com.myinfo.base.valid.ValidParam;
import com.myinfo.base.valid.ValidResult;
import com.myinfo.base.valid.ValidRule;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 手机号验证规则
 * @author 盛凯 2020-12-25
 */
@Getter
@Setter
@NoArgsConstructor
public class MobileValidRule extends ValidRule {

    public MobileValidRule(String msg) {
        super(msg);
    }

    @Override
    public ValidResult vali(Object obj, ValidParam validParam) {
        ValidResult result = new ValidResult();
        result.setResult(false);

        //校验
        String val = (String)obj;

        String msg = StringUtils.isEmpty(super.msg) ? "[" + validParam.getName() + "]请输入正确的手机号" : super.msg;

        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        if (val.length() != 11) {
            result.setMessage(msg);
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(val);
            boolean isMatch = m.matches();
            if (isMatch) {
                result.setResult(true);
            } else {
                result.setMessage(msg);
            }
        }

        return result;
    }

}
