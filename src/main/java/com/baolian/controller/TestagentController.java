package com.baolian.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
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
 * 探针信息表
 *
 * @date 2017-03-31 14:49:21
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
    public R list(Integer page, Integer limit) {
        Map<String, Object> map = new HashMap<>();
        map.put("offset", (page - 1) * limit);
        map.put("limit", limit);

        //查询列表数据
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
    public R info(@PathVariable("id") Integer id) {
        TestagentEntity testagent = testagentService.queryObject(id);

        return R.ok().put("testagent", testagent);
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    @RequiresPermissions("testagent:save")
    public R save(@RequestBody TestagentEntity testagent) {
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
    public R delete(@RequestBody Integer[] ids) {
        testagentService.deleteBatch(ids);

        return R.ok();
    }

}
