package com.baolian.dao;

import com.baolian.entity.ResultSpeedtestEntity;
import com.baolian.entity.map.WebSpeedCountResult;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2017-04-18 17:03:59
 */
public interface ResultSpeedtestDao extends BaseDao<ResultSpeedtestEntity> {
    List<WebSpeedCountResult> queryWebList(Map<String, Object> map);
}
