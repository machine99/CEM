package com.baolian.service.impl;

import com.baolian.dao.datasouce.annotation.DataSource;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baolian.dao.TestagentDao;
import com.baolian.entity.TestagentEntity;
import com.baolian.service.TestagentService;


@DataSource("db_remote")
@Service("testagentService")
public class TestagentServiceImpl implements TestagentService {
    @Autowired
    private TestagentDao testagentDao;

    @Override
    public TestagentEntity queryObject(Long id) {
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
    public void delete(Long id) {
        testagentDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        testagentDao.deleteBatch(ids);
    }

}
