package com.baolian.dao;

import com.baolian.entity.ResultYoukutestEntity;

import com.baolian.entity.map.BaseResult;
import com.baolian.entity.map.WebVideoCountResult;

import com.baolian.entity.map.CountyYoukutestResult;
import com.baolian.entity.map.BrasYoukutestResult;


import java.util.List;
import java.util.Map;

/**
 * @author ${author}
 * @email ${email}
 * @date 2017-04-18 17:03:59
 */
public interface ResultYoukutestDao extends BaseDao<ResultYoukutestEntity> {

    List<WebVideoCountResult> queryWebList(Map<String, Object> map);

    List<CountyYoukutestResult> queryCountyYoukuList(Map<String, Object> map);

    List<BrasYoukutestResult> queryBRASYoukuList(Map<String, Object> map);

    List<BaseResult> queryYoukuMonthList(Map<String, Object> map);

}
