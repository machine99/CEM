package com.baolian.service;

import com.baolian.entity.ResultGametestEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2017-04-18 17:03:59
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
