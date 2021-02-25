package com.myinfo.base.valid.rules;

import com.myinfo.base.utils.MyStringUtils;
import com.myinfo.base.utils.ReflectUtils;
import com.myinfo.base.valid.ValidParam;
import com.myinfo.base.valid.ValidResult;
import com.myinfo.base.valid.ValidRule;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

/**
 * 排序规则校验
 * 判断用户所传字段是否存在于其中
 * @author 盛凯 2021-1-4
 */
@Getter
@Setter
public class OrderByFieldValidRule extends ValidRule {

    //比对类
    protected Class clazz;

    /**
     * 比对
     * @param clazz
     */
    public OrderByFieldValidRule(Class clazz) {
        this.clazz = clazz;
    }

    /**
     * 比对
     * @param msg
     * @param clazz
     */
    public OrderByFieldValidRule(String msg, Class clazz) {
        super(msg);
        this.clazz = clazz;
    }

    @Override
    public ValidResult vali(Object obj, ValidParam validParam) {
        ValidResult result = new ValidResult();
        result.setResult(false);

        //校验
        String val = (String)obj;

        //循环校验字段是否存在
        Field[] fields = ReflectUtils.getAllField(clazz);
        for(Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            String lineName = MyStringUtils.humpToLine(name);
            if(lineName.equals(val)) {
                //找到对应字段
                result.setResult(true);
                return result;
            }
        }
        //未找到对应字段
        if(StringUtils.isEmpty(this.msg)) {
            result.setMessage("[" + validParam.getName() + "]没有这样的字段，请输入正确的值！");
        } else {
            result.setMessage(this.msg);
        }

        return result;
    }

}
