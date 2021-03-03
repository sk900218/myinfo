package com.myinfo.zuul.filter;

import com.google.gson.Gson;
import com.myinfo.zuul.config.AuthConfig;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 鉴权过滤器
 * @author 盛凯 2021-2-26
 */
@Slf4j
@Component
public class AuthFilter extends ZuulFilter {

    @Value("${zuul.routes.user-server.serviceId}")
    private String userServerName;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private AuthConfig authConfig;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        String uri = request.getRequestURI();

        /*地址过滤*/
        long count = authConfig.getFilter().stream().filter(t -> uri.contains(t)).count();
        if(count > 0) {
            return null;
        }

        //通过用户服务进行鉴权
        HttpHeaders headers = new HttpHeaders();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            headers.add(key, value);
        }
        Map<String, Object> map = null;
        try {
            map = restTemplate.postForObject("http://" + userServerName + "/auth/token/valid", new HttpEntity<String>(headers), Map.class);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("user-server服务异常");
            ctx.getResponse().setCharacterEncoding("UTF-8");
            ctx.getResponse().setContentType("application/json;charset=utf-8");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            try {
                map = new HashMap<>();
                map.put("code", "500");
                map.put("message", "服务器异常");
                ctx.getResponse().getWriter().write(new Gson().toJson(map));
            } catch (IOException e2) {}
            return null;
        }
        Integer code = (Integer)map.get("code");

        if(code != 200) {
            String msg = (String)map.get("message");
            log.info(msg);
            ctx.getResponse().setCharacterEncoding("UTF-8");
            ctx.getResponse().setContentType("application/json;charset=utf-8");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            try {
                ctx.getResponse().getWriter().write(new Gson().toJson(map));
            } catch (IOException e) {}
        }
        return null;
    }
}
