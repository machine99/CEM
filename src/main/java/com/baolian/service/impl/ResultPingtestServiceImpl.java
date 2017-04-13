package com.baolian.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.baolian.dao.ResultPingtestDao;
import com.baolian.entity.ResultPingtestEntity;
import com.baolian.service.ResultPingtestService;


@Service("resultPingtestService")
public class ResultPingtestServiceImpl implements ResultPingtestService {
    @Autowired
    private ResultPingtestDao resultPingtestDao;

    @Override
    public ResultPingtestEntity queryObject(Integer id) {
        return resultPingtestDao.queryObject(id);
    }

    @Override
    public List<ResultPingtestEntity> queryList(Map<String, Object> map) {
        return resultPingtestDao.queryList(map);
    }

    @Override
    public List<ResultPingtestEntity> queryAreaPingList(Map<String, Object> map) {
        List<ResultPingtestEntity> testlist = new ArrayList<>();
        System.out.println("取得的地区为:"+map.get("area").equals(""));
        ResultPingtestEntity area1 = new ResultPingtestEntity();
        ResultPingtestEntity area2 = new ResultPingtestEntity();
        if(map.get("area").equals("")){        /*默认新城区和碑林区*/
        area1.setGuid("新城区");
        area1.setRttAvg(17.66);
        area1.setRttMax(18.77);
        area1.setRttMin(16.55);
        area1.setLoss(23.0);
        area1.setQoe(98.233);

        area2.setGuid("碑林区");
        area2.setRttAvg(18.33);
        area2.setRttMax(20.99);
        area2.setRttMin(14.55);
        area2.setLoss(12.0);
        area2.setQoe(96.366);

        testlist.add(area1);
        testlist.add(area2);
        }else {     /*返回选择的区域*/
            area1.setGuid((String) map.get("area"));
            area1.setRttAvg(19.33);
            area1.setRttMax(21.33);
            area1.setRttMin(18.55);
            area1.setLoss(17.0);
            area1.setQoe(95.33);
            testlist.add(area1);
        }
        return testlist;
        /*return resultPingtestDao.queryAreaPingList(map);*/
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return resultPingtestDao.queryTotal(map);
    }

    @Override
    public void save(ResultPingtestEntity resultPingtest) {
        resultPingtestDao.save(resultPingtest);
    }

    @Override
    public void update(ResultPingtestEntity resultPingtest) {
        resultPingtestDao.update(resultPingtest);
    }

    @Override
    public void delete(Integer id) {
        resultPingtestDao.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
        resultPingtestDao.deleteBatch(ids);
    }

}
