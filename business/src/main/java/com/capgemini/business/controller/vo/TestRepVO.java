package com.capgemini.business.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:RuKeNan
 * @Date:2024/4/11-20:26
 * @Description:
 * @Warning:此代码版权归汝克楠所有，如有使用，请发送邮件到rukenan2020@163.com与我联系，侵犯必究！！！
 */

@Data
@Schema(description = "测试类 Rep")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestRepVO {

    @Schema(description = "临时表id")
    private String tempId;

    @Schema(description = "用户名")
    private String userName;
}
