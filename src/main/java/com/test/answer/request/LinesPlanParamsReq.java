package com.test.answer.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "线路规划参数")
public class LinesPlanParamsReq implements Serializable {

    @ApiModelProperty(value = "线路的最大任务时间(单位：分钟)", example = "450")
    private Integer maxTaskTime;

    @ApiModelProperty(value = "最小的检索半径(单位：米)", example = "50")
    private Integer distanceRadius;

    public Integer getMaxTaskTime() {
        return maxTaskTime;
    }

    public void setMaxTaskTime(Integer maxTaskTime) {
        this.maxTaskTime = maxTaskTime;
    }

    public Integer getDistanceRadius() {
        return distanceRadius;
    }

    public void setDistanceRadius(Integer distanceRadius) {
        this.distanceRadius = distanceRadius;
    }

    @Override
    public String toString() {
        return "LinesPlanParamsReq{" +
                "maxTaskTime=" + maxTaskTime +
                ", distanceRadius=" + distanceRadius +
                '}';
    }
}