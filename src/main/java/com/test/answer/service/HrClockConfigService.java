package com.test.answer.service;

import com.test.answer.dao.HrClockConfigDao;
import com.test.answer.dao.HrClockConfigDao;
import com.test.answer.dao.model.HrClockConfig;
import com.test.answer.enums.ResultCodeEnum;
import com.test.answer.request.HrClockConfigEditReq;
import com.test.answer.response.CommonWrapper;
import com.test.answer.response.ListQueryWrapper;
import com.test.answer.response.PageSearchWrapper;
import com.test.answer.response.SingleQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class HrClockConfigService {

    @Autowired
    private HrClockConfigDao hrClockConfigDao;

    /**
     * 修改记录
     * @param req
     * @return
     */
    public CommonWrapper updateInfo(HrClockConfigEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        HrClockConfig info = new HrClockConfig();
        info.setClockInTime(req.getClockInTime());
        info.setClockOutTime(req.getClockOutTime());

        int cnt = hrClockConfigDao.updateData(info);
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
        }
        return wrapper;
    }

}
