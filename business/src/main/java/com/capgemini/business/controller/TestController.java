package com.capgemini.business.controller;

import com.capgemini.business.controller.vo.TestRepVO;
import com.capgemini.business.controller.vo.TestReqVO;
import com.capgemini.business.convert.TempConvert;
import com.capgemini.business.mapper.dataobject.TempDO;
import com.capgemini.business.service.TestService;
import com.capgemini.commons.response.Response;
import com.capgemini.mybatis.core.dataobject.PageData;
import com.capgemini.mybatis.core.dataobject.PageableQuery;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:RuKeNan
 * @Date:2024/4/9-22:01
 * @Description:接口测试类
 * @Warning:此代码版权归汝克楠所有，如有使用，请发送邮件到rukenan2020@163.com与我联系，侵犯必究！！！
 */

@RestController
@RequestMapping("test")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    private final TempConvert TempConvert;

    @GetMapping
    @Operation(summary = "hello")
    public Response<String> test() {
        return Response.success("Hello");
    }

    @GetMapping("get-params/{id}")
    @Operation(summary = "测试路径传参")
    public Response<TestRepVO> testGetParams(@PathVariable("id") String id) {
        return Response.success(TestRepVO.builder().tempId(id).build());
    }

    @PostMapping("post-body")
    @Operation(summary = "测试接收请求体")
    public Response<TestRepVO> testPostBody(@RequestBody TestReqVO testReqVO) {
        return Response.success(TestRepVO.builder().tempId(testReqVO.getId()).userName(testReqVO.getUserName()).build());
    }

    @GetMapping("temp-list")
    @Operation(summary = "测试返回列表")
    public Response<List<TestRepVO>> queryTempList() {
        List<TempDO> tempDOS = testService.queryTempList();
        List<TestRepVO> testRepVOS = TempConvert.convertDO2VO(tempDOS);
        return Response.success(testRepVOS);
    }

    @PostMapping("page")
    @Operation(summary = "测试分页")
    public Response<PageData<TestRepVO>> queryTempPage(@RequestBody PageableQuery<TestReqVO> pageableQuery) {
        PageData<TempDO> pageData = testService.queryTempPage(pageableQuery);
        return Response.success(TempConvert.convertPageDO2VO(pageData));
    }
}
