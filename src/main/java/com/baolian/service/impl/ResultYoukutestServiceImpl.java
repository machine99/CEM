package com.baolian.service.impl;

import com.baolian.dao.datasouce.annotation.DataSource;
import com.baolian.entity.map.WebVideoCountResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baolian.dao.ResultYoukutestDao;
import com.baolian.entity.ResultYoukutestEntity;
import com.baolian.service.ResultYoukutestService;


@DataSource("db_remote")
@Service("resultYoukutestService")
public class ResultYoukutestServiceImpl implements ResultYoukutestService {
    @Autowired
    private ResultYoukutestDao resultYoukutestDao;

    @Override
    public ResultYoukutestEntity queryObject(Integer id) {
        return resultYoukutestDao.queryObject(id);
    }

    @Override
    public List<ResultYoukutestEntity> queryList(Map<String, Object> map) {
        return resultYoukutestDao.queryList(map);
    }

    @Override
    public List<WebVideoCountResult> queryWebList(Map<String, Object> map) {
        return resultYoukutestDao.queryWebList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return resultYoukutestDao.queryTotal(map);
    }

    @Override
    public void save(ResultYoukutestEntity resultYoukutest) {
        resultYoukutestDao.save(resultYoukutest);
    }

    @Override
    public void update(ResultYoukutestEntity resultYoukutest) {
        resultYoukutestDao.update(resultYoukutest);
    }

    @Override
    public void delete(Integer id) {
        resultYoukutestDao.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
        resultYoukutestDao.deleteBatch(ids);
    }

}
