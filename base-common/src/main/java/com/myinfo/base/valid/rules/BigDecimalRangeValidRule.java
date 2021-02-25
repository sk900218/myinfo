package com.myinfo.base.valid.rules;

import com.myinfo.base.valid.ValidParam;
import com.myinfo.base.valid.ValidResult;
import com.myinfo.base.valid.ValidRule;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * Integer范围规则
 * @author 盛凯 2020-12-25
 */
@Getter
@Setter
public class BigDecimalRangeValidRule extends ValidRule {

    //最大值
    protected BigDecimal max;
    //最小值
    protected BigDecimal min;

    /**
     * 最小值or最大值，可传null
     * @param min
     * @param max
     */
    public BigDecimalRangeValidRule(BigDecimal min, BigDecimal max) {
        this.min = min;
        this.max = max;
    }

    /**
     * 最小值or最大值，可传null
     * @param msg
     * @param min
     * @param max
     */
    public BigDecimalRangeValidRule(String msg, BigDecimal min, BigDecimal max) {
        super(msg);
        this.min = min;
        this.max = max;
    }

    @Override
    public ValidResult vali(Object obj, ValidParam validParam) {
        ValidResult result = new ValidResult();
        result.setResult(false);

        //校验
        Double val = ((BigDecimal)obj).doubleValue();

        if (this.max != null && this.min != null) {
            //范围
            if (!(val >= this.min.doubleValue() && val <= this.max.doubleValue())) {
                result.setMessage("[" + validParam.getName() + "]值不对，请输入" + this.min + "到" + this.max + "之间的浮点数");
            }
        } else if (this.min != null) {
            //校验最小长度
            if (val < this.min.doubleValue()) {
                result.setMessage("[" + validParam.getName() + "]值不对，请输入大于等于" + this.min + "的浮点数");
            }
        } else if (this.max != null) {
            //校验最小长度
            if (val > this.max.doubleValue()) {
                result.setMessage("[" + validParam.getName() + "]值不对，请输入小于等于" + this.max + "的浮点数");
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
