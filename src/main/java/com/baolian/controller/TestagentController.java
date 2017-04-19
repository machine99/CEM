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
        // System.out.println("page:" + page);
        // System.out.println("limit:" + limit);
        // System.out.println("probedata:" + probedata_jsonobject);
        // System.out.println("probedata:" + probedata_jsonobject.get("county"));
        //查询列表数据
        List<TestagentEntity> testagentList = testagentService.queryList(map);
        int total = testagentService.queryTotal(map);

        // int total = 0;
        // JSONArray jsonArray = null;
        //
        // String data1 = "{\"total\":26,\"rows\":[{\"oltip\":null,\"brasip\":null,\"accesslayer\":null,\"model\":\"PC桌面版\",\"location\":null,\"city_man\":\"西安市\",\"brasport\":null,\"networktype\":null,\"contact\":null,\"accesstype\":null,\"teststatus\":null,\"dayreport\":\"100\",\"version\":\"PC桌面版\",\"city\":null,\"bandwidth\":null,\"id\":\"43\",\"online_time\":null,\"testgroup_name\":null,\"name\":\"testbj\",\"sysuuid\":null,\"brasname\":\"1\",\"testgroup\":null,\"dnsip\":null,\"phonenum\":null,\"oltname\":null,\"run_interval\":\"60\",\"useruid\":null,\"isp_man\":null,\"vpnip\":null,\"isp\":null,\"onlinestatus\":null,\"networkdevice\":null,\"ip\":null,\"address\":\"北京\",\"county\":\"莲湖区\",\"oltport\":null,\"device\":null,\"uplink\":null},{\"oltip\":null,\"brasip\":null,\"accesslayer\":null,\"model\":\"硬件版\",\"location\":\"未知\",\"city_man\":\"\",\"brasport\":null,\"networktype\":null,\"contact\":null,\"accesstype\":null,\"teststatus\":\"任务已启动\",\"dayreport\":\"100\",\"version\":\"blink\",\"city\":null,\"bandwidth\":\"0.0\",\"id\":\"42\",\"online_time\":\"2017-03-24 16:07:45\",\"testgroup_name\":\"默认任务\",\"name\":\"78:A3:51:22:67:4C\",\"sysuuid\":\"78:A3:51:22:67:4C\",\"brasname\":\"\",\"testgroup\":\"1\",\"dnsip\":null,\"phonenum\":null,\"oltname\":\"\",\"run_interval\":\"60\",\"useruid\":\"6XRB3Q\",\"isp_man\":\"\",\"vpnip\":null,\"isp\":null,\"onlinestatus\":\"在线\",\"networkdevice\":null,\"ip\":\"120.197.83.190\",\"address\":null,\"county\":\"\",\"oltport\":null,\"device\":null,\"uplink\":null},{\"oltip\":null,\"brasip\":null,\"accesslayer\":null,\"model\":\"硬件版\",\"location\":\"未知\",\"city_man\":\"\",\"brasport\":null,\"networktype\":null,\"contact\":null,\"accesstype\":null,\"teststatus\":\"任务已启动\",\"dayreport\":\"100\",\"version\":\"blink\",\"city\":null,\"bandwidth\":\"0.0\",\"id\":\"41\",\"online_time\":\"2017-03-03 10:21:44\",\"testgroup_name\":\"默认任务\",\"name\":\"78:A3:51:22:59:A8\",\"sysuuid\":\"78:A3:51:22:59:A8\",\"brasname\":\"\",\"testgroup\":\"1\",\"dnsip\":null,\"phonenum\":null,\"oltname\":\"\",\"run_interval\":\"60\",\"useruid\":\"59JNB9\",\"isp_man\":\"\",\"vpnip\":null,\"isp\":null,\"onlinestatus\":\"在线\",\"networkdevice\":null,\"ip\":\"113.111.64.149\",\"address\":null,\"county\":\"\",\"oltport\":null,\"device\":null,\"uplink\":null},{\"oltip\":null,\"brasip\":null,\"accesslayer\":null,\"model\":\"PC桌面版\",\"location\":\"未知\",\"city_man\":\"\",\"brasport\":null,\"networktype\":null,\"contact\":null,\"accesstype\":null,\"teststatus\":\"任务已启动\",\"dayreport\":\"100\",\"version\":\"PC桌面版\",\"city\":\"内蒙古自治区包头市\",\"bandwidth\":\"0.0\",\"id\":\"37\",\"online_time\":\"2017-03-02 14:05:49\",\"testgroup_name\":\"默认任务\",\"name\":\"APS51S\",\"sysuuid\":\"28-D2-44-D6-73-A7\",\"brasname\":\"\",\"testgroup\":\"1\",\"dnsip\":null,\"phonenum\":null,\"oltname\":\"\",\"run_interval\":\"60\",\"useruid\":\"APS51S\",\"isp_man\":\"\",\"vpnip\":null,\"isp\":\"电信\",\"onlinestatus\":\"在线\",\"networkdevice\":null,\"ip\":\"1.180.212.102\",\"address\":null,\"county\":\"\",\"oltport\":null,\"device\":null,\"uplink\":null},{\"oltip\":null,\"brasip\":null,\"accesslayer\":null,\"model\":\"PC桌面版\",\"location\":\"未知\",\"city_man\":\"\",\"brasport\":null,\"networktype\":null,\"contact\":null,\"accesstype\":null,\"teststatus\":\"任务已启动\",\"dayreport\":\"100\",\"version\":\"PC桌面版\",\"city\":\"陕西省西安市\",\"bandwidth\":\"0.0\",\"id\":\"36\",\"online_time\":\"2017-01-09 11:54:50\",\"testgroup_name\":\"默认任务\",\"name\":\"HHFU2M\",\"sysuuid\":\"0C-82-68-53-2C-74\",\"brasname\":\"\",\"testgroup\":\"1\",\"dnsip\":null,\"phonenum\":null,\"oltname\":\"\",\"run_interval\":\"60\",\"useruid\":\"HHFU2M\",\"isp_man\":\"\",\"vpnip\":null,\"isp\":\"广电网\",\"onlinestatus\":\"在线\",\"networkdevice\":null,\"ip\":\"182.81.228.143\",\"address\":null,\"county\":\"\",\"oltport\":null,\"device\":null,\"uplink\":null},{\"oltip\":null,\"brasip\":null,\"accesslayer\":null,\"model\":\"硬件版\",\"location\":\"未知\",\"city_man\":\"西安市\",\"brasport\":null,\"networktype\":null,\"contact\":null,\"accesstype\":null,\"teststatus\":\"任务已启动\",\"dayreport\":\"100\",\"version\":\"blink\",\"city\":null,\"bandwidth\":\"0.0\",\"id\":\"35\",\"online_time\":\"2016-12-22 16:58:57\",\"testgroup_name\":\"默认任务\",\"name\":\"78:A3:51:21:FB:44\",\"sysuuid\":\"78:A3:51:21:FB:44\",\"brasname\":\"XA-BL-BAS-1.MAN.ME60\",\"testgroup\":\"1\",\"dnsip\":null,\"phonenum\":null,\"oltname\":null,\"run_interval\":\"60\",\"useruid\":\"TGPQD8\",\"isp_man\":null,\"vpnip\":null,\"isp\":null,\"onlinestatus\":\"在线\",\"networkdevice\":null,\"ip\":\"182.81.205.175\",\"address\":\"正街乐居场棚A4标段6号楼12层ONU-1\",\"county\":\"碑林区\",\"oltport\":null,\"device\":null,\"uplink\":null},{\"oltip\":null,\"brasip\":null,\"accesslayer\":null,\"model\":\"硬件版\",\"location\":\"未知\",\"city_man\":\"西安市\",\"brasport\":\" \",\"networktype\":null,\"contact\":null,\"accesstype\":null,\"teststatus\":\"任务已启动\",\"dayreport\":\"100\",\"version\":\"blink\",\"city\":null,\"bandwidth\":\"0.0\",\"id\":\"34\",\"online_time\":\"2016-12-22 15:51:45\",\"testgroup_name\":\"默认任务\",\"name\":\"78:A3:51:1E:E6:4C\",\"sysuuid\":\"78:A3:51:1E:E6:4C\",\"brasname\":\"XA-BL-BAS-2.MAN.ME60\",\"testgroup\":\"1\",\"dnsip\":null,\"phonenum\":null,\"oltname\":null,\"run_interval\":\"60\",\"useruid\":\"3JBTWR\",\"isp_man\":null,\"vpnip\":null,\"isp\":null,\"onlinestatus\":\"在线\",\"networkdevice\":null,\"ip\":\"139.148.51.241\",\"address\":\"乐居场棚A4标段3号楼18层 ONU-2\",\"county\":\"碑林区\",\"oltport\":null,\"device\":null,\"uplink\":null},{\"oltip\":null,\"brasip\":null,\"accesslayer\":null,\"model\":\"硬件版\",\"location\":\"未知\",\"city_man\":\"西安市\",\"brasport\":null,\"networktype\":null,\"contact\":null,\"accesstype\":null,\"teststatus\":\"任务已启动\",\"dayreport\":\"100\",\"version\":\"blink\",\"city\":null,\"bandwidth\":\"0.0\",\"id\":\"33\",\"online_time\":\"2016-12-22 15:28:21\",\"testgroup_name\":\"默认任务\",\"name\":\"78:A3:51:22:05:78\",\"sysuuid\":\"78:A3:51:22:05:78\",\"brasname\":\"XA-BL-BAS-3.MAN.ME60\",\"testgroup\":\"1\",\"dnsip\":null,\"phonenum\":null,\"oltname\":null,\"run_interval\":\"60\",\"useruid\":\"FGYXCM\",\"isp_man\":null,\"vpnip\":null,\"isp\":null,\"onlinestatus\":\"在线\",\"networkdevice\":null,\"ip\":\"10.129.214.76\",\"address\":\"蔡家巷小区ONU-3\",\"county\":\"碑林区\",\"oltport\":null,\"device\":null,\"uplink\":null},{\"oltip\":null,\"brasip\":null,\"accesslayer\":null,\"model\":\"硬件版\",\"location\":\"未知\",\"city_man\":\"西安市\",\"brasport\":null,\"networktype\":null,\"contact\":null,\"accesstype\":null,\"teststatus\":\"任务已启动\",\"dayreport\":\"100\",\"version\":\"blink\",\"city\":null,\"bandwidth\":\"0.0\",\"id\":\"27\",\"online_time\":\"2016-12-22 14:19:40\",\"testgroup_name\":\"默认任务\",\"name\":\"78:A3:51:1E:F2:D4\",\"sysuuid\":\"78:A3:51:1E:F2:D4\",\"brasname\":\"XA-BL-BAS-4.MAN.ME60\",\"testgroup\":\"1\",\"dnsip\":null,\"phonenum\":null,\"oltname\":null,\"run_interval\":\"60\",\"useruid\":\"QYT88B\",\"isp_man\":null,\"vpnip\":null,\"isp\":null,\"onlinestatus\":\"在线\",\"networkdevice\":null,\"ip\":\"10.128.166.26\",\"address\":\"西安市碑林区太乙路街道办乐居场正街乐居场棚改安置A4标段6号楼6层\",\"county\":\"碑林区\",\"oltport\":null,\"device\":null,\"uplink\":null},{\"oltip\":null,\"brasip\":null,\"accesslayer\":null,\"model\":\"硬件版\",\"location\":\"未知\",\"city_man\":\"\",\"brasport\":null,\"networktype\":null,\"contact\":null,\"accesstype\":null,\"teststatus\":\"任务已启动\",\"dayreport\":\"100\",\"version\":\"blink\",\"city\":null,\"bandwidth\":\"0.0\",\"id\":\"26\",\"online_time\":\"2016-12-22 14:13:55\",\"testgroup_name\":\"默认任务\",\"name\":\"BC:AE:C5:C4:C4:2D\",\"sysuuid\":\"BC:AE:C5:C4:C4:2D\",\"brasname\":\"\",\"testgroup\":\"1\",\"dnsip\":null,\"phonenum\":null,\"oltname\":\"\",\"run_interval\":\"60\",\"useruid\":\"NH7GHH\",\"isp_man\":\"\",\"vpnip\":null,\"isp\":null,\"onlinestatus\":\"在线\",\"networkdevice\":null,\"ip\":\"123.14.31.236\",\"address\":null,\"county\":\"\",\"oltport\":null,\"device\":null,\"uplink\":null}]}";
        // String data2 = "{\"total\":26,\"rows\":[{\"oltip\":null,\"brasip\":null,\"accesslayer\":null,\"model\":\"PC桌面版\",\"location\":\"未知\",\"city_man\":\"\",\"brasport\":null,\"networktype\":null,\"contact\":null,\"accesstype\":null,\"teststatus\":\"任务已启动\",\"dayreport\":\"100\",\"version\":\"PC桌面版\",\"city\":\"内蒙古自治区包头市\",\"bandwidth\":\"0.0\",\"id\":\"24\",\"online_time\":\"2017-01-09 09:30:55\",\"testgroup_name\":\"默认任务\",\"name\":\"XTXD5P\",\"sysuuid\":\"E6-02-9B-42-0E-F5\",\"brasname\":\"\",\"testgroup\":\"1\",\"dnsip\":null,\"phonenum\":null,\"oltname\":\"\",\"run_interval\":\"60\",\"useruid\":\"XTXD5P\",\"isp_man\":\"\",\"vpnip\":null,\"isp\":\"电信\",\"onlinestatus\":\"在线\",\"networkdevice\":null,\"ip\":\"1.180.212.141\",\"address\":null,\"county\":\"\",\"oltport\":null,\"device\":null,\"uplink\":null},{\"oltip\":null,\"brasip\":null,\"accesslayer\":null,\"model\":\"PC桌面版\",\"location\":\"未知\",\"city_man\":\"\",\"brasport\":null,\"networktype\":null,\"contact\":null,\"accesstype\":null,\"teststatus\":\"任务已启动\",\"dayreport\":\"100\",\"version\":\"PC桌面版\",\"city\":\"内蒙古自治区包头市\",\"bandwidth\":\"0.0\",\"id\":\"23\",\"online_time\":\"2017-04-07 15:32:57\",\"testgroup_name\":\"默认任务\",\"name\":\"2HPSW1\",\"sysuuid\":\"50-7B-9D-B0-B7-30\",\"brasname\":\"\",\"testgroup\":\"1\",\"dnsip\":null,\"phonenum\":null,\"oltname\":\"\",\"run_interval\":\"60\",\"useruid\":\"2HPSW1\",\"isp_man\":\"\",\"vpnip\":null,\"isp\":\"电信\",\"onlinestatus\":\"在线\",\"networkdevice\":null,\"ip\":\"1.180.212.190\",\"address\":null,\"county\":\"\",\"oltport\":null,\"device\":null,\"uplink\":null},{\"oltip\":null,\"brasip\":null,\"accesslayer\":null,\"model\":\"PC桌面版\",\"location\":\"未知\",\"city_man\":\"\",\"brasport\":null,\"networktype\":null,\"contact\":null,\"accesstype\":null,\"teststatus\":\"任务已启动\",\"dayreport\":\"100\",\"version\":\"PC桌面版\",\"city\":\"广东省广州市\",\"bandwidth\":\"0.0\",\"id\":\"22\",\"online_time\":\"2016-12-14 10:28:15\",\"testgroup_name\":\"默认任务\",\"name\":\"S4Z8N1\",\"sysuuid\":\"00-15-00-BA-AA-59\",\"brasname\":\"\",\"testgroup\":\"1\",\"dnsip\":null,\"phonenum\":null,\"oltname\":\"\",\"run_interval\":\"60\",\"useruid\":\"S4Z8N1\",\"isp_man\":\"\",\"vpnip\":null,\"isp\":\"电信\",\"onlinestatus\":\"在线\",\"networkdevice\":null,\"ip\":\"119.131.76.210\",\"address\":null,\"county\":\"\",\"oltport\":null,\"device\":null,\"uplink\":null},{\"oltip\":null,\"brasip\":null,\"accesslayer\":null,\"model\":\"PC桌面版\",\"location\":\"未知\",\"city_man\":\"\",\"brasport\":null,\"networktype\":null,\"contact\":null,\"accesstype\":null,\"teststatus\":\"任务已启动\",\"dayreport\":\"100\",\"version\":\"PC桌面版\",\"city\":\"广东省广州市\",\"bandwidth\":\"0.0\",\"id\":\"21\",\"online_time\":\"2016-12-13 09:01:23\",\"testgroup_name\":\"默认任务\",\"name\":\"EAXTF4\",\"sysuuid\":\"A0-88-69-6B-0C-0F\",\"brasname\":\"\",\"testgroup\":\"1\",\"dnsip\":null,\"phonenum\":null,\"oltname\":\"\",\"run_interval\":\"60\",\"useruid\":\"EAXTF4\",\"isp_man\":\"\",\"vpnip\":null,\"isp\":\"电信\",\"onlinestatus\":\"在线\",\"networkdevice\":null,\"ip\":\"113.111.65.138\",\"address\":null,\"county\":\"\",\"oltport\":null,\"device\":null,\"uplink\":null},{\"oltip\":null,\"brasip\":null,\"accesslayer\":null,\"model\":\"PC桌面版\",\"location\":\"未知\",\"city_man\":\"\",\"brasport\":null,\"networktype\":null,\"contact\":null,\"accesstype\":null,\"teststatus\":\"任务已启动\",\"dayreport\":\"100\",\"version\":\"PC桌面版\",\"city\":null,\"bandwidth\":\"0.0\",\"id\":\"20\",\"online_time\":\"2016-12-12 16:16:23\",\"testgroup_name\":\"默认任务\",\"name\":\"6YNCPM\",\"sysuuid\":\"08-00-27-DE-E2-BD\",\"brasname\":\"\",\"testgroup\":\"1\",\"dnsip\":null,\"phonenum\":null,\"oltname\":\"\",\"run_interval\":\"60\",\"useruid\":\"6YNCPM\",\"isp_man\":\"\",\"vpnip\":null,\"isp\":null,\"onlinestatus\":\"在线\",\"networkdevice\":null,\"ip\":\"183.232.175.3\",\"address\":null,\"county\":\"\",\"oltport\":null,\"device\":null,\"uplink\":null},{\"oltip\":null,\"brasip\":null,\"accesslayer\":null,\"model\":\"PC桌面版\",\"location\":\"未知\",\"city_man\":\"\",\"brasport\":null,\"networktype\":null,\"contact\":null,\"accesstype\":null,\"teststatus\":\"任务已启动\",\"dayreport\":\"100\",\"version\":\"PC桌面版\",\"city\":\"广东省广州市\",\"bandwidth\":\"0.0\",\"id\":\"19\",\"online_time\":\"2016-12-23 09:07:01\",\"testgroup_name\":\"默认任务\",\"name\":\"NNP2QP\",\"sysuuid\":\"70-77-81-16-B2-9F\",\"brasname\":\"\",\"testgroup\":\"1\",\"dnsip\":null,\"phonenum\":null,\"oltname\":\"\",\"run_interval\":\"60\",\"useruid\":\"NNP2QP\",\"isp_man\":\"\",\"vpnip\":null,\"isp\":\"电信\",\"onlinestatus\":\"在线\",\"networkdevice\":null,\"ip\":\"113.111.65.84\",\"address\":null,\"county\":\"\",\"oltport\":null,\"device\":null,\"uplink\":null},{\"oltip\":null,\"brasip\":null,\"accesslayer\":null,\"model\":\"PC桌面版\",\"location\":\"未知\",\"city_man\":\"\",\"brasport\":null,\"networktype\":null,\"contact\":null,\"accesstype\":null,\"teststatus\":\"任务已启动\",\"dayreport\":\"100\",\"version\":\"PC桌面版\",\"city\":\"广东省广州市\",\"bandwidth\":\"0.0\",\"id\":\"18\",\"online_time\":\"2016-12-29 11:03:34\",\"testgroup_name\":\"默认任务\",\"name\":\"UX6SUX\",\"sysuuid\":\"4C-BB-58-35-78-DD\",\"brasname\":\"\",\"testgroup\":\"1\",\"dnsip\":null,\"phonenum\":null,\"oltname\":\"\",\"run_interval\":\"60\",\"useruid\":\"UX6SUX\",\"isp_man\":\"\",\"vpnip\":null,\"isp\":\"电信\",\"onlinestatus\":\"在线\",\"networkdevice\":null,\"ip\":\"121.33.175.124\",\"address\":null,\"county\":\"\",\"oltport\":null,\"device\":null,\"uplink\":null},{\"oltip\":null,\"brasip\":null,\"accesslayer\":null,\"model\":\"PC桌面版\",\"location\":\"未知\",\"city_man\":\"\",\"brasport\":null,\"networktype\":null,\"contact\":null,\"accesstype\":null,\"teststatus\":\"任务已启动\",\"dayreport\":\"100\",\"version\":\"PC桌面版\",\"city\":\"广东省广州市\",\"bandwidth\":\"0.0\",\"id\":\"17\",\"online_time\":\"2017-01-09 15:21:54\",\"testgroup_name\":\"默认任务\",\"name\":\"8ZX58Y\",\"sysuuid\":\"00-0C-29-74-99-5E\",\"brasname\":\"\",\"testgroup\":\"1\",\"dnsip\":null,\"phonenum\":null,\"oltname\":\"\",\"run_interval\":\"60\",\"useruid\":\"8ZX58Y\",\"isp_man\":\"\",\"vpnip\":null,\"isp\":\"电信\",\"onlinestatus\":\"在线\",\"networkdevice\":null,\"ip\":\"113.111.65.166\",\"address\":null,\"county\":\"\",\"oltport\":null,\"device\":null,\"uplink\":null},{\"oltip\":null,\"brasip\":null,\"accesslayer\":null,\"model\":\"硬件版\",\"location\":\"未知\",\"city_man\":\"\",\"brasport\":null,\"networktype\":null,\"contact\":null,\"accesstype\":null,\"teststatus\":\"任务已启动\",\"dayreport\":\"100\",\"version\":\"blink\",\"city\":null,\"bandwidth\":\"0.0\",\"id\":\"16\",\"online_time\":\"2016-12-07 07:50:28\",\"testgroup_name\":\"默认任务\",\"name\":\"78:A3:51:18:82:74\",\"sysuuid\":\"78:A3:51:18:82:74\",\"brasname\":\"\",\"testgroup\":\"1\",\"dnsip\":null,\"phonenum\":null,\"oltname\":\"\",\"run_interval\":\"60\",\"useruid\":\"Q3F1UD\",\"isp_man\":\"\",\"vpnip\":null,\"isp\":null,\"onlinestatus\":\"在线\",\"networkdevice\":null,\"ip\":\"120.197.83.180\",\"address\":null,\"county\":\"\",\"oltport\":null,\"device\":null,\"uplink\":null},{\"oltip\":null,\"brasip\":null,\"accesslayer\":null,\"model\":\"硬件版\",\"location\":\"未知\",\"city_man\":\"西安市\",\"brasport\":null,\"networktype\":null,\"contact\":null,\"accesstype\":null,\"teststatus\":\"任务已启动\",\"dayreport\":\"100\",\"version\":\"blink\",\"city\":null,\"bandwidth\":\"0.0\",\"id\":\"15\",\"online_time\":\"2016-12-04 22:23:25\",\"testgroup_name\":\"默认任务\",\"name\":\"F4:8E:38:C5:A0:2C\",\"sysuuid\":\"F4:8E:38:C5:A0:2C\",\"brasname\":null,\"testgroup\":\"1\",\"dnsip\":null,\"phonenum\":null,\"oltname\":null,\"run_interval\":\"60\",\"useruid\":\"5DHG5N\",\"isp_man\":null,\"vpnip\":null,\"isp\":null,\"onlinestatus\":\"在线\",\"networkdevice\":null,\"ip\":\"124.47.32.116\",\"address\":\"北大街光辉巷-骨干探针\",\"county\":\"新城区\",\"oltport\":null,\"device\":null,\"uplink\":null}]}";
        // String data3 = "{\"total\":26,\"rows\":[{\"oltip\":null,\"brasip\":null,\"accesslayer\":null,\"model\":\"硬件版\",\"location\":\"未知\",\"city_man\":\"西安市\",\"brasport\":null,\"networktype\":null,\"contact\":null,\"accesstype\":null,\"teststatus\":\"任务已启动\",\"dayreport\":\"100\",\"version\":\"blink\",\"city\":null,\"bandwidth\":\"0.0\",\"id\":\"13\",\"online_time\":\"2016-12-04 11:23:52\",\"testgroup_name\":\"默认任务\",\"name\":\"78:A3:51:1F:01:64\",\"sysuuid\":\"78:A3:51:1F:01:64\",\"brasname\":\"XA-BL-BAS-1.MAN.ME60\",\"testgroup\":\"1\",\"dnsip\":null,\"phonenum\":null,\"oltname\":null,\"run_interval\":\"60\",\"useruid\":\"QAZZRC\",\"isp_man\":null,\"vpnip\":null,\"isp\":null,\"onlinestatus\":\"在线\",\"networkdevice\":null,\"ip\":\"10.128.150.93\",\"address\":\"太乙路乐居场正街乐居场棚A4标段6号楼\",\"county\":\"碑林区\",\"oltport\":null,\"device\":null,\"uplink\":null},{\"oltip\":null,\"brasip\":null,\"accesslayer\":null,\"model\":\"硬件版\",\"location\":\"未知\",\"city_man\":\"西安市\",\"brasport\":null,\"networktype\":null,\"contact\":null,\"accesstype\":null,\"teststatus\":\"任务已启动\",\"dayreport\":\"100\",\"version\":\"blink\",\"city\":null,\"bandwidth\":\"0.0\",\"id\":\"12\",\"online_time\":\"2016-12-03 20:28:35\",\"testgroup_name\":\"默认任务\",\"name\":\"78:A3:51:1C:02:18\",\"sysuuid\":\"78:A3:51:1C:02:18\",\"brasname\":\"XA-BL-BAS-3.MAN.ME60\",\"testgroup\":\"1\",\"dnsip\":null,\"phonenum\":null,\"oltname\":null,\"run_interval\":\"60\",\"useruid\":\"XGVVAB\",\"isp_man\":null,\"vpnip\":null,\"isp\":null,\"onlinestatus\":\"在线\",\"networkdevice\":null,\"ip\":\"182.81.226.35\",\"address\":\"东关南街街道办蔡家巷小区\",\"county\":\"碑林区\",\"oltport\":null,\"device\":null,\"uplink\":null},{\"oltip\":null,\"brasip\":null,\"accesslayer\":null,\"model\":\"硬件版\",\"location\":\"未知\",\"city_man\":\"西安市\",\"brasport\":null,\"networktype\":null,\"contact\":null,\"accesstype\":null,\"teststatus\":\"任务已启动\",\"dayreport\":\"100\",\"version\":\"blink\",\"city\":null,\"bandwidth\":\"0.0\",\"id\":\"11\",\"online_time\":\"2016-12-02 18:32:50\",\"testgroup_name\":\"默认任务\",\"name\":\"78:A3:51:21:FD:7C\",\"sysuuid\":\"78:A3:51:21:FD:7C\",\"brasname\":\"XA-BL-BAS-2.MAN.ME60\",\"testgroup\":\"1\",\"dnsip\":null,\"phonenum\":null,\"oltname\":null,\"run_interval\":\"60\",\"useruid\":\"DKPFRS\",\"isp_man\":null,\"vpnip\":null,\"isp\":null,\"onlinestatus\":\"在线\",\"networkdevice\":null,\"ip\":\"111.19.57.235\",\"address\":\"太乙路乐居场正街乐居场棚A4标段3号楼\",\"county\":\"碑林区\",\"oltport\":null,\"device\":null,\"uplink\":null},{\"oltip\":null,\"brasip\":null,\"accesslayer\":null,\"model\":\"硬件版\",\"location\":\"未知\",\"city_man\":\"西安市\",\"brasport\":null,\"networktype\":null,\"contact\":null,\"accesstype\":null,\"teststatus\":\"任务已启动\",\"dayreport\":\"100\",\"version\":\"blink\",\"city\":null,\"bandwidth\":\"0.0\",\"id\":\"10\",\"online_time\":\"2016-12-02 12:20:31\",\"testgroup_name\":\"默认任务\",\"name\":\"78:A3:51:1E:E7:B0\",\"sysuuid\":\"78:A3:51:1E:E7:B0\",\"brasname\":\"XA-BL-BAS-1.MAN.ME60\",\"testgroup\":\"1\",\"dnsip\":null,\"phonenum\":null,\"oltname\":null,\"run_interval\":\"60\",\"useruid\":\"6DRS3J\",\"isp_man\":null,\"vpnip\":null,\"isp\":null,\"onlinestatus\":\"在线\",\"networkdevice\":null,\"ip\":\"182.80.220.172\",\"address\":\"太乙路乐居场正街乐居场棚A4标段6号楼 \",\"county\":\"碑林区\",\"oltport\":null,\"device\":null,\"uplink\":null},{\"oltip\":null,\"brasip\":null,\"accesslayer\":null,\"model\":\"硬件版\",\"location\":\"未知\",\"city_man\":\"\",\"brasport\":null,\"networktype\":null,\"contact\":null,\"accesstype\":null,\"teststatus\":\"任务已启动\",\"dayreport\":\"100\",\"version\":\"blink\",\"city\":null,\"bandwidth\":\"0.0\",\"id\":\"9\",\"online_time\":\"2016-12-02 11:43:53\",\"testgroup_name\":\"默认任务\",\"name\":\"78:A3:51:21:FB:68\",\"sysuuid\":\"78:A3:51:21:FB:68\",\"brasname\":\"\",\"testgroup\":\"1\",\"dnsip\":null,\"phonenum\":null,\"oltname\":\"\",\"run_interval\":\"60\",\"useruid\":\"8GDJ2C\",\"isp_man\":\"\",\"vpnip\":null,\"isp\":null,\"onlinestatus\":\"在线\",\"networkdevice\":null,\"ip\":\"113.111.65.243\",\"address\":null,\"county\":\"\",\"oltport\":null,\"device\":null,\"uplink\":null},{\"oltip\":null,\"brasip\":null,\"accesslayer\":null,\"model\":\"硬件版\",\"location\":\"未知\",\"city_man\":\"西安市\",\"brasport\":null,\"networktype\":null,\"contact\":null,\"accesstype\":null,\"teststatus\":\"任务已启动\",\"dayreport\":\"100\",\"version\":\"blink\",\"city\":null,\"bandwidth\":\"0.0\",\"id\":\"8\",\"online_time\":\"2016-12-02 19:19:42\",\"testgroup_name\":\"默认任务\",\"name\":\"78:A3:51:22:00:98\",\"sysuuid\":\"78:A3:51:22:00:98\",\"brasname\":\"XA-BL-BAS-0.MAN.ME62\",\"testgroup\":\"1\",\"dnsip\":null,\"phonenum\":null,\"oltname\":null,\"run_interval\":\"60\",\"useruid\":\"VE4B5E\",\"isp_man\":null,\"vpnip\":null,\"isp\":null,\"onlinestatus\":\"在线\",\"networkdevice\":null,\"ip\":\"139.148.28.226\",\"address\":\"兴庆路兴庆机房\",\"county\":\"碑林区\",\"oltport\":null,\"device\":null,\"uplink\":null}]}";
        // if ((int) map.get("offset") == 0) {
        //     JSONObject json_data1 = JSONObject.parseObject(data1);
        //     total = Integer.parseInt(json_data1.getString("total"));
        //     jsonArray = json_data1.getJSONArray("rows");
        //     System.out.println(jsonArray);
        // } else if ((int) map.get("offset") == 10) {
        //     JSONObject json_data2 = JSONObject.parseObject(data2);
        //     total = Integer.parseInt(json_data2.getString("total"));
        //     jsonArray = json_data2.getJSONArray("rows");
        //     System.out.println(jsonArray);
        // } else if ((int) map.get("offset") == 20) {
        //     JSONObject json_data3 = JSONObject.parseObject(data3);
        //     total = Integer.parseInt(json_data3.getString("total"));
        //     jsonArray = json_data3.getJSONArray("rows");
        //     System.out.println(jsonArray);
        // }
        // PageUtils pageUtil = new PageUtils(jsonArray, total, limit, page);
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
        /*testagentService.save(testagent);*/
        System.out.println(testagent);
        System.out.println(testagent.getCounty());
        System.out.println(testagent.getCityMan());
        return R.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("testagent:update")
    public R update(@RequestBody TestagentEntity testagent) {
        /*testagentService.update(testagent);*/
        System.out.println(testagent);
        System.out.println(testagent.getCityMan());
        System.out.println(testagent.getBandwidth());
        return R.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping("/delete")
    @RequiresPermissions("testagent:delete")
    public R delete(@RequestBody Integer[] ids) {

        /*testagentService.deleteBatch(ids);*/
        for (int i = 0; i < ids.length; i++) {
            System.out.println(ids[i]);
        }
        return R.ok();
    }
}
