package com.baolian.service;

import com.baolian.entity.ResultPingtestEntity;
import com.baolian.entity.map.CountyPingtestResult;
import com.baolian.entity.map.WebPingCountResult;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2017-04-18 17:03:59
 */
public interface ResultPingtestService {
	
	ResultPingtestEntity queryObject(Integer id);
	
	List<ResultPingtestEntity> queryList(Map<String, Object> map);

	List<CountyPingtestResult> queryCountyPingList(Map<String, Object> map);

	List<WebPingCountResult> queryWebList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ResultPingtestEntity resultPingtest);
	
	void update(ResultPingtestEntity resultPingtest);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
