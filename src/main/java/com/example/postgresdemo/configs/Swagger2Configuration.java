package com.example.postgresdemo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.PathSelectors.*;

@EnableSwagger2
@Configuration
public class Swagger2Configuration {

    @Bean
    public Docket questionAndAnswerApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.postgresdemo"))
                .paths(PathSelectors.regex("/questions.*"))
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Swagger Documentation for Question and Answer ",
                "This API expose endpoints for questions and answers",
                "1.0",
                "none-for-now",
                "Ogbinaka Emmanuel - dubbed from github",
                "Mit License",
                "none-for-now"
        );
    }

}
