package com.kyriexu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author KyrieXu
 * @since 2020/7/28 13:48
 **/
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {
    public static final String SWAGGER_SCAN_BASE_PACKAGES = "com.kyriexu";

    public static final String VERSION="1.0";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGES))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("优聘科技研发实习生试题接口")
                .description("优聘科技研发实习生试题接口文档")
                .version(VERSION)
                .build();
    }
}
