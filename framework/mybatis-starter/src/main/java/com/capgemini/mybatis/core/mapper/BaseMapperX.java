package com.capgemini.mybatis.core.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.capgemini.mybatis.core.dataobject.PageData;
import com.capgemini.mybatis.core.dataobject.PageableQuery;
import com.capgemini.mybatis.core.utils.MyBatisUtils;
import com.github.yulichang.base.MPJBaseMapper;
import com.github.yulichang.interfaces.MPJBaseJoin;
import java.util.Collection;
import org.apache.ibatis.annotations.Param;

/**
 * @Author:RuKeNan
 * @Date:2024/4/9-22:07
 * @Description:二次封装的BaseMapper，所有实体类继承即可
 * @Warning:此代码版权归汝克楠所有，如有使用，请发送邮件到rukenan2020@163.com与我联系，侵犯必究！！！
 */

public interface BaseMapperX<T> extends BaseMapper<T>, MPJBaseMapper<T> {

    default PageData<T> selectPage(PageableQuery<?> query, @Param("ew") Wrapper<T> queryWrapper) {
        // MyBatis Plus 查询
        IPage<T> mpPage = MyBatisUtils.buildPage(query);
        selectPage(mpPage, queryWrapper);
        // 转换返回
        return new PageData<>(mpPage.getCurrent(), mpPage.getPages(),
            mpPage.getSize(), mpPage.getTotal(), mpPage.getRecords());
    }

    // 注意： 官方说明「1对多关联查询时不要使用此方法，会导致分页数据不准」
    default PageData<T> selectJoinPage(PageableQuery<?> query, Class<T> type, @Param("ew") MPJBaseJoin<T> join) {
        // MyBatis Plus 查询
        IPage<T> mpPage = MyBatisUtils.buildPage(query);
        selectJoinPage(mpPage, type, join);
        // 转换返回
        return new PageData<>(mpPage.getCurrent(), mpPage.getPages(),
            mpPage.getSize(), mpPage.getTotal(), mpPage.getRecords());
    }


    /**
     * 批量插入，适合大量数据插入
     */
    default void insertBatch(Collection<T> entities) {
        Db.saveBatch(entities);
    }

    /**
     * 批量插入，适合大量数据插入
     *
     * @param size 插入数量 Db.saveBatch 默认为 1000
     */
    default void insertBatch(Collection<T> entities, int size) {
        Db.saveBatch(entities, size);
    }

    default void updateBatch(Collection<T> entities, int size) {
        Db.updateBatchById(entities, size);
    }

}
