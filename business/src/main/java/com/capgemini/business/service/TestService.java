package com.capgemini.business.service;

import com.capgemini.business.controller.vo.TestReqVO;
import com.capgemini.business.mapper.dataobject.TempDO;
import com.capgemini.mybatis.core.dataobject.PageData;
import com.capgemini.mybatis.core.dataobject.PageableQuery;
import java.util.List;

/**
 * @Author:RuKeNan
 * @Date:2024/4/12-09:30
 * @Description:
 * @Warning:此代码版权归汝克楠所有，如有使用，请发送邮件到rukenan2020@163.com与我联系，侵犯必究！！！
 */

public interface TestService {
    List<TempDO> queryTempList();

    PageData<TempDO> queryTempPage(PageableQuery<TestReqVO> pageableQuery);
}
