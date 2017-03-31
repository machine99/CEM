package com.baolian.service;

import com.baolian.entity.ResultHttptestEntity;

import java.util.List;
import java.util.Map;

/**
 * 网页测试结果表
 *
 * @author ${author}
 * @email ${email}
 * @date 2017-03-31 14:49:21
 */
public interface ResultHttptestService {

    ResultHttptestEntity queryObject(Integer id);

    List<ResultHttptestEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(ResultHttptestEntity resultHttptest);

    void update(ResultHttptestEntity resultHttptest);

    void delete(Integer id);

    void deleteBatch(Integer[] ids);
}
