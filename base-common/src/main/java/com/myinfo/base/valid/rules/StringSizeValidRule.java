package com.myinfo.base.valid.rules;

import com.myinfo.base.valid.ValidParam;
import com.myinfo.base.valid.ValidResult;
import com.myinfo.base.valid.ValidRule;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

/**
 * 字符串长度校验
 * @author 盛凯 2020-12-25
 */
@Getter
@Setter
public class StringSizeValidRule extends ValidRule {

    //最小长度
    protected Integer minSize;
    //最大长度
    protected Integer maxSize;

    /**
     * 最小长度or最大长度，可传null
     * @param minSize
     * @param maxSize
     */
    public StringSizeValidRule(Integer minSize, Integer maxSize) {
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    /**
     * 最小长度or最大长度，可传null
     * @param msg
     * @param minSize
     * @param maxSize
     */
    public StringSizeValidRule(String msg, Integer minSize, Integer maxSize) {
        super(msg);
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    @Override
    public ValidResult vali(Object obj, ValidParam validParam) {
        ValidResult result = new ValidResult();
        result.setResult(false);

        String name = validParam.getName();

        //校验
        String val = obj.toString();

        if (this.maxSize != null && this.minSize != null) {
            //长度范围
            if (!(val.length() >= this.minSize && val.length() <= this.maxSize)) {
                result.setMessage("[" + name + "]长度不对，请输入长度在" + this.minSize + "到" + this.maxSize + "之间的内容");
            }
        } else if (this.minSize != null) {
            //校验最小长度
            if (val.length() < this.minSize) {
                result.setMessage("[" + name + "]长度不对，请输入多于等于" + this.minSize + "长度的内容");
            }
        } else if (this.maxSize != null) {
            //校验最小长度
            if (val.length() > this.maxSize) {
                result.setMessage("[" + name + "]长度不对，请输入少于等于" + this.maxSize + "长度的内容");
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
