package com.baolian.service;

import com.baolian.entity.ResultSpeedtestEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2017-04-18 17:03:59
 */
public interface ResultSpeedtestService {
	
	ResultSpeedtestEntity queryObject(Integer id);
	
	List<ResultSpeedtestEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ResultSpeedtestEntity resultSpeedtest);
	
	void update(ResultSpeedtestEntity resultSpeedtest);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
