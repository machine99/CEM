package com.baolian.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baolian.dao.TestagentDao;
import com.baolian.entity.TestagentEntity;
import com.baolian.service.TestagentService;


@Service("testagentService")
public class TestagentServiceImpl implements TestagentService {
    @Autowired
    private TestagentDao testagentDao;

    @Override
    public TestagentEntity queryObject(Integer id) {
        return testagentDao.queryObject(id);
    }

    @Override
    public List<TestagentEntity> queryList(Map<String, Object> map) {
        return testagentDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return testagentDao.queryTotal(map);
    }

    @Override
    public void save(TestagentEntity testagent) {
        testagentDao.save(testagent);
    }

    @Override
    public void update(TestagentEntity testagent) {
        testagentDao.update(testagent);
    }

    @Override
    public void delete(Integer id) {
        testagentDao.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
        testagentDao.deleteBatch(ids);
    }

}
