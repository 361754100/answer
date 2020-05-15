package com.test.answer.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "考勤记录统计参数")
public class HrClockHistoryReportReq implements Serializable {

    @ApiModelProperty(value = "开始时间", example = "2020-05-01")
    private String startTime;

    @ApiModelProperty(value = "结束时间", example = "2020-05-31")
    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "HrClockHistoryReportReq{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}