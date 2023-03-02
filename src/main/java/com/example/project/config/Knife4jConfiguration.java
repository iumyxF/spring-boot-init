package com.example.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @description: knife4j 配置
 * @Date 2023/3/2 16:19
 * @Author iumyxF
 */
@EnableSwagger2WebMvc
@Configuration
@Profile("dev")
public class Knife4jConfiguration {

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("project-backend apis")
                        .description("project-backend")
                        .termsOfServiceUrl("https://github.com/iumyxF")
                        .contact(new Contact("name", "url", "xx@qq.com"))
                        .version("1.0")
                        .build())
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.example.project.controller"))
                .paths(PathSelectors.any())
                .build();
    }

}
