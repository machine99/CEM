package com.baolian.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baolian.dao.ResultGametestDao;
import com.baolian.entity.ResultGametestEntity;
import com.baolian.service.ResultGametestService;


@Service("resultGametestService")
public class ResultGametestServiceImpl implements ResultGametestService {
    @Autowired
    private ResultGametestDao resultGametestDao;

    @Override
    public ResultGametestEntity queryObject(Integer id) {
        return resultGametestDao.queryObject(id);
    }

    @Override
    public List<ResultGametestEntity> queryList(Map<String, Object> map) {
        return resultGametestDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return resultGametestDao.queryTotal(map);
    }

    @Override
    public void save(ResultGametestEntity resultGametest) {
        resultGametestDao.save(resultGametest);
    }

    @Override
    public void update(ResultGametestEntity resultGametest) {
        resultGametestDao.update(resultGametest);
    }

    @Override
    public void delete(Integer id) {
        resultGametestDao.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
        resultGametestDao.deleteBatch(ids);
    }

}
