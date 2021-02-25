package com.myinfo.base.valid.rules;

import com.myinfo.base.valid.ValidParam;
import com.myinfo.base.valid.ValidResult;
import com.myinfo.base.valid.ValidRule;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Array;

/**
 * 非空校验
 * @author 盛凯 2020-12-24
 */
@Getter
@Setter
@NoArgsConstructor
public class NotNullValidRule extends ValidRule {

    public NotNullValidRule(String msg) {
        super(msg);
    }

    @Override
    public ValidResult vali(Object obj, ValidParam validParam) {
        ValidResult result = new ValidResult();
        result.setResult(true);

        String msg = StringUtils.isEmpty(super.msg) ? "[" + validParam.getName() + "]不可为空" : super.msg;

        if (obj == null) {
            result.setResult(false);
        } else {
            if (obj instanceof String) {
                if (StringUtils.isEmpty((String) obj)) {
                    result.setResult(false);
                }
            } else if (obj instanceof Array) {
                if (((Object[]) obj).length == 0) {
                    result.setResult(false);
                }
            }
        }

        if(!result.getResult()) {
            result.setMessage(msg);
        }

        return result;
    }
}
