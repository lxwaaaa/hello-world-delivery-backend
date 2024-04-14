package com.capgemini.mybatis.core.dataobject;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:RuKeNan
 * @Date:2024/4/9-21:43
 * @Description:分页结果数据
 * @Warning:此代码版权归汝克楠所有，如有使用，请发送邮件到rukenan2020@163.com与我联系，侵犯必究！！！
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "分页结果")
public class PageData<T> {

    @Schema(description = "当前页", required = true)
    private Long pageNo;

    @Schema(description = "总页数", required = true)
    private Long pageTotal;

    @Schema(description = "当前页数据量", required = true)
    private Long pageSize;

    @Schema(description = "数据总量", required = true)
    private Long totalCount;

    @Schema(description = "数据", required = true)
    private List<T> list;

    public PageData(Long total) {
        this.totalCount = total;
    }
}
