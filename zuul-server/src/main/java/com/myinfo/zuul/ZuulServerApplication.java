package com.myinfo.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * zuul实现路由功能以及与ribbon共同实现负载均衡
 * 在其入口applicaton类加上注解@EnableZuulProxy，开启zuul的功能
 */
@EnableZuulProxy
@SpringBootApplication(scanBasePackages = "com.myinfo.*")
public class ZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
