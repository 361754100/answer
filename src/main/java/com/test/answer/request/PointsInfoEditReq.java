package com.test.answer.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "点位信息消息体")
public class PointsInfoEditReq implements Serializable {

    @ApiModelProperty(value = "点位ID")
    private Integer id;

    @ApiModelProperty(value = "点位名称")
    private String pname;

    @ApiModelProperty(value = "点位类型(0：出发点，1：设备点)")
    private Integer ptype;

    @ApiModelProperty(value = "点位经度")
    private Double lng;

    @ApiModelProperty(value = "点位纬度")
    private Double lat;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getPtype() {
        return ptype;
    }

    public void setPtype(Integer ptype) {
        this.ptype = ptype;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PointsInfoEditReq{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", ptype=" + ptype +
                ", lng=" + lng +
                ", lat=" + lat +
                '}';
    }
}