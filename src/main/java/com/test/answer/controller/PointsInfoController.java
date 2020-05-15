package com.test.answer.controller;

import com.test.answer.request.LinesPlanParamsReq;
import com.test.answer.request.PointsInfoDelReq;
import com.test.answer.request.PointsInfoEditReq;
import com.test.answer.response.CommonWrapper;
import com.test.answer.response.ListQueryWrapper;
import com.test.answer.response.PageSearchWrapper;
import com.test.answer.response.SingleQueryWrapper;
import com.test.answer.service.PointsInfoService;
import com.test.answer.service.PointsRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "points", description = "第一题：路线规划")
@RestController
@RequestMapping(value = "points")
public class PointsInfoController {

    private static Logger logger = LoggerFactory.getLogger(PointsInfoController.class);

    @Autowired
    private PointsInfoService pointsInfoService;

    @Autowired
    private PointsRelationService pointsRelationService;

    /*@ApiOperation(value = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNo", value = "当前页", required = true, paramType = "form", dataType = "int"),
            @ApiImplicitParam(name="pageSize", value = "每页大小", required = true, paramType = "form", dataType = "int"),
            @ApiImplicitParam(name="proName", value = "名称关键字", paramType = "form", dataType = "string")
    })
    @PostMapping(value = "/page_search")*/
    public PageSearchWrapper pageSearch(@RequestParam int pageNo, @RequestParam int pageSize,
                                        @RequestParam(required = false) String proName) {
        PageSearchWrapper wrapper = pointsInfoService.queryPage(pageNo, pageSize, proName);

        logger.debug("pageNo = {}, pageSize = {}, proName = {}",
                new Object[]{ pageNo, pageSize, proName});
        return wrapper;
    }

    /*@ApiOperation(value = "新增点位信息")
    @PostMapping(value = "/add")*/
    public CommonWrapper add(@RequestBody PointsInfoEditReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = pointsInfoService.addInfo(params);
        return wrapper;
    }

    /*@ApiOperation(value = "修改点位信息")
    @PostMapping(value = "/update")*/
    public CommonWrapper update(@RequestBody PointsInfoEditReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = pointsInfoService.updateInfo(params);
        return wrapper;
    }

    /*@ApiOperation(value = "删除点位信息")
    @PostMapping(value = "/delete")*/
    public CommonWrapper delete(@RequestBody PointsInfoDelReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = pointsInfoService.deleteInfo(params.getRecordIds());
        return wrapper;
    }

    /*@ApiOperation(value = "按ID查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="recordId", value = "记录ID", required = true, paramType = "form", dataType = "String")
    })
    @PostMapping(value = "/find_by_id")*/
    public SingleQueryWrapper findRecordById(@RequestParam Integer recordId) {
        SingleQueryWrapper wrapper = pointsInfoService.findRecordById(recordId);

        logger.debug(" recordId = {}",
                new Object[]{recordId});
        return wrapper;
    }

    /*@ApiOperation(value = "获取所有数据")
    @PostMapping(value = "/list_all")*/
    public ListQueryWrapper listAll() {
        ListQueryWrapper wrapper = pointsInfoService.listAll();
        return wrapper;
    }

    @ApiOperation(value = "线路规划")
    @PostMapping(value = "/line_plan")
    public SingleQueryWrapper linePlan(@RequestBody LinesPlanParamsReq req) {
        SingleQueryWrapper wrapper = pointsRelationService.linesPlan(req.getMaxTaskTime(), req.getDistanceRadius());
        return wrapper;
    }

}
