package com.test.answer.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 批量删除记录
 */
@ApiModel(description = "批量删除记录请求")
public class PointsRelationDelReq implements Serializable {

    @ApiModelProperty(value = "记录ID")
    private List<Integer> recordIds;

    public List<Integer> getRecordIds() {
        return recordIds;
    }

    public void setRecordIds(List<Integer> recordIds) {
        this.recordIds = recordIds;
    }

    @Override
    public String toString() {
        return "PointsInfoDelReq{" +
                "recordIds=" + recordIds +
                '}';
    }
}
