package com.test.answer.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "点位信息消息体")
public class HrClockConfigEditReq implements Serializable {

    @ApiModelProperty(value = "上班打卡时间")
    private String clockInTime;

    @ApiModelProperty(value = "下班打卡时间")
    private String clockOutTime;

    public String getClockInTime() {
        return clockInTime;
    }

    public void setClockInTime(String clockInTime) {
        this.clockInTime = clockInTime;
    }

    public String getClockOutTime() {
        return clockOutTime;
    }

    public void setClockOutTime(String clockOutTime) {
        this.clockOutTime = clockOutTime;
    }

    @Override
    public String toString() {
        return "HrClockConfigEditReq{" +
                "clockInTime='" + clockInTime + '\'' +
                ", clockOutTime='" + clockOutTime + '\'' +
                '}';
    }
}