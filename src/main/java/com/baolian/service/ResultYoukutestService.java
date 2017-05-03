package com.baolian.service;

import com.baolian.entity.ResultYoukutestEntity;
import com.baolian.entity.map.CountyYoukutestResult;
import com.baolian.entity.map.BrasYoukutestResult;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2017-04-18 17:03:59
 */
public interface ResultYoukutestService {
	
	ResultYoukutestEntity queryObject(Integer id);
	
	List<ResultYoukutestEntity> queryList(Map<String, Object> map);

	List<CountyYoukutestResult> queryCountyYoukuList(Map<String, Object> map);

	List<BrasYoukutestResult> queryBRASYoukuList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ResultYoukutestEntity resultYoukutest);
	
	void update(ResultYoukutestEntity resultYoukutest);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
