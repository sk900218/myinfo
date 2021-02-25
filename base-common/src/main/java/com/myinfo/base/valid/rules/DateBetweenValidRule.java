package com.myinfo.base.valid.rules;

import com.myinfo.base.consts.DateConst;
import com.myinfo.base.utils.DateUtil;
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
 * 日期时间范围
 * @author 盛凯 2021-1-4
 */
@Slf4j
@Getter
@Setter
public class DateBetweenValidRule extends ValidRule {

    private SimpleDateFormat sdf = new SimpleDateFormat(DateConst.DATETIME_FORMAT);
    protected Date startTime;
    protected Date endTime;

    /**
     * 日期范围
     * @param startTime
     * @param endTime
     */
    public DateBetweenValidRule(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * 特定值
     * @param msg
     * @param startTime
     * @param endTime
     */
    public DateBetweenValidRule(String msg, Date startTime, Date endTime) {
        super(msg);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public ValidResult vali(Object obj, ValidParam validParam) {
        ValidResult result = new ValidResult();
        result.setResult(false);

        //校验
        Date val = (Date)obj;

        if (this.startTime != null && this.endTime != null) {
            //范围
            if (!DateUtil.between(val, this.startTime, this.endTime)) {
                result.setMessage("[" + validParam.getName() + "]值不对，请输入" + sdf.format(this.startTime) + "到" + sdf.format(this.endTime) + "之间的时间");
            }
        } else if (this.startTime != null) {
            //校验最小长度
            if (val.getTime() < this.startTime.getTime()) {
                result.setMessage("[" + validParam.getName() + "]值不对，请输入大于等于" + sdf.format(this.startTime) + "的时间");
            }
        } else if (this.endTime != null) {
            //校验最小长度
            if (val.getTime() > this.endTime.getTime()) {
                result.setMessage("[" + validParam.getName() + "]值不对，请输入小于等于" + sdf.format(this.endTime) + "的时间");
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
