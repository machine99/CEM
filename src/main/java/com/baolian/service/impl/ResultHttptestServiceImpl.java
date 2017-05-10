package com.baolian.service.impl;


import com.baolian.entity.map.*;
import com.baolian.dao.datasouce.annotation.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baolian.dao.ResultHttptestDao;
import com.baolian.entity.ResultHttptestEntity;
import com.baolian.service.ResultHttptestService;


@DataSource("db_remote")
@Service("resultHttptestService")
public class ResultHttptestServiceImpl implements ResultHttptestService {

    @Autowired
    private ResultHttptestDao resultHttptestDao;

    @Override
    public ResultHttptestEntity queryObject(Integer id) {
        return resultHttptestDao.queryObject(id);
    }

    @Override
    public List<ResultHttptestEntity> queryList(Map<String, Object> map) {
        return resultHttptestDao.queryList(map);
    }

    @Override
    public List<CountyHttptestResult> queryCountyHttpList(Map<String, Object> map) {
        return resultHttptestDao.queryCountyHttpList(map);
    }

    /*门户感知*/
    @Override
    public List<WebHttpCountResult> queryWebList(Map<String, Object> map) {
        return resultHttptestDao.queryWebList(map);
    }

    @Override
    public List<BrasHttptestResult> queryBRASHttpList(Map<String, Object> map) {
        return resultHttptestDao.queryBRASHttpList(map);
    }

    @Override
    public List<BaseResult> queryHttpMonthList(Map<String, Object> map) {
        return resultHttptestDao.queryHttpMonthList(map);
    }

    @Override
    public List<TopAliasResult> queryTopAlias(Map<String, Object> map) {
        return resultHttptestDao.queryTopAlias(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return resultHttptestDao.queryTotal(map);
    }

    @Override
    public void save(ResultHttptestEntity resultHttptest) {
        resultHttptestDao.save(resultHttptest);
    }

    @Override
    public void update(ResultHttptestEntity resultHttptest) {
        resultHttptestDao.update(resultHttptest);
    }

    @Override
    public void delete(Integer id) {
        resultHttptestDao.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
        resultHttptestDao.deleteBatch(ids);
    }


}
