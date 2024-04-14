package com.capgemini.business.convert;

import com.capgemini.business.controller.vo.TestRepVO;
import com.capgemini.business.mapper.dataobject.TempDO;
import com.capgemini.mybatis.core.dataobject.PageData;
import java.util.List;
import org.mapstruct.Mapper;

/**
 * @Author:RuKeNan
 * @Date:2024/4/12-09:34
 * @Description:
 * @Warning:此代码版权归汝克楠所有，如有使用，请发送邮件到rukenan2020@163.com与我联系，侵犯必究！！！
 */

@Mapper(componentModel = "spring")
public interface TempConvert {

    List<TestRepVO> convertDO2VO(List<TempDO> tempDOS);

    PageData<TestRepVO> convertPageDO2VO(PageData<TempDO> pageData);
}
