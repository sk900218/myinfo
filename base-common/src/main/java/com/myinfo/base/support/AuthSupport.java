package com.myinfo.base.support;

import com.google.gson.reflect.TypeToken;
import com.myinfo.base.bean.ResVo;
import com.myinfo.base.consts.SystemConst;
import com.myinfo.base.entity.SysUser;
import com.myinfo.base.enums.ResCode;
import com.myinfo.base.exception.ApiException;
import com.myinfo.base.utils.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 鉴权支持
 * @author 盛凯 2021-2-26
 */
@Slf4j
@Component
public class AuthSupport {

    @Autowired
    public RestTemplate restTemplate;

    /**
     * 获得当前登录用户
     * @return
     */
    public ResVo<SysUser> getCurrUser() throws ApiException {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        //通过用户服务进行鉴权
        HttpHeaders headers = new HttpHeaders();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            headers.add(key, value);
        }
        ResVo<SysUser> resVo = null;
        try {
            String json = restTemplate.postForObject("http://" + SystemConst.EUREKA_USER_SERVER + "/auth/token/valid", new HttpEntity<String>(headers), String.class);
            resVo = GsonUtils.buildFormat().fromJson(json, new TypeToken<ResVo<SysUser>>(){}.getType());
        } catch (RestClientException e) {
            log.error("读取用户服务发生异常");
            e.printStackTrace();
            throw new ApiException(ResCode.SYSTEM_ERROR);
        }
        if(ResCode.SUCCESS.getCode() != resVo.getCode()) {
            throw new ApiException(resVo);
        }
        return resVo;
    }
}
