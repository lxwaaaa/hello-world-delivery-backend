package com.capgemini.swagger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Author:RuKeNan
 * @Date:2024/4/9-22:10
 * @Description:
 * @Warning:此代码版权归汝克楠所有，如有使用，请发送邮件到rukenan2020@163.com与我联系，侵犯必究！！！
 */
@EnableOpenApi
@EnableConfigurationProperties(SwaggerProperties.class)
@ConditionalOnProperty(prefix = "capgemini-demo.swagger", name = "enabled", havingValue = "true", matchIfMissing = true)
public class SwaggerAutoConfiguration {

    private static final String AUTHORIZATION = "Authorization";

    @Bean
    public Docket adminApi(SwaggerProperties swaggerProperties) {
        return new Docket(DocumentationType.OAS_30)
            .apiInfo(apiInfo(swaggerProperties))
            // 是否开启swagger
            .enable(swaggerProperties.isEnabled())
            .securityContexts(Collections.singletonList(securityContext()))
            .securitySchemes(Collections.singletonList(apiKey()))
            .groupName("AdminAPI")
            .select()
            .paths(PathSelectors.ant("/capgemini-demo/**"))
            .build();
    }

    private ApiInfo apiInfo(SwaggerProperties swaggerProperties) {
        Contact contact = new Contact(swaggerProperties.getContact(),
            swaggerProperties.getContactUrl(), swaggerProperties.getContactEmail());
        return new ApiInfo(
            swaggerProperties.getTitle(),
            swaggerProperties.getDescription(),
            swaggerProperties.getVersion(),
            swaggerProperties.getTermsOfServiceUrl(),
            contact,
            swaggerProperties.getLicense(),
            swaggerProperties.getLicenseUrl(),
            new ArrayList<>()
        );
    }

    /**
     * 自定义一个Apikey 这是一个包含在header中键名为Authorization的JWT标识
     */
    private springfox.documentation.service.ApiKey apiKey() {
        return new ApiKey(AUTHORIZATION, AUTHORIZATION, "header");
    }

    /**
     * 配置JWT的SecurityContext 并设置全局生效
     */
    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections.singletonList(
            new SecurityReference(AUTHORIZATION, authorizationScopes));
    }

}


