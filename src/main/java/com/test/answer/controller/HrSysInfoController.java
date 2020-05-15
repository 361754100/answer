package com.test.answer.controller;

import com.test.answer.request.HrClockConfigEditReq;
import com.test.answer.request.HrClockHistoryEditReq;
import com.test.answer.request.HrClockHistoryReportReq;
import com.test.answer.response.CommonWrapper;
import com.test.answer.response.ListQueryWrapper;
import com.test.answer.response.PageSearchWrapper;
import com.test.answer.service.HrClockConfigService;
import com.test.answer.service.HrClockHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "hrsys", description = "第二题：HR系统信息")
@RestController
@RequestMapping(value = "hrsys")
public class HrSysInfoController {

    private static Logger logger = LoggerFactory.getLogger(HrSysInfoController.class);

    @Autowired
    private HrClockConfigService hrClockConfigService;

    @Autowired
    private HrClockHistoryService hrClockHistoryService;

    @ApiOperation(value = "修改考勤时间规则")
    @PostMapping(value = "/update_clock_config")
    public CommonWrapper add(@RequestBody HrClockConfigEditReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = hrClockConfigService.updateInfo(params);
        return wrapper;
    }

    @ApiOperation(value = "统计考勤情况")
    @PostMapping(value = "/report_clock_history")
    public ListQueryWrapper reportClockHistory(@RequestBody HrClockHistoryReportReq params) {
        logger.debug(" params = {}", new Object[]{params});
        String startTime = params.getStartTime() + " 00:00:00";
        String endTime = params.getEndTime() + " 23:59:59";

        ListQueryWrapper wrapper = hrClockHistoryService.reportClockHistory(startTime, endTime);
        return wrapper;
    }

    @ApiOperation(value = "保存考勤记录信息")
    @PostMapping(value = "/save_clock_history")
    public CommonWrapper saveClockHistory(@RequestBody HrClockHistoryEditReq params) {
        logger.debug(" params = {}", new Object[]{params});
        CommonWrapper wrapper = hrClockHistoryService.saveOrUpdateInfo(params);
        return wrapper;
    }

    @ApiOperation(value = "考勤记录分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNo", value = "当前页", required = true, paramType = "form", dataType = "int"),
            @ApiImplicitParam(name="pageSize", value = "每页大小", required = true, paramType = "form", dataType = "int"),
            @ApiImplicitParam(name="userId", value = "账号关键字", paramType = "form", dataType = "string")
    })
    @PostMapping(value = "/page_search")
    public PageSearchWrapper pageSearch(@RequestParam int pageNo, @RequestParam int pageSize,
                                        @RequestParam(required = false) String userId) {
        PageSearchWrapper wrapper = hrClockHistoryService.queryPage(pageNo, pageSize, userId);

        logger.debug("pageNo = {}, pageSize = {}, userId = {}",
                new Object[]{ pageNo, pageSize, userId});
        return wrapper;
    }
}
