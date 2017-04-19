package com.baolian.service;

import com.baolian.entity.TargetGroupEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2017-04-18 17:03:59
 */
public interface TargetGroupService {
	
	TargetGroupEntity queryObject(Integer id);
	
	List<TargetGroupEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TargetGroupEntity targetGroup);
	
	void update(TargetGroupEntity targetGroup);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
