package com.capgemini.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author:RuKeNan
 * @Date:2024/4/9-21:24
 * @Description:
 * @Warning:此代码版权归汝克楠所有，如有使用，请发送邮件到rukenan2020@163.com与我联系，侵犯必究！！！
 */


@Data
@ConfigurationProperties(prefix = "capgemini-demo.swagger")
public class SwaggerProperties {

    /**
     * 是否启用
     */
    private boolean enabled = true;

    /**
     * title
     */
    private String title = "GoldenYears";

    /**
     * 描述
     */
    private String description = "请配置swagger.description";

    /**
     * 版本
     */
    private String version = "V1.0";

    /**
     * 条款URL
     */
    private String termsOfServiceUrl;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 联系人URL
     */
    private String contactUrl;

    /**
     * 联系人Email
     */
    private String contactEmail;

    /**
     * License
     */
    private String license;

    /**
     * License URL
     */
    private String licenseUrl;
}
