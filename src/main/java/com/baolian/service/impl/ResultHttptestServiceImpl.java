package com.baolian.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baolian.dao.ResultHttptestDao;
import com.baolian.entity.ResultHttptestEntity;
import com.baolian.service.ResultHttptestService;



@Service("resultHttptestService")
public class ResultHttptestServiceImpl implements ResultHttptestService {
	@Autowired
	private ResultHttptestDao resultHttptestDao;
	
	@Override
	public ResultHttptestEntity queryObject(Integer id){
		return resultHttptestDao.queryObject(id);
	}
	
	@Override
	public List<ResultHttptestEntity> queryList(Map<String, Object> map){
		return resultHttptestDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return resultHttptestDao.queryTotal(map);
	}
	
	@Override
	public void save(ResultHttptestEntity resultHttptest){
		resultHttptestDao.save(resultHttptest);
	}
	
	@Override
	public void update(ResultHttptestEntity resultHttptest){
		resultHttptestDao.update(resultHttptest);
	}
	
	@Override
	public void delete(Integer id){
		resultHttptestDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		resultHttptestDao.deleteBatch(ids);
	}
	
}
