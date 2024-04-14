package com.capgemini.mybatis.core.utils;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.capgemini.mybatis.core.dataobject.PageableQuery;
import com.capgemini.mybatis.core.dataobject.SortBy;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;

/**
 * @Author:RuKeNan
 * @Date:2024/4/9-21:41
 * @Description:
 * @Warning:此代码版权归汝克楠所有，如有使用，请发送邮件到rukenan2020@163.com与我联系，侵犯必究！！！
 */

@UtilityClass
@SuppressWarnings("unused")
public class MyBatisUtils {

    public static <T> Page<T> buildPage(PageableQuery<?> query) {
        // 页码 + 数量
        Page<T> page = new Page<>(query.getPageNo(), query.getPageSize());
        // 排序字段
        if (CollUtil.isNotEmpty(query.getSortParams())) {
            page.addOrder(query.getSortParams().stream()
                .map(sortBy -> SortBy.ORDER_ASC.equals(sortBy.getOrder())
                    ? OrderItem.asc(sortBy.getField()) : OrderItem.desc(sortBy.getField()))
                .collect(Collectors.toList()));
        }
        return page;
    }

    /**
     * 将拦截器添加到链中 由于 MybatisPlusInterceptor 不支持添加拦截器，所以只能全量设置
     *
     * @param interceptor 链
     * @param inner       拦截器
     * @param index       位置
     */
    public static void addInterceptor(MybatisPlusInterceptor interceptor, InnerInterceptor inner, int index) {
        List<InnerInterceptor> inners = new ArrayList<>(interceptor.getInterceptors());
        inners.add(index, inner);
        interceptor.setInterceptors(inners);
    }

}

