package com.baolian.service;

import com.baolian.entity.ResultGametestEntity;

import java.util.List;
import java.util.Map;

/**
 * 游戏测试结果表
 *
 * @author ${author}
 * @email ${email}
 * @date 2017-03-31 14:49:21
 */
public interface ResultGametestService {

    ResultGametestEntity queryObject(Integer id);

    List<ResultGametestEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(ResultGametestEntity resultGametest);

    void update(ResultGametestEntity resultGametest);

    void delete(Integer id);

    void deleteBatch(Integer[] ids);
}
