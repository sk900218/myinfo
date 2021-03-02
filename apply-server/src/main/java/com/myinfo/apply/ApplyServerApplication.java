package com.myinfo.apply;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com.myinfo.*")
@MapperScan({"com.myinfo.base.mapper"})
@EnableJpaRepositories(basePackages = "com.myinfo.base.dao")
@EntityScan(basePackages = "com.myinfo.base.entity")
public class ApplyServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApplyServerApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
