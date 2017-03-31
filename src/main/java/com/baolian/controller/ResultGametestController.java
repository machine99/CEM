package com.baolian.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baolian.utils.PageUtils;
import com.baolian.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.baolian.entity.ResultGametestEntity;
import com.baolian.service.ResultGametestService;


/**
 * 游戏测试结果表
 *
 * @date 2017-03-31 14:49:21
 */
@Controller
@RequestMapping("resultgametest")
public class ResultGametestController {
    @Autowired
    private ResultGametestService resultGametestService;

    @RequestMapping("/resultgametest.html")
    public String list() {
        return "resultgametest/resultgametest.html";
    }

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("resultgametest:list")
    public R list(Integer page, Integer limit) {
        Map<String, Object> map = new HashMap<>();
        map.put("offset", (page - 1) * limit);
        map.put("limit", limit);

        //查询列表数据
        List<ResultGametestEntity> resultGametestList = resultGametestService.queryList(map);
        int total = resultGametestService.queryTotal(map);

        PageUtils pageUtil = new PageUtils(resultGametestList, total, limit, page);

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("resultgametest:info")
    public R info(@PathVariable("id") Integer id) {
        ResultGametestEntity resultGametest = resultGametestService.queryObject(id);

        return R.ok().put("resultGametest", resultGametest);
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    @RequiresPermissions("resultgametest:save")
    public R save(@RequestBody ResultGametestEntity resultGametest) {
        resultGametestService.save(resultGametest);

        return R.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("resultgametest:update")
    public R update(@RequestBody ResultGametestEntity resultGametest) {
        resultGametestService.update(resultGametest);

        return R.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping("/delete")
    @RequiresPermissions("resultgametest:delete")
    public R delete(@RequestBody Integer[] ids) {
        resultGametestService.deleteBatch(ids);

        return R.ok();
    }

}
