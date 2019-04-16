package com.pmdiss.common.config;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;

@Configuration
@ComponentScan(basePackages = {"com.ajy.core.**.controller"})
@EnableSwagger2
public class Swagger2 {
    // 运营环境
    private static final String PROFILE_PRO = "pro";
    @Autowired
    private Environment environment;

    @Bean
    public Docket apiDocket() {
        // SWAGGER默认可用
        Boolean swaggerEnable = true;
        //如果是生产环境，则swagger不可用
        if (ArrayUtils.isNotEmpty(environment.getActiveProfiles())) {
            for (String profile : environment.getActiveProfiles()) {
                if (PROFILE_PRO.equalsIgnoreCase(profile)) {
                    swaggerEnable = false;
                }
            }
        }
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerEnable)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ajy.core"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .enableUrlTemplating(true);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("爱借阅图书借阅系统 API")
                .description("“爱借阅图书借阅系统” REST 形式 API的详细描述。")
                //.termsOfServiceUrl("git@github.com:LiuwqGit/spring-boot-eureka.git")
                .contact(new Contact("北京术杰科技有限公司", "http://www.bjshujie.com", "sales@bjshujie.com")).version("1.0").build();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
