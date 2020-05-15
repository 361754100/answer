package com.test.answer.enums;

import java.util.Arrays;
import java.util.List;

/**
 * 考勤记录状态码
 * 0：正常、-1：迟到、1：加班、-2：早退
 */
public enum HrClockHisStateEnum {

    UNKNOW(-100, "未知"),
    NORMAL(0, "正常"),
    HARD(1, "加班"),
    LATE(-1, "迟到"),
    EARLY(-2, "早退");

    private int code;
    private String desc;
    private static HrClockHisStateEnum[] values = values();

    HrClockHisStateEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    public static HrClockHisStateEnum getState(int code) {
        HrClockHisStateEnum result = UNKNOW;
        for(HrClockHisStateEnum codeEnum : values) {
            if(codeEnum.getCode() == code) {
                result = codeEnum;
                break;
            }
        }
        return result;
    }

    public static List<HrClockHisStateEnum> getCodes() {
        HrClockHisStateEnum[] enums = values();
        List<HrClockHisStateEnum> list = Arrays.asList(enums);
        return list;
    }

}
