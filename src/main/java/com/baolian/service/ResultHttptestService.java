package com.baolian.service;

import com.baolian.entity.ResultHttptestEntity;
import com.baolian.entity.map.BrasHttptestResult;
import com.baolian.entity.map.CountyHttptestResult;
import com.baolian.entity.map.WebHttpCountResult;

import java.util.List;
import java.util.Map;

/**
 * @author ${author}
 * @email ${email}
 * @date 2017-04-18 17:03:59
 */
public interface ResultHttptestService {


    ResultHttptestEntity queryObject(Integer id);

    List<ResultHttptestEntity> queryList(Map<String, Object> map);

    List<CountyHttptestResult> queryCountyHttpList(Map<String, Object> map);

	/*门户感知*/
	List<WebHttpCountResult> queryWebList(Map<String, Object> map);

    List<BrasHttptestResult> queryBRASHttpList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(ResultHttptestEntity resultHttptest);

    void update(ResultHttptestEntity resultHttptest);

    void delete(Integer id);

    void deleteBatch(Integer[] ids);

}
