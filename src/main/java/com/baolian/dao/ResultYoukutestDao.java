package com.baolian.dao;

import com.baolian.entity.ResultYoukutestEntity;
import com.baolian.entity.map.WebVideoCountResult;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2017-04-18 17:03:59
 */
public interface ResultYoukutestDao extends BaseDao<ResultYoukutestEntity> {
    List<WebVideoCountResult> queryWebList(Map<String, Object> map);
	
}
