package com.myinfo.base.valid.rules;

import com.myinfo.base.consts.DateConst;
import com.myinfo.base.valid.ValidParam;
import com.myinfo.base.valid.ValidResult;
import com.myinfo.base.valid.ValidRule;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期前后校验
 * @author 盛凯 2021-1-4
 */
@Slf4j
@Getter
@Setter
public class DatePrevNextValidRule extends ValidRule {

    private SimpleDateFormat sdf = new SimpleDateFormat(DateConst.DATE_FORMAT);
    protected Integer compareToIndex;
    protected Date date;

    public DatePrevNextValidRule(Integer compareToIndex, Date date) {
        this.compareToIndex = compareToIndex;
        this.date = date;
    }

    public DatePrevNextValidRule(String msg, Integer compareToIndex, Date date) {
        super(msg);
        this.compareToIndex = compareToIndex;
        try {
            this.date = sdf.parse(sdf.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ValidResult vali(Object obj, ValidParam validParam) {
        ValidResult result = new ValidResult();
        result.setResult(false);

        String info = this.compareToIndex < 0 ? "小于" : this.compareToIndex == 0 ? "等于" : "大于";

        //校验
        Date val = null;
        try {
            val = sdf.parse(sdf.format((Date)obj));
        } catch (ParseException e) {
            e.printStackTrace();
        }

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
