package com.baolian.dao;

import com.baolian.entity.ScheduleJobEntity;

import java.util.Map;

/**
 * 定时任务
 * 
 *
 *
 * @date 2016年12月1日 下午10:29:57
 */
public interface ScheduleJobDao extends BaseDao<ScheduleJobEntity> {
	
	/**
	 * 批量更新状态
	 */
	int updateBatch(Map<String, Object> map);
}
