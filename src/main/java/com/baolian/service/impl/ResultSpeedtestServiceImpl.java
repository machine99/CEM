package com.baolian.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baolian.dao.ResultSpeedtestDao;
import com.baolian.entity.ResultSpeedtestEntity;
import com.baolian.service.ResultSpeedtestService;



@Service("resultSpeedtestService")
public class ResultSpeedtestServiceImpl implements ResultSpeedtestService {
	@Autowired
	private ResultSpeedtestDao resultSpeedtestDao;
	
	@Override
	public ResultSpeedtestEntity queryObject(Integer id){
		return resultSpeedtestDao.queryObject(id);
	}
	
	@Override
	public List<ResultSpeedtestEntity> queryList(Map<String, Object> map){
		return resultSpeedtestDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return resultSpeedtestDao.queryTotal(map);
	}
	
	@Override
	public void save(ResultSpeedtestEntity resultSpeedtest){
		resultSpeedtestDao.save(resultSpeedtest);
	}
	
	@Override
	public void update(ResultSpeedtestEntity resultSpeedtest){
		resultSpeedtestDao.update(resultSpeedtest);
	}
	
	@Override
	public void delete(Integer id){
		resultSpeedtestDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		resultSpeedtestDao.deleteBatch(ids);
	}
	
}
