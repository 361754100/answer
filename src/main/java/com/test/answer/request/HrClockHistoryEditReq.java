package com.test.answer.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "个人考勤记录消息体")
public class HrClockHistoryEditReq implements Serializable {

    @ApiModelProperty(value = "人员账号", example = "XiaoMing")
    private String userId;

    @ApiModelProperty(value = "上班打卡时间", example = "2020-05-16 09:00:00")
    private String clockIn;

    @ApiModelProperty(value = "下班打卡时间", example = "2020-05-16 18:00:00")
    private String clockOut;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getClockIn() {
        return clockIn;
    }

    public void setClockIn(String clockIn) {
        this.clockIn = clockIn;
    }

    public String getClockOut() {
        return clockOut;
    }

    public void setClockOut(String clockOut) {
        this.clockOut = clockOut;
    }

    @Override
    public String toString() {
        return "HrClockHistoryEditReq{" +
                "userId='" + userId + '\'' +
                ", clockIn='" + clockIn + '\'' +
                ", clockOut='" + clockOut + '\'' +
                '}';
    }
}