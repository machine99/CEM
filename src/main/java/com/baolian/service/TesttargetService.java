package com.baolian.service;

import com.baolian.entity.TesttargetEntity;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

import java.util.List;
import java.util.Map;

/**
 * @author ${author}
 * @email ${email}
 * @date 2017-04-18 17:03:59
 */
public interface TesttargetService {

    TesttargetEntity queryObject(Integer id);

    List<TesttargetEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(TesttargetEntity testtarget);

    void update(TesttargetEntity testtarget);

    void delete(Integer id);

    void deleteBatch(Integer[] ids);
}
