package com.redscarf.dreamroutes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * Created by IntelliJ IDEA.
 * dreamroutes.SwaggerConfig
 *
 * @Author: Pavel Shcherbatyi
 * @DateTime: 13.05.2022|03:03
 * @Version SwaggerConfig: 1.0
 */

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.redscarf.dreamroutes.controllers"))
                .paths(PathSelectors.ant("/api/v1/**"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("DreamRoutes API Documentation")
                .version("v0.5.0")
                .contact(new Contact("Pavlo Shcherbatyi",
                        "https://github.com/YourFriendlyNeighbourPasha",
                        "pavel.shcherbatyi@protonmail.com"))
                .description("The documentation of DreamRoutes API")
                .extensions(Collections.emptyList())
                .build();
    }

}
