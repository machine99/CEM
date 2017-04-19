package com.baolian.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baolian.dao.TesttargetDao;
import com.baolian.entity.TesttargetEntity;
import com.baolian.service.TesttargetService;



@Service("testtargetService")
public class TesttargetServiceImpl implements TesttargetService {
	@Autowired
	private TesttargetDao testtargetDao;
	
	@Override
	public TesttargetEntity queryObject(Integer id){
		return testtargetDao.queryObject(id);
	}
	
	@Override
	public List<TesttargetEntity> queryList(Map<String, Object> map){
		return testtargetDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return testtargetDao.queryTotal(map);
	}
	
	@Override
	public void save(TesttargetEntity testtarget){
		testtargetDao.save(testtarget);
	}
	
	@Override
	public void update(TesttargetEntity testtarget){
		testtargetDao.update(testtarget);
	}
	
	@Override
	public void delete(Integer id){
		testtargetDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		testtargetDao.deleteBatch(ids);
	}
	
}
