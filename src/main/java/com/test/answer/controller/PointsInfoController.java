package com.test.answer.controller;

import com.test.answer.response.CommonWrapper;
import com.test.answer.response.ListQueryWrapper;
import com.test.answer.response.PageSearchWrapper;
import com.test.answer.response.SingleQueryWrapper;
import com.test.answer.service.PointsInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "product", description = "产品类型")
@RestController
@RequestMapping(value = "product")
public class PointsInfoController {

    private static Logger logger = LoggerFactory.getLogger(PointsInfoController.class);

    @Autowired
    private PointsInfoService pointsInfoService;

    @ApiOperation(value = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNo", value = "当前页", required = true, paramType = "form", dataType = "int"),
            @ApiImplicitParam(name="pageSize", value = "每页大小", required = true, paramType = "form", dataType = "int"),
            @ApiImplicitParam(name="proName", value = "名称关键字", paramType = "form", dataType = "string")
    })
    @PostMapping(value = "/page_search")
    public PageSearchWrapper pageSearch(@RequestParam int pageNo, @RequestParam int pageSize,
                                        @RequestParam(required = false) String proName) {
        PageSearchWrapper wrapper = productService.queryPage(pageNo, pageSize, proName);

        logger.debug("pageNo = {}, pageSize = {}, proName = {}",
                new Object[]{ pageNo, pageSize, proName});
        return wrapper;
    }

    @ApiOperation(value = "新增产品类型")
    @PostMapping(value = "/add")
    public CommonWrapper add(@RequestBody ProductEditReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = productService.addInfo(params);
        return wrapper;
    }

    @ApiOperation(value = "修改产品类型")
    @PostMapping(value = "/update")
    public CommonWrapper update(@RequestBody ProductEditReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = productService.updateInfo(params);
        return wrapper;
    }

    @ApiOperation(value = "删除产品类型")
    @PostMapping(value = "/delete")
    public CommonWrapper delete(@RequestBody ProductDelReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = productService.deleteInfo(params.getProIds());
        return wrapper;
    }

    @ApiOperation(value = "按ID查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="recordId", value = "记录ID", required = true, paramType = "form", dataType = "String")
    })
    @PostMapping(value = "/find_by_id")
    public SingleQueryWrapper findRecordById(@RequestParam String recordId) {
        SingleQueryWrapper wrapper = productService.findRecordById(recordId);

        logger.debug(" recordId = {}",
                new Object[]{recordId});
        return wrapper;
    }

    @ApiOperation(value = "获取所有数据")
    @PostMapping(value = "/list_all")
    public ListQueryWrapper listAll() {
        ListQueryWrapper wrapper = productService.listAll();
        return wrapper;
    }
}
