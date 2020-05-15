package com.test.answer.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "点位关系消息体")
public class PointsRelationEditReq implements Serializable {

    @ApiModelProperty(value = "记录ID")
    private Integer id;

    @ApiModelProperty(value = "起始点位ID")
    private Integer startPoint;

    @ApiModelProperty(value = "结束点位ID")
    private Integer endPoint;

    @ApiModelProperty(value = "距离")
    private Integer distance;

    @ApiModelProperty(value = "距离耗时")
    private Integer costTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Integer startPoint) {
        this.startPoint = startPoint;
    }

    public Integer getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Integer endPoint) {
        this.endPoint = endPoint;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getCostTime() {
        return costTime;
    }

    public void setCostTime(Integer costTime) {
        this.costTime = costTime;
    }

    @Override
    public String toString() {
        return "PointsRelationEditReq{" +
                "id=" + id +
                ", startPoint=" + startPoint +
                ", endPoint=" + endPoint +
                ", distance=" + distance +
                ", costTime=" + costTime +
                '}';
    }
}