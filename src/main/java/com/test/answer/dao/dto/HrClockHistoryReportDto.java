package com.test.answer.dao.dto;

import com.test.answer.enums.HrClockHisStateEnum;

import java.io.Serializable;

/**
 * 考勤记录统计Dto
 */
public class HrClockHistoryReportDto implements Serializable {

    private String userId;

    private String userName;

    private int state;

    private int stateCount;

    private String stateDesc;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;

        HrClockHisStateEnum stateEnum = HrClockHisStateEnum.getState(state);
        this.stateDesc = stateEnum.getDesc();
    }

    public int getStateCount() {
        return stateCount;
    }

    public void setStateCount(int stateCount) {
        this.stateCount = stateCount;
        this.stateDesc += "[" + stateCount + "]次";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStateDesc() {
        return stateDesc;
    }

    public void setStateDesc(String stateDesc) {
        this.stateDesc = stateDesc;
    }

    @Override
    public String toString() {
        return "HrClockHistoryReportDto{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", state=" + state +
                ", stateCount=" + stateCount +
                ", stateDesc=" + stateDesc +
                '}';
    }
}
