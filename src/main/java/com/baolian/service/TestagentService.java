package com.baolian.service;

import com.baolian.entity.TestagentEntity;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

import java.util.List;
import java.util.Map;

/**
 * @author ${author}
 * @email ${email}
 * @date 2017-04-18 17:03:59
 */
public interface TestagentService {

    TestagentEntity queryObject(Long id);

    List<TestagentEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    List<String> queryBrasNames();

    void save(TestagentEntity testagent);

    void update(TestagentEntity testagent) ;

    void delete(Long id);

    void deleteBatch(Long[] ids);
}
