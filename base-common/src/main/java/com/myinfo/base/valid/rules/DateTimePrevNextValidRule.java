package com.myinfo.base.valid.rules;

import com.myinfo.base.consts.DateConst;
import com.myinfo.base.valid.ValidParam;
import com.myinfo.base.valid.ValidResult;
import com.myinfo.base.valid.ValidRule;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期时间前后校验
 * @author 盛凯 2021-1-4
 */
@Slf4j
@Getter
@Setter
public class DateTimePrevNextValidRule extends ValidRule {

    private SimpleDateFormat sdf = new SimpleDateFormat(DateConst.DATETIME_FORMAT);
    protected Integer compareToIndex;
    protected Date date;

    public DateTimePrevNextValidRule(Integer compareToIndex, Date date) {
        this.compareToIndex = compareToIndex;
        this.date = date;
    }

    public DateTimePrevNextValidRule(String msg, Integer compareToIndex, Date date) {
        super(msg);
        this.compareToIndex = compareToIndex;
        this.date = date;
    }

    @Override
    public ValidResult vali(Object obj, ValidParam validParam) {
        ValidResult result = new ValidResult();
        result.setResult(false);

        String info = this.compareToIndex < 0 ? "小于" : this.compareToIndex == 0 ? "等于" : "大于";

        //校验
        Date val = (Date)obj;

        if (val.compareTo(this.date) != this.compareToIndex) {
            result.setMessage("[" + validParam.getName() + "]值不对，传入的[" + sdf.format(val) + "]必须" + info + "[" + sdf.format(this.date) + "]");
        }

        if(result.getMessage() == null) {
            result.setResult(true);
        } else if(!StringUtils.isEmpty(super.msg)) {
            result.setMessage(msg);
        }

        return result;
    }

}
