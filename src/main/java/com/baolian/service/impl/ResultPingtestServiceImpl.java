package com.baolian.service.impl;

import com.baolian.dao.datasouce.annotation.DataSource;
import com.baolian.entity.map.CountyPingtestResult;
import com.baolian.entity.map.WebPingCountResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baolian.dao.ResultPingtestDao;
import com.baolian.entity.ResultPingtestEntity;
import com.baolian.service.ResultPingtestService;

@DataSource("db_remote")
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


    public List<WebPingCountResult> queryWebList(Map<String, Object> map) {
        return resultPingtestDao.queryWebList(map);
    }


    @Override
    public List<CountyPingtestResult> queryCountyPingList(Map<String, Object> map) {
        return resultPingtestDao.queryCountyPingList(map);
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
