package com.myinfo.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.myinfo.*")
@MapperScan({"com.myinfo.base.mapper.*"})
@EnableJpaRepositories(basePackages = "com.myinfo.base.dao")
@EntityScan(basePackages = "com.myinfo.base.entity")
public class UserServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServerApplication.class, args);
    }

}
