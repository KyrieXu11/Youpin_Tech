package com.kyriexu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author KyrieXu
 * @since 2020/7/27 21:15
 **/
@SpringBootApplication
@MapperScan(basePackages = {"com.kyriexu.mapper"})
public class YoupinApplication {
    public static void main(String[] args) {
        SpringApplication.run(YoupinApplication.class,args);
    }
}
