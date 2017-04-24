package com.baolian.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baolian.utils.JSONUtils;
import com.baolian.utils.RRException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.velocity.app.event.implement.EscapeXmlReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.baolian.entity.TestagentEntity;
import com.baolian.service.TestagentService;
import com.baolian.utils.PageUtils;
import com.baolian.utils.R;


/**
 * @date 2017-04-18 17:03:59
 */
@Controller
@RequestMapping("testagent")
public class TestagentController {
    @Autowired
    private TestagentService testagentService;

    @RequestMapping("/testagent.html")
    public String list() {
        return "testagent/testagent.html";
    }

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("testagent:list")
    public R list(String probedata, Integer page, Integer limit) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("offset", (page - 1) * limit);
        map.put("limit", limit);
        JSONObject probedata_jsonobject = JSONObject.parseObject(probedata);
        try {
            map.putAll(JSONUtils.jsonToMap(probedata_jsonobject));
        } catch (RuntimeException e) {
            throw new RRException("内部参数错误，请重试！");
        }
        List<TestagentEntity> testagentList = testagentService.queryList(map);
        int total = testagentService.queryTotal(map);
        PageUtils pageUtil = new PageUtils(testagentList, total, limit, page);
        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("testagent:info")
    public R info(@PathVariable("id") Long id) {
        TestagentEntity testagent = testagentService.queryObject(id);

        return R.ok().put("testagent", testagent);
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    @RequiresPermissions("testagent:save")
    public R save(@RequestBody TestagentEntity testagent) {    /*介绍json数组对象*/
        testagentService.save(testagent);
        return R.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("testagent:update")
    public R update(@RequestBody TestagentEntity testagent) {
        testagentService.update(testagent);
        return R.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping("/delete")
    @RequiresPermissions("testagent:delete")
    public R delete(@RequestBody Long[] ids) {
        testagentService.deleteBatch(ids);
        // for (Long id : ids) {
        //     System.out.println(id);
        // }
        return R.ok();
    }
}
