package com.baolian.service;

import com.baolian.entity.TestagentEntity;

import java.util.List;
import java.util.Map;

/**
 * 探针信息表
 *
 * @author ${author}
 * @email ${email}
 * @date 2017-03-31 14:49:21
 */
public interface TestagentService {

    TestagentEntity queryObject(Integer id);

    List<TestagentEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(TestagentEntity testagent);

    void update(TestagentEntity testagent);

    void delete(Integer id);

    void deleteBatch(Integer[] ids);
}
