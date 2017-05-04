package com.baolian.dao;

import com.baolian.entity.TestagentEntity;

import java.util.List;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2017-04-18 17:03:59
 */
public interface TestagentDao extends BaseDao<TestagentEntity> {
	List<String> queryBrasNames();
}
