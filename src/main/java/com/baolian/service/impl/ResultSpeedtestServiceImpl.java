package com.baolian.service.impl;

import com.baolian.dao.datasouce.annotation.DataSource;
import com.baolian.entity.map.WebSpeedCountResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baolian.dao.ResultSpeedtestDao;
import com.baolian.entity.ResultSpeedtestEntity;
import com.baolian.service.ResultSpeedtestService;


@DataSource("db_remote")
@Service("resultSpeedtestService")
public class ResultSpeedtestServiceImpl implements ResultSpeedtestService {
    @Autowired
    private ResultSpeedtestDao resultSpeedtestDao;

    @Override
    public ResultSpeedtestEntity queryObject(Integer id) {
        return resultSpeedtestDao.queryObject(id);
    }

    @Override
    public List<ResultSpeedtestEntity> queryList(Map<String, Object> map) {
        return resultSpeedtestDao.queryList(map);
    }

    @Override
    public List<WebSpeedCountResult> queryWebList(Map<String, Object> map) {
        return resultSpeedtestDao.queryWebList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return resultSpeedtestDao.queryTotal(map);
    }

    @Override
    public void save(ResultSpeedtestEntity resultSpeedtest) {
        resultSpeedtestDao.save(resultSpeedtest);
    }

    @Override
    public void update(ResultSpeedtestEntity resultSpeedtest) {
        resultSpeedtestDao.update(resultSpeedtest);
    }

    @Override
    public void delete(Integer id) {
        resultSpeedtestDao.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
        resultSpeedtestDao.deleteBatch(ids);
    }

}
