package com.test.answer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Descript swagger2配置类
 * @Version 1.0
 */
@EnableSwagger2
@Configuration
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //api文档扫描覆盖的包
                .apis(RequestHandlerSelectors.basePackage("com.smart.sperms.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    //构建api文档的详细描述参数
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("【CODE TEST】")
                .version("1.0")
                .description("")
                .build();
    }

}
