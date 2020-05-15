package com.test.answer.service;

import com.test.answer.dao.PointsInfoDao;
import com.test.answer.dao.model.PointsInfo;
import com.test.answer.enums.ResultCodeEnum;
import com.test.answer.request.PointsInfoEditReq;
import com.test.answer.response.CommonWrapper;
import com.test.answer.response.ListQueryWrapper;
import com.test.answer.response.PageSearchWrapper;
import com.test.answer.response.SingleQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class PointsInfoService {

    @Autowired
    private PointsInfoDao pointsInfoDao;

    /**
     * 新增记录
     * @param req
     * @return
     */
    public CommonWrapper addInfo(PointsInfoEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        PointsInfo info = new PointsInfo();
        info.setPname(req.getPname());
        info.setPtype(req.getPtype());
        info.setLng(req.getLng());
        info.setLat(req.getLat());

        int cnt = pointsInfoDao.saveData(info);
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
        }
        return wrapper;
    }

    /**
     * 修改记录
     * @param req
     * @return
     */
    public CommonWrapper updateInfo(PointsInfoEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        PointsInfo info = new PointsInfo();
        info.setPname(req.getPname());
        info.setPtype(req.getPtype());
        info.setLng(req.getLng());
        info.setLat(req.getLat());

        int cnt = pointsInfoDao.updateData(req.getId(), info);
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
        }
        return wrapper;
    }

    /**
     * 删除记录
     * @param recordIds
     * @return
     */
    public CommonWrapper deleteInfo(List<Integer> recordIds) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
        int cnt = pointsInfoDao.delData(recordIds);

        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        wrapper.setResultMsg("成功删除【"+ cnt +"】条记录");

        return wrapper;
    }

    /**
     * 分页查询
     * @param pageNo    当前页
     * @param pageSize  每页大小
     * @param pName     名称关键字
     * @return
     */
    public PageSearchWrapper queryPage(int pageNo, int pageSize, String pName) {
        PageSearchWrapper wrapper = new PageSearchWrapper();

        int total = pointsInfoDao.queryPageTotal(pName);
        List<PointsInfo> result = pointsInfoDao.queryPage(pageNo, pageSize, pName);

        wrapper.setTotalCount(total);
        wrapper.setPageNo(pageNo);
        wrapper.setRecords(result);
        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());

        return wrapper;
    }

    /**
     * 查询单个结果
     * @param recordId
     * @return
     */
    public SingleQueryWrapper findRecordById(Integer recordId) {
        SingleQueryWrapper wrapper = new SingleQueryWrapper();

        PointsInfo condition = new PointsInfo();
        condition.setId(recordId);

        List<PointsInfo> result = pointsInfoDao.queryList(condition);
        if(!CollectionUtils.isEmpty(result)) {
            wrapper.setRecord(result.get(0));
        }
        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());

        return wrapper;
    }

    /**
     * 查询单个结果
     * @return
     */
    public ListQueryWrapper listAll() {
        ListQueryWrapper wrapper = new ListQueryWrapper();

        List<PointsInfo> result = pointsInfoDao.listAll();
        if(!CollectionUtils.isEmpty(result)) {
            wrapper.setRecords(result);
        }
        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());

        return wrapper;
    }
}
