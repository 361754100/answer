package com.test.answer.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "点位信息消息体")
public class HrClockHistoryEditReq implements Serializable {

    @ApiModelProperty(value = "记录ID")
    private Integer id;

    @ApiModelProperty(value = "人员账号")
    private String userId;

    @ApiModelProperty(value = "上班打卡时间")
    private Date clockIn;

    @ApiModelProperty(value = "下班打卡时间")
    private Date clockOut;

    @ApiModelProperty(value = "当天状态")
    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getClockIn() {
        return clockIn;
    }

    public void setClockIn(Date clockIn) {
        this.clockIn = clockIn;
    }

    public Date getClockOut() {
        return clockOut;
    }

    public void setClockOut(Date clockOut) {
        this.clockOut = clockOut;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "HrClockHistoryEditReq{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", clockIn=" + clockIn +
                ", clockOut=" + clockOut +
                ", state=" + state +
                '}';
    }
}