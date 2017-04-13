package com.baolian.service;

import com.baolian.entity.ResultPingtestEntity;

import java.util.List;
import java.util.Map;

/**
 * ping测试结果表
 *
 * @author ${author}
 * @email ${email}
 * @date 2017-03-31 14:49:21
 */
public interface ResultPingtestService {

    ResultPingtestEntity queryObject(Integer id);

    List<ResultPingtestEntity> queryList(Map<String, Object> map);

    List<ResultPingtestEntity> queryAreaPingList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(ResultPingtestEntity resultPingtest);

    void update(ResultPingtestEntity resultPingtest);

    void delete(Integer id);

    void deleteBatch(Integer[] ids);
}
