package com.myinfo.base.valid;

import com.myinfo.base.utils.GsonUtils;
import com.myinfo.base.utils.MapUtils;
import com.myinfo.base.valid.rules.NotNullValidRule;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 校验代理
 * @author 盛凯 2020-12-25
 */
@Slf4j
class ValidProxy {

    /**
     * 校验字段
     * @param object 要校验的对象
     * @param valis 规则
     * @return 校验结果
     */
    public static ValidResult vali(Object object, ValidParam... valis) {
        return vali(object, Arrays.asList(valis));
    }

    /**
     * 校验字段
     * @param object 要校验的对象
     * @param valiList 参数校验
     * @return 校验结果
     */
    public static ValidResult vali(Object object, List<ValidParam> valiList) {
        ValidResult result = new ValidResult();
        result.setResult(true);

        Map<String, Object> map = null;
        //将用户对象转换成map
        try {
             map = MapUtils.objectToMap(object);
        } catch (Exception e) {
            log.error("[校验]转换发生异常：{}", GsonUtils.objToJson(object));
            e.printStackTrace();
            return result;
        }

        //遍历校验及规则
        for(ValidParam validParam : valiList) {
            Object obj = map.get(validParam.getField());
            ArrayList<ValidRule> list = validParam.getRuleList();

            //校验规则中，是否含有非空判断
            long count = list.stream().filter(t -> t instanceof NotNullValidRule).count();
            if(count == 0) {
                //不含非空判断，校验obj是否为空，为空则跳过此次验证
                NotNullValidRule notNullRule = new NotNullValidRule();
                ValidResult temp = notNullRule.vali(obj, validParam);
                if(!temp.getResult()) {
                    continue;
                }
            }

            for(ValidRule validRule : list) {
                ValidResult validResult = validRule.vali(obj, validParam);
                if(!validResult.getResult()) {
                    //有失败，直接返回
                    return validResult;
                }
            }
        }
        return result;
    }
}