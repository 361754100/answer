package com.test.answer.dao.model;

import java.io.Serializable;
import java.util.Date;

public class HrClockHistory implements Serializable {
    private Integer id;

    private String userId;

    private Date clockIn;

    private Date clockOut;

    private Integer state;

    private static final long serialVersionUID = 1L;

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
}