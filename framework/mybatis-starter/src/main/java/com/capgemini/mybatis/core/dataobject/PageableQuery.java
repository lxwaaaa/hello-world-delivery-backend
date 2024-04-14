package com.capgemini.mybatis.core.dataobject;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.Data;

/**
 * @Author:RuKeNan
 * @Date:2024/4/9-21:45
 * @Description:分页查询条件
 * @Warning:此代码版权归汝克楠所有，如有使用，请发送邮件到rukenan2020@163.com与我联系，侵犯必究！！！
 */

@Schema(description = "分页查询条件")
@Data
public class PageableQuery<T> {

    private static final Integer PAGE_NO = 1;

    private static final Integer PAGE_SIZE = 10;
    
    @Schema(description = "页码，从 1 开始，默认值：1", example = "1", defaultValue = "1")
    @Min(value = 1, message = "页码最小值为 1")
    private Integer pageNo = PAGE_NO;

    @Schema(description = "每页条数，最大值为 100，默认值：10", example = "10", defaultValue = "10")
    @Min(value = 1, message = "每页条数最小值为 1")
    @Max(value = 100, message = "每页条数最大值为 100")
    private Integer pageSize = PAGE_SIZE;

    @Schema(description = "查询参数")
    @Valid
    private T param;

    /**
     * 没有排序参数时，在请求时不要带这个参数，要不会系统异常
     */
    @Schema(description = "排序参数")
    private List<SortBy> sortParams;

}

