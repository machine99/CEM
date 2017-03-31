package com.baolian.service;

import com.baolian.entity.ResultYoukutestEntity;

import java.util.List;
import java.util.Map;

/**
 * 视频测试结果表
 *
 * @author ${author}
 * @email ${email}
 * @date 2017-03-31 14:49:21
 */
public interface ResultYoukutestService {

    ResultYoukutestEntity queryObject(Integer id);

    List<ResultYoukutestEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(ResultYoukutestEntity resultYoukutest);

    void update(ResultYoukutestEntity resultYoukutest);

    void delete(Integer id);

    void deleteBatch(Integer[] ids);
}
