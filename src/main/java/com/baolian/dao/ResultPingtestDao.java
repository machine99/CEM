package com.baolian.dao;

import com.baolian.entity.ResultPingtestEntity;
import com.baolian.entity.map.CountyPingtestResult;
import com.baolian.entity.map.WebPingCountResult;

import java.util.List;
import java.util.Map;

/**
 * @author ${author}
 * @email ${email}
 * @date 2017-04-18 17:03:59
 */
public interface ResultPingtestDao extends BaseDao<ResultPingtestEntity> {
    /**
     * 通过时间范围以及区域查询区域Ping感知数据
     *
     * @param map 输入参数：开始结束时间，地区
     * @return 返回自定义resultMap列表
     */
    List<CountyPingtestResult> queryCountyPingList(Map<String, Object> map);
    List<WebPingCountResult> queryWebList(Map<String, Object> map);
}
