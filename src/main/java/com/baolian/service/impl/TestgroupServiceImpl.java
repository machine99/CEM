package com.baolian.service.impl;

import com.baolian.dao.datasouce.annotation.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baolian.dao.TestgroupDao;
import com.baolian.entity.TestgroupEntity;
import com.baolian.service.TestgroupService;


@DataSource("db_remote")
@Service("testgroupService")
public class TestgroupServiceImpl implements TestgroupService {
    @Autowired
    private TestgroupDao testgroupDao;

    @Override
    public TestgroupEntity queryObject(Integer id) {
        return testgroupDao.queryObject(id);
    }

    @Override
    public List<TestgroupEntity> queryList(Map<String, Object> map) {
        return testgroupDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return testgroupDao.queryTotal(map);
    }

    @Override
    public void save(TestgroupEntity testgroup) {
        testgroupDao.save(testgroup);
    }

    @Override
    public void update(TestgroupEntity testgroup) {
        testgroupDao.update(testgroup);
    }

    @Override
    public void delete(Integer id) {
        testgroupDao.delete(id);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
        testgroupDao.deleteBatch(ids);
    }

}
