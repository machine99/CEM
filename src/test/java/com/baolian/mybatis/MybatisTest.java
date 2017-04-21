package com.baolian.mybatis;

import com.baolian.entity.map.CountyPingtestResult;
import com.baolian.service.ResultPingtestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Mybatis测试类
 * Created by tomxie on 2017/4/20 13:47.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-baolian.xml"})
public class MybatisTest {
    @Autowired
    private ResultPingtestService resultPingtestService;

    @Test
    public void RunMybatisTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("county", "碑林区");
        map.put("starttime", "2016-12-07 00:00:00");
        map.put("endtime", "2017-02-07 00:00:00");
        List<CountyPingtestResult> results = resultPingtestService.queryCountyPingList(map);
        for (CountyPingtestResult result : results) {
            System.out.println(result);
        }
    }
}
