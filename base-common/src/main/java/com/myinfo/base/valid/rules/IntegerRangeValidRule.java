package com.myinfo.base.valid.rules;

import com.myinfo.base.valid.ValidParam;
import com.myinfo.base.valid.ValidResult;
import com.myinfo.base.valid.ValidRule;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

/**
 * Integer范围规则
 * @author 盛凯 2020-12-25
 */
@Getter
@Setter
public class IntegerRangeValidRule extends ValidRule {

    //最大值
    protected Integer max;
    //最小值
    protected Integer min;

    /**
     * 最小值or最大值，可传null
     * @param min
     * @param max
     */
    public IntegerRangeValidRule(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    /**
     * 最小值or最大值，可传null
     * @param msg
     * @param min
     * @param max
     */
    public IntegerRangeValidRule(String msg, Integer min, Integer max) {
        super(msg);
        this.min = min;
        this.max = max;
    }

    @Override
    public ValidResult vali(Object obj, ValidParam validParam) {
        ValidResult result = new ValidResult();
        result.setResult(false);

        //校验
        Integer val = (Integer)obj;

        if (this.max != null && this.min != null) {
            //范围
            if (!(val >= this.min && val <= this.max)) {
                result.setMessage("[" + validParam.getName() + "]值不对，请输入" + this.min + "到" + this.max + "之间的整数");
            }
        } else if (this.min != null) {
            //校验最小长度
            if (val < this.min) {
                result.setMessage("[" + validParam.getName() + "]值不对，请输入大于等于" + this.min + "的整数");
            }
        } else if (this.max != null) {
            //校验最小长度
            if (val > this.max) {
                result.setMessage("[" + validParam.getName() + "]值不对，请输入小于等于" + this.max + "的整数");
            }
        }

        if(result.getMessage() == null) {
            result.setResult(true);
        } else if(!StringUtils.isEmpty(super.msg)) {
            result.setMessage(msg);
        }

        return result;
    }

}
