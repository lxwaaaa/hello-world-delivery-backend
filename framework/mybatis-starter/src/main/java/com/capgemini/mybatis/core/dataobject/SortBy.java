package com.capgemini.mybatis.core.dataobject;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Author:RuKeNan
 * @Date:2024/4/9-21:39
 * @Description:
 * @Warning:此代码版权归汝克楠所有，如有使用，请发送邮件到rukenan2020@163.com与我联系，侵犯必究！！！
 */

@Schema(description = "排序参数")
@Data
public class SortBy {
    /**
     * 升序
     */
    public static final String ORDER_ASC = "asc";

    /**
     * 降序
     */
    public static final String ORDER_DESC = "desc";

    @Schema(description = "排序字段", example = "name")
    private String field;

    @Schema(description = "排序规则", example = "desc", defaultValue = "asc")
    private String order = ORDER_ASC;

}
