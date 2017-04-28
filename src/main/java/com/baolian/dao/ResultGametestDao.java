package com.baolian.dao;

import com.baolian.entity.ResultGametestEntity;
import com.baolian.entity.map.CountyGametestResult;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2017-04-18 17:03:59
 */
public interface ResultGametestDao extends BaseDao<ResultGametestEntity> {

    List<CountyGametestResult> queryCountyGameList(Map<String, Object> map);
	
}
