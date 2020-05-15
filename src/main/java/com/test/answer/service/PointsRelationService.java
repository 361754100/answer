package com.test.answer.service;

import com.test.answer.dao.PointsInfoDao;
import com.test.answer.dao.PointsRelationDao;
import com.test.answer.dao.model.PointsInfo;
import com.test.answer.dao.model.PointsRelation;
import com.test.answer.enums.ResultCodeEnum;
import com.test.answer.request.PointsRelationEditReq;
import com.test.answer.response.CommonWrapper;
import com.test.answer.response.ListQueryWrapper;
import com.test.answer.response.PageSearchWrapper;
import com.test.answer.response.SingleQueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class PointsRelationService {

    private static final Logger logger = LoggerFactory.getLogger(PointsRelationService.class);

    @Autowired
    private PointsInfoDao pointsInfoDao;

    @Autowired
    private PointsRelationDao pointsRelationDao;

    /**
     * 新增记录
     * @param req
     * @return
     */
    public CommonWrapper addInfo(PointsRelationEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        PointsRelation info = new PointsRelation();
        info.setCostTime(req.getCostTime());
        info.setDistance(req.getDistance());
        info.setStartPoint(req.getStartPoint());
        info.setEndPoint(req.getEndPoint());

        int cnt = pointsRelationDao.saveData(info);
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
    public CommonWrapper updateInfo(PointsRelationEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        PointsRelation info = new PointsRelation();
        info.setCostTime(req.getCostTime());
        info.setDistance(req.getDistance());
        info.setStartPoint(req.getStartPoint());
        info.setEndPoint(req.getEndPoint());

        int cnt = pointsRelationDao.updateData(req.getId(), info);
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
        int cnt = pointsRelationDao.delData(recordIds);

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

        int total = pointsRelationDao.queryPageTotal(pName);
        List<PointsRelation> result = pointsRelationDao.queryPage(pageNo, pageSize, pName);

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

        PointsRelation condition = new PointsRelation();
        condition.setId(recordId);

        List<PointsRelation> result = pointsRelationDao.queryList(condition);
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

        List<PointsRelation> result = pointsRelationDao.listAll();
        if(!CollectionUtils.isEmpty(result)) {
            wrapper.setRecords(result);
        }
        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());

        return wrapper;
    }


    // 剩余点位集合
    private static Set<Integer> leftPoints = null;
    // 已编排点位集合
    private static List<Integer> excludePoints = null;
    // 线路耗时
    private static int lineCost = 0;
    // 返回耗时
    private static int backCost = 0;
    // 最后一个点
    private static PointsRelation lastRelation = null;
    // 线路上的点ID
    private static String linePoints = "";
    /**
     * 多线路规划
     * @param maxTaskTime
     * @param distanceRadius
     * @return
     */
    public SingleQueryWrapper linesPlan(int maxTaskTime, int distanceRadius) {
        SingleQueryWrapper wrapper = new SingleQueryWrapper();
        List<PointsInfo> pointList = pointsInfoDao.listAll();
        if(CollectionUtils.isEmpty(pointList)) {
            wrapper.setResultMsg("点位信息为空...");
            wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
            return wrapper;
        }
        PointsInfo companyPoint = null;
        leftPoints = new HashSet<>();
        excludePoints = new ArrayList<>();
        for(PointsInfo pointsInfo:pointList) {
            if(pointsInfo.getPtype() == 0) {
                companyPoint = pointsInfo;
                continue;
            }
            leftPoints.add(pointsInfo.getId());
        }

        if(companyPoint == null) {
            wrapper.setResultMsg("没配置起点信息...");
            wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());
            return wrapper;
        }
        excludePoints.add(companyPoint.getId());

        Map<String, String> lineMap = new HashMap<>();
        int lineNum = 0;
        while(!leftPoints.isEmpty()) {
            lineNum++;
            lineCost = 0;
            backCost = 0;
            linePoints = "";
            lastRelation = null;

            lineRandom(companyPoint.getId(), companyPoint.getId(), maxTaskTime, distanceRadius);

            String tmpLinePoints = companyPoint.getId()+ " -> " + linePoints + companyPoint.getId();
            PointsRelation backCompany = pointsRelationDao.queryPointRelation(lastRelation.getStartPoint(), companyPoint.getId());
            int totalCost = lineCost + backCompany.getCostTime();

            String lineName = "线路["+ lineNum +"]_耗时("+ totalCost +")minutes";

            logger.info("lineNo = {}, lineCost = {}, linePoints = {}", lineName, totalCost, tmpLinePoints);
            lineMap.put(lineName, tmpLinePoints);
        }
        wrapper.setResultMsg("线路规划结果");
        wrapper.setRecord(lineMap);
        return wrapper;
    }

    /**
     * 根据约束条件生成一条线路
     * @param startPoint
     * @param maxTaskTime
     * @param distanceRadius
     */
    private void lineRandom(int companyPoint, int startPoint, int maxTaskTime, int distanceRadius) {
        if(lineCost + backCost >= maxTaskTime) {
            return;
        }
        PointsRelation nextPoint = findShortRelation(startPoint, distanceRadius, excludePoints);
        if(nextPoint == null) {
            return;
        }

        //要加上该点回公司的时间
        PointsRelation backCompany = pointsRelationDao.queryPointRelation(nextPoint.getEndPoint(), companyPoint);
        backCost = backCompany.getCostTime();
        int tmpTime = lineCost + nextPoint.getCostTime() + backCost;
        if(tmpTime >= maxTaskTime) {
            lastRelation = nextPoint;
            return;
        }

        linePoints += nextPoint.getEndPoint() + " -> ";
        lineCost += nextPoint.getCostTime();

        // 找到符合条件的点，则把它从集合中移除
        leftPoints.remove(nextPoint.getEndPoint());
        excludePoints.add(nextPoint.getEndPoint());

        if(leftPoints.size() > 0 && (lineCost + backCost) < maxTaskTime) {
            lineRandom(companyPoint, nextPoint.getEndPoint(), maxTaskTime, distanceRadius);
        } else {
            lastRelation = backCompany;
        }
    }

    /**
     * 查找相邻最近的点
     * @param startPoint
     * @param distanceRadius
     * @param excludePoints
     * @return
     */
    private PointsRelation findShortRelation(int startPoint, int distanceRadius, List<Integer> excludePoints) {
        PointsRelation nextPoint = pointsRelationDao.queryShortPointRelation(startPoint, distanceRadius, excludePoints);
        if(nextPoint == null) {
            int multiple = 1;

            while(nextPoint == null) {
                multiple++;
                int tmpRadius = distanceRadius * multiple;

                nextPoint = pointsRelationDao.queryShortPointRelation(startPoint, tmpRadius, excludePoints);
            }
        }
        return nextPoint;
    }
}
