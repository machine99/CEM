package com.baolian.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.*;

/**
 * Created by tomxie on 2017/4/18 21:45.
 */
public class JSONTest {
    private static String jsonStr = "{\"name\":\"test\",\"ip\":\"192.168.1.1\",\"city_man\":\"西安市\",\"county\":\"莲湖区\",\"useruid\":\"123\",\"sysuuid\":\"111111\",\"testgroup_name\":\"视频类测试\",\"model\":\"aaa\",\"brasname\":\"bras1\"}";

    @Test
    public void RunJSONTest() {
        JSONObject json = JSONObject.parseObject(jsonStr);
        Map<String, Object> jsonMap = jsonToMap(json);
        for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
            System.out.println(String.format("%s:%s", entry.getKey(), entry.getValue()));
        }
    }

    public static Map<String, Object> jsonToMap(JSONObject json) throws JSONException {
        Map<String, Object> retMap = new HashMap<String, Object>();

        if (json != null) {
            retMap = toMap(json);
        }
        return retMap;
    }

    private static Map<String, Object> toMap(JSONObject object) throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();

        Iterator<String> keysItr = object.keySet().iterator();
        while (keysItr.hasNext()) {
            String key = keysItr.next();
            Object value = object.get(key);

            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, value);
        }
        return map;
    }

    private static List<Object> toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<Object>();
        for (Object value : array) {
            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            list.add(value);
        }
        return list;
    }
}
