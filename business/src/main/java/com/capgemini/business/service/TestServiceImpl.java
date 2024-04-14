package com.capgemini.business.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.capgemini.business.controller.vo.TestReqVO;
import com.capgemini.business.mapper.TempMapper;
import com.capgemini.business.mapper.dataobject.TempDO;
import com.capgemini.mybatis.core.dataobject.PageData;
import com.capgemini.mybatis.core.dataobject.PageableQuery;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author:RuKeNan
 * @Date:2024/4/12-09:30
 * @Description:
 * @Warning:此代码版权归汝克楠所有，如有使用，请发送邮件到rukenan2020@163.com与我联系，侵犯必究！！！
 */

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TempMapper tempMapper;

    @Override
    public List<TempDO> queryTempList() {
        return tempMapper.selectList(null);
    }

    @Override
    public PageData<TempDO> queryTempPage(PageableQuery<TestReqVO> pageableQuery) {
//        Optional.ofNullable(pageableQuery.getParam()).orElse(new BusinessException("请求参数未收到"));
        return tempMapper.selectPage(pageableQuery,
            Wrappers.<TempDO>lambdaQuery()
                .like(TempDO::getUserName, pageableQuery.getParam().getUserName())
        );
    }
}
