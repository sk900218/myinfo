package com.myinfo.base.valid;

import com.myinfo.base.enums.ResCode;
import com.myinfo.base.exception.ApiException;
import com.myinfo.base.utils.GsonUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 校验规则工具类
 * @author 盛凯 2020-12-25
 */
@Slf4j
public class ValidUtil {

    /**
     * 校验参数
     * @param vo
     * @param ruleList
     * @return
     * @throws ApiException
     */
    public static ValidResult valiParams(Object vo, List<ValidParam> ruleList) throws ApiException {
        ValidResult result =  ValidProxy.vali(vo, ruleList);
        if(!result.getResult()) {
            if(result.getMessage() != null) {
                throw new ApiException(ResCode.PARAM_ERROR, result.getMessage());
            } else {
                log.error("参数校验异常！vo={}", GsonUtils.objToJson(vo));
                throw new ApiException();
            }
        }
        return result;
    }

}
