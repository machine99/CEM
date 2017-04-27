package com.baolian.service;

import com.baolian.entity.TestgroupEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2017-04-18 17:03:59
 */
public interface TestgroupService {

	TestgroupEntity queryObject(Integer id);
	
	List<TestgroupEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TestgroupEntity testgroup);
	
	void update(TestgroupEntity testgroup);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
