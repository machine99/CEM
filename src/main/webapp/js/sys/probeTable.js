/**
 * Created by yuanbaby on 2017/4/14.
 */

var probedata_handle = new Vue({
    el: '#handle',
    data: {},
    methods: {
        testagentadd: function () {   /*监听录入触发事件*/
            var forms = $('#probeform_data .form-control');

            $('#probeform_data input[type=text]').prop("readonly", false);
            /*去除只读状态*/
            $('#probeform_data select').prop("disabled", false);

            for (var i = 0; i < 10; i++) {
                forms[i].value = ""
            }
            probeform_data.modaltitle = "测试机管理录入";
            /*修改模态框标题*/
            $('#myModal').modal('show');

        },
        testagentupdate: function () {     /*监听编辑触发事件*/
            var trs = $('#probe_table tbody').find('tr:has(:checked)');
            /*find被选中的行*/
            var forms = $('#probeform_data .form-control');
            console.log(trs.length + "表单对象:" + forms.length);

            $('#probeform_data input[type=text]').prop("readonly", false);
            /*去除只读状态*/
            $('#probeform_data select').prop("disabled", false);

            if (trs.length == 0) {
                toastr.warning('请选择编辑项目！');
            } else if (trs.length == 1) {
                var tds = trs.find("td");
                for (var i = 0; i < 5; i++) {                /*tds.eq(0).text()取得td的值,注意tds[0].text()取不到*/
                    console.log(tds.eq(i + 2).text());
                    forms[i].value = tds.eq(i + 2).text()
                }
                forms[5].value = tds.eq(9).text();
                /*修改测试任务组*/
                console.log(tds.eq(9).text());
                for (var j = 0; j < 4; j++) {                /*tds.eq(0).text()取得td的值,注意tds[0].text()取不到*/
                    console.log(tds.eq(j + 14).text());
                    forms[j + 6].value = tds.eq(j + 14).text()
                }
                /*tds.each(function(){
                 var td = $(this);
                 console.log(td.text());//这个就是td的文本
                 });*/
                probeform_data.modaltitle = "测试机管理编辑";
                /*修改模态框标题*/
                $('#myModal').modal('show');
            } else {
                toastr.warning('请选择一条记录再编辑！');
            }
        },
        testagentdelBatch: function () {   /*批量删除监听事件*/
            var trs = $('#probe_table tbody').find('tr:has(:checked)');
            /*find被选中的行*/

        },
        testagentview: function () {     /*查看监听事件*/
            var trs = $('#probe_table tbody').find('tr:has(:checked)');
            /*find被选中的行*/
            var forms = $('#probeform_data .form-control');
            if (trs.length == 0) {
                toastr.warning('请选择查看项目！');
            } else if (trs.length == 1) {
                var tds = trs.find("td");
                for (var i = 0; i < 5; i++) {                /*tds.eq(0).text()取得td的值,注意tds[0].text()取不到*/
                    console.log(tds.eq(i + 2).text());
                    forms[i].value = tds.eq(i + 2).text()
                }
                forms[5].value = tds.eq(9).text();
                /*修改测试任务组*/
                console.log(tds.eq(9).text());
                for (var j = 0; j < 4; j++) {                /*tds.eq(0).text()取得td的值,注意tds[0].text()取不到*/
                    console.log(tds.eq(j + 14).text());
                    forms[j + 6].value = tds.eq(j + 14).text()
                }
                $('#probeform_data input[type=text]').prop("readonly", true);//将input元素设置为readonly
                $('#probeform_data select').prop("disabled", true);//将select元素设置为不可变

                probeform_data.modaltitle = "查看";
                /*修改模态框标题*/
                $('#myModal').modal('show');
            } else {
                toastr.warning('请选择一条记录再查看！');
            }
        },
        testagentListsearch:function () {   /*查询监听事件*/
            console.log($('#searchcolums').serialize())
        }

    }
});
var probeform_data = new Vue({
    el: '#myModal',
    data: {
        modaltitle: "测试机管理录入", /*定义模态框标题*/
        countys: [
            {message: '新城区'},
            {message: '碑林区'},
            {message: '莲湖区'},
            {message: '雁塔区'},
            {message: '未央区'},
            {message: '灞桥区'},
            {message: '长安区'},
            {message: '阎良区'},
            {message: '临潼区'},
            {message: '蓝田县'},
            {message: '周至县'},
            {message: '户县'},
            {message: '高陵县'}
        ],
        city_mans: [
            {message: '西安市'}
        ],
        testgroup_names: [
            {message: '标准测试任务'},
            {message: '视频类测试'},
            {message: '网站应用'},
            {message: '他网测试'},
            {message: '默认任务'}
        ]
    },
    // 在 `methods` 对象中定义方法
    methods: {
        submit: function () {
            var data = $('#probeform_data').serialize();
            /*获取表单元素的值*/
            console.log(data)
        }
    }
});

var search_data = new Vue({
    el:'#searchcolums',
    data:{
        countys:probeform_data.countys,
        city_mans:probeform_data.city_mans,
        testgroup_names:probeform_data.testgroup_names
    }
});
        /*选中表格事件*/
$(document).ready(function () {
    $('#probe_table tbody').on('click', 'tr', function () {   /*表格某一行选中状态*/
        if ($(this).hasClass('selected')) {
            $(this).removeClass('selected');
            $(this).find("input:checkbox").prop("checked", false);
            /*prop可以,attr会出错*/
        }
        else {
            /*vm.dtHandle.$('tr.selected').removeClass('selected');*/
            /*只能选中一行*/
            $(this).addClass('selected');
            $(this).find("input:checkbox").prop("checked", true);
        }
    });

    $('#checkAll').on('click', function () {
        if (this.checked) {
            $("input[name='selectFlag']:checkbox").each(function () { //遍历所有的name为selectFlag的 checkbox
                $(this).prop("checked", true);
                $(this).closest('tr').addClass('selected');
                /*取得最近的tr元素*/
            })
        } else {   //反之 取消全选
            $("input[name='selectFlag']:checkbox").each(function () { //遍历所有的name为selectFlag的 checkbox
                $(this).prop("checked", false);
                $(this).closest('tr').removeClass('selected');
                /*取得最近的tr元素*/

            })
        }
    })

});


Vue.component('data-table', {
    template: '<table class="table table-bordered " id="probe_table"></table>',
    props: ['users'],
    data() {
        return {
            headers: [
                {title: ''},
                {title: '<div class="checkbox"> <label> <input type="checkbox" id="checkAll"></label> </div>'},
                {title: '<div style="width:142px">测试机名</div>'},
                {title: '<div style="width:142px">IP地址</div>'},
                {title: '<div style="width:112px">带宽</div>'},
                {title: '<div style="width:67px">地市</div>'},
                {title: '<div style="width:67px">区县</div>'},
                {title: '<div style="width:92px">软件标识</div>'},
                {title: '<div style="width:112px">硬件编码</div>'},
                {title: '<div style="width:112px">测试任务组</div>'},
                {title: '<div style="width:52px">在线状态</div>'},
                {title: '<div style="width:112px">在线时间</div>'},
                {title: '<div style="width:112px">探针类型</div>'},
                {title: '<div style="width:112px">版本号</div>'},
                {title: '<div style="width:67px">任务间隔</div>'},
                {title: '<div style="width:167px">装机地址</div>'},
                {title: '<div style="width:142px">BRAS名称</div>'},
                {title: '<div style="width:112px">BRAS_IP</div>'},
                {title: '<div style="width:112px">BRAS端口</div>'},
                {title: '<div style="width:52px">操作</div>'}
            ],
            rows: [],
            dtHandle: null
        }
    },
    watch: {
        users(val, oldVal) {
            let vm = this;
            vm.rows = [];
            var i = 1;
            // You should _probably_ check that this is changed data... but we'll skip that for this example.
            val.forEach(function (item) {              /*观察user是否变化,更新表格数据*/
                // Fish out the specific column data for each item in your data set and push it to the appropriate place.
                // Basically we're just building a multi-dimensional array here. If the data is _already_ in the right format you could
                // skip this loop...
                let row = [];
                row.push(i++);
                row.push('<div class="checkbox"> <label> <input type="checkbox" name="selectFlag"></label> </div>');
                row.push(item.sysuuid);
                row.push(item.ip);
                row.push(item.bandwidth);
                row.push(item.city_man);
                row.push(item.county);
                row.push(item.useruid);
                row.push(item.name);
                row.push(item.testgroup_name);
                row.push(item.onlinestatus);
                row.push(item.online_time);
                row.push(item.model);
                row.push(item.version);
                row.push(item.run_interval);
                row.push(item.address);
                row.push(item.brasname);
                row.push(item.brasip);
                row.push(item.brasport);
                row.push('<a class="fontcolor">删除<a/>');

                /*console.log(item);*/

                vm.rows.push(row);
            });

            // Here's the magic to keeping the DataTable in sync.
            // It must be cleared, new rows added, then redrawn!
            vm.dtHandle.clear();
            vm.dtHandle.rows.add(vm.rows);
            vm.dtHandle.draw();
        }
    },
    mounted() {
        let vm = this;
        // Instantiate the datatable and store the reference to the instance in our dtHandle element.
        vm.dtHandle = $(this.$el).DataTable({


            // Specify whatever options you want, at a minimum these:
            columns: vm.headers,
            data: vm.rows,
            searching: false,
            /*paging: false,*/
            //serverSide: true,
            info: false,
            ordering: false, /*禁用排序功能*/
            /*bInfo: false,*/

            /*bLengthChange: false,*/    /*禁用Show entries*/
            /*scrollY: 432,    /!*表格高度固定*!/*/
            oLanguage: {
                sLengthMenu: "每页 _MENU_ 行数据",
                oPaginate: {
                    sNext: '<i class="fa fa-chevron-right" ></i>',  /*图标替换上一页,下一页*/
                    sPrevious: '<i class="fa fa-chevron-left" ></i>'
                }
            },
            sDom: 'Rfrtlip'  /*显示在左下角*/

        });

    }
});

var probe_data = new Vue({
    el: '#tabledemo',
    data: {
        users: [],
        search: ''
    },
    computed: {
        filteredUsers: function () {                 /*此处可以对传入数据进行处理*/
            let self = this;
            return self.users;
            /*let search = self.search.toLowerCase();
             return self.users.filter(function (user) {
             return user.username.toLowerCase().indexOf(search) !== -1 ||
             user.email.toLowerCase().indexOf(search) !== -1 ||
             user.mobile.indexOf(search) !== -1
             })*/
        }
    },
    mounted() {
        let vm = this;
        /*********************************************/
        var probe_data = {
            "total": 26,
            "rows": [{
                "oltip": null,
                "brasip": null,
                "accesslayer": null,
                "model": "PC桌面版",
                "location": null,
                "city_man": "西安市",
                "brasport": null,
                "networktype": null,
                "contact": null,
                "accesstype": null,
                "teststatus": null,
                "dayreport": "100",
                "version": "PC桌面版",
                "city": null,
                "bandwidth": null,
                "id": "43",
                "online_time": null,
                "testgroup_name": null,
                "name": "testbj",
                "sysuuid": null,
                "brasname": "1",
                "testgroup": null,
                "dnsip": null,
                "phonenum": null,
                "oltname": null,
                "run_interval": "60",
                "useruid": null,
                "isp_man": null,
                "vpnip": null,
                "isp": null,
                "onlinestatus": null,
                "networkdevice": null,
                "ip": null,
                "address": "北京",
                "county": "莲湖区",
                "oltport": null,
                "device": null,
                "uplink": null
            }, {
                "oltip": null,
                "brasip": null,
                "accesslayer": null,
                "model": "硬件版",
                "location": "未知",
                "city_man": "",
                "brasport": null,
                "networktype": null,
                "contact": null,
                "accesstype": null,
                "teststatus": "任务已启动",
                "dayreport": "100",
                "version": "blink",
                "city": null,
                "bandwidth": "0.0",
                "id": "42",
                "online_time": "2017-03-24 16:07:45",
                "testgroup_name": "默认任务",
                "name": "78:A3:51:22:67:4C",
                "sysuuid": "78:A3:51:22:67:4C",
                "brasname": "",
                "testgroup": "1",
                "dnsip": null,
                "phonenum": null,
                "oltname": "",
                "run_interval": "60",
                "useruid": "6XRB3Q",
                "isp_man": "",
                "vpnip": null,
                "isp": null,
                "onlinestatus": "在线",
                "networkdevice": null,
                "ip": "120.197.83.190",
                "address": null,
                "county": "",
                "oltport": null,
                "device": null,
                "uplink": null
            }, {
                "oltip": null,
                "brasip": null,
                "accesslayer": null,
                "model": "硬件版",
                "location": "未知",
                "city_man": "",
                "brasport": null,
                "networktype": null,
                "contact": null,
                "accesstype": null,
                "teststatus": "任务已启动",
                "dayreport": "100",
                "version": "blink",
                "city": null,
                "bandwidth": "0.0",
                "id": "41",
                "online_time": "2017-03-03 10:21:44",
                "testgroup_name": "默认任务",
                "name": "78:A3:51:22:59:A8",
                "sysuuid": "78:A3:51:22:59:A8",
                "brasname": "",
                "testgroup": "1",
                "dnsip": null,
                "phonenum": null,
                "oltname": "",
                "run_interval": "60",
                "useruid": "59JNB9",
                "isp_man": "",
                "vpnip": null,
                "isp": null,
                "onlinestatus": "在线",
                "networkdevice": null,
                "ip": "113.111.64.149",
                "address": null,
                "county": "",
                "oltport": null,
                "device": null,
                "uplink": null
            }, {
                "oltip": null,
                "brasip": null,
                "accesslayer": null,
                "model": "PC桌面版",
                "location": "未知",
                "city_man": "",
                "brasport": null,
                "networktype": null,
                "contact": null,
                "accesstype": null,
                "teststatus": "任务已启动",
                "dayreport": "100",
                "version": "PC桌面版",
                "city": "内蒙古自治区包头市",
                "bandwidth": "0.0",
                "id": "37",
                "online_time": "2017-03-02 14:05:49",
                "testgroup_name": "默认任务",
                "name": "APS51S",
                "sysuuid": "28-D2-44-D6-73-A7",
                "brasname": "",
                "testgroup": "1",
                "dnsip": null,
                "phonenum": null,
                "oltname": "",
                "run_interval": "60",
                "useruid": "APS51S",
                "isp_man": "",
                "vpnip": null,
                "isp": "电信",
                "onlinestatus": "在线",
                "networkdevice": null,
                "ip": "1.180.212.102",
                "address": null,
                "county": "",
                "oltport": null,
                "device": null,
                "uplink": null
            }, {
                "oltip": null,
                "brasip": null,
                "accesslayer": null,
                "model": "PC桌面版",
                "location": "未知",
                "city_man": "",
                "brasport": null,
                "networktype": null,
                "contact": null,
                "accesstype": null,
                "teststatus": "任务已启动",
                "dayreport": "100",
                "version": "PC桌面版",
                "city": "陕西省西安市",
                "bandwidth": "0.0",
                "id": "36",
                "online_time": "2017-01-09 11:54:50",
                "testgroup_name": "默认任务",
                "name": "HHFU2M",
                "sysuuid": "0C-82-68-53-2C-74",
                "brasname": "",
                "testgroup": "1",
                "dnsip": null,
                "phonenum": null,
                "oltname": "",
                "run_interval": "60",
                "useruid": "HHFU2M",
                "isp_man": "",
                "vpnip": null,
                "isp": "广电网",
                "onlinestatus": "在线",
                "networkdevice": null,
                "ip": "182.81.228.143",
                "address": null,
                "county": "",
                "oltport": null,
                "device": null,
                "uplink": null
            }, {
                "oltip": null,
                "brasip": null,
                "accesslayer": null,
                "model": "硬件版",
                "location": "未知",
                "city_man": "西安市",
                "brasport": null,
                "networktype": null,
                "contact": null,
                "accesstype": null,
                "teststatus": "任务已启动",
                "dayreport": "100",
                "version": "blink",
                "city": null,
                "bandwidth": "0.0",
                "id": "35",
                "online_time": "2016-12-22 16:58:57",
                "testgroup_name": "默认任务",
                "name": "78:A3:51:21:FB:44",
                "sysuuid": "78:A3:51:21:FB:44",
                "brasname": "XA-BL-BAS-1.MAN.ME60",
                "testgroup": "1",
                "dnsip": null,
                "phonenum": null,
                "oltname": null,
                "run_interval": "60",
                "useruid": "TGPQD8",
                "isp_man": null,
                "vpnip": null,
                "isp": null,
                "onlinestatus": "在线",
                "networkdevice": null,
                "ip": "182.81.205.175",
                "address": "正街乐居场棚A4标段6号楼12层ONU-1",
                "county": "碑林区",
                "oltport": null,
                "device": null,
                "uplink": null
            }, {
                "oltip": null,
                "brasip": null,
                "accesslayer": null,
                "model": "硬件版",
                "location": "未知",
                "city_man": "西安市",
                "brasport": " ",
                "networktype": null,
                "contact": null,
                "accesstype": null,
                "teststatus": "任务已启动",
                "dayreport": "100",
                "version": "blink",
                "city": null,
                "bandwidth": "0.0",
                "id": "34",
                "online_time": "2016-12-22 15:51:45",
                "testgroup_name": "默认任务",
                "name": "78:A3:51:1E:E6:4C",
                "sysuuid": "78:A3:51:1E:E6:4C",
                "brasname": "XA-BL-BAS-2.MAN.ME60",
                "testgroup": "1",
                "dnsip": null,
                "phonenum": null,
                "oltname": null,
                "run_interval": "60",
                "useruid": "3JBTWR",
                "isp_man": null,
                "vpnip": null,
                "isp": null,
                "onlinestatus": "在线",
                "networkdevice": null,
                "ip": "139.148.51.241",
                "address": "乐居场棚A4标段3号楼18层 ONU-2",
                "county": "碑林区",
                "oltport": null,
                "device": null,
                "uplink": null
            }, {
                "oltip": null,
                "brasip": null,
                "accesslayer": null,
                "model": "硬件版",
                "location": "未知",
                "city_man": "西安市",
                "brasport": null,
                "networktype": null,
                "contact": null,
                "accesstype": null,
                "teststatus": "任务已启动",
                "dayreport": "100",
                "version": "blink",
                "city": null,
                "bandwidth": "0.0",
                "id": "33",
                "online_time": "2016-12-22 15:28:21",
                "testgroup_name": "默认任务",
                "name": "78:A3:51:22:05:78",
                "sysuuid": "78:A3:51:22:05:78",
                "brasname": "XA-BL-BAS-3.MAN.ME60",
                "testgroup": "1",
                "dnsip": null,
                "phonenum": null,
                "oltname": null,
                "run_interval": "60",
                "useruid": "FGYXCM",
                "isp_man": null,
                "vpnip": null,
                "isp": null,
                "onlinestatus": "在线",
                "networkdevice": null,
                "ip": "10.129.217.233",
                "address": "蔡家巷小区ONU-3",
                "county": "碑林区",
                "oltport": null,
                "device": null,
                "uplink": null
            }, {
                "oltip": null,
                "brasip": null,
                "accesslayer": null,
                "model": "硬件版",
                "location": "未知",
                "city_man": "西安市",
                "brasport": null,
                "networktype": null,
                "contact": null,
                "accesstype": null,
                "teststatus": "任务已启动",
                "dayreport": "100",
                "version": "blink",
                "city": null,
                "bandwidth": "0.0",
                "id": "27",
                "online_time": "2016-12-22 14:19:40",
                "testgroup_name": "默认任务",
                "name": "78:A3:51:1E:F2:D4",
                "sysuuid": "78:A3:51:1E:F2:D4",
                "brasname": "XA-BL-BAS-4.MAN.ME60",
                "testgroup": "1",
                "dnsip": null,
                "phonenum": null,
                "oltname": null,
                "run_interval": "60",
                "useruid": "QYT88B",
                "isp_man": null,
                "vpnip": null,
                "isp": null,
                "onlinestatus": "在线",
                "networkdevice": null,
                "ip": "10.128.166.26",
                "address": "西安市碑林区太乙路街道办乐居场正街乐居场棚改安置A4标段6号楼6层",
                "county": "碑林区",
                "oltport": null,
                "device": null,
                "uplink": null
            }, {
                "oltip": null,
                "brasip": null,
                "accesslayer": null,
                "model": "硬件版",
                "location": "未知",
                "city_man": "",
                "brasport": null,
                "networktype": null,
                "contact": null,
                "accesstype": null,
                "teststatus": "任务已启动",
                "dayreport": "100",
                "version": "blink",
                "city": null,
                "bandwidth": "0.0",
                "id": "26",
                "online_time": "2016-12-22 14:13:55",
                "testgroup_name": "默认任务",
                "name": "BC:AE:C5:C4:C4:2D",
                "sysuuid": "BC:AE:C5:C4:C4:2D",
                "brasname": "",
                "testgroup": "1",
                "dnsip": null,
                "phonenum": null,
                "oltname": "",
                "run_interval": "60",
                "useruid": "NH7GHH",
                "isp_man": "",
                "vpnip": null,
                "isp": null,
                "onlinestatus": "在线",
                "networkdevice": null,
                "ip": "123.14.31.236",
                "address": null,
                "county": "",
                "oltport": null,
                "device": null,
                "uplink": null
            }, {
                "oltip": null,
                "brasip": null,
                "accesslayer": null,
                "model": "PC桌面版",
                "location": "未知",
                "city_man": "",
                "brasport": null,
                "networktype": null,
                "contact": null,
                "accesstype": null,
                "teststatus": "任务已启动",
                "dayreport": "100",
                "version": "PC桌面版",
                "city": "内蒙古自治区包头市",
                "bandwidth": "0.0",
                "id": "24",
                "online_time": "2017-01-09 09:30:55",
                "testgroup_name": "默认任务",
                "name": "XTXD5P",
                "sysuuid": "E6-02-9B-42-0E-F5",
                "brasname": "",
                "testgroup": "1",
                "dnsip": null,
                "phonenum": null,
                "oltname": "",
                "run_interval": "60",
                "useruid": "XTXD5P",
                "isp_man": "",
                "vpnip": null,
                "isp": "电信",
                "onlinestatus": "在线",
                "networkdevice": null,
                "ip": "1.180.212.141",
                "address": null,
                "county": "",
                "oltport": null,
                "device": null,
                "uplink": null
            }, {
                "oltip": null,
                "brasip": null,
                "accesslayer": null,
                "model": "PC桌面版",
                "location": "未知",
                "city_man": "",
                "brasport": null,
                "networktype": null,
                "contact": null,
                "accesstype": null,
                "teststatus": "任务已启动",
                "dayreport": "100",
                "version": "PC桌面版",
                "city": "内蒙古自治区包头市",
                "bandwidth": "0.0",
                "id": "23",
                "online_time": "2017-04-07 15:32:57",
                "testgroup_name": "默认任务",
                "name": "2HPSW1",
                "sysuuid": "50-7B-9D-B0-B7-30",
                "brasname": "",
                "testgroup": "1",
                "dnsip": null,
                "phonenum": null,
                "oltname": "",
                "run_interval": "60",
                "useruid": "2HPSW1",
                "isp_man": "",
                "vpnip": null,
                "isp": "电信",
                "onlinestatus": "在线",
                "networkdevice": null,
                "ip": "1.180.212.190",
                "address": null,
                "county": "",
                "oltport": null,
                "device": null,
                "uplink": null
            }, {
                "oltip": null,
                "brasip": null,
                "accesslayer": null,
                "model": "PC桌面版",
                "location": "未知",
                "city_man": "",
                "brasport": null,
                "networktype": null,
                "contact": null,
                "accesstype": null,
                "teststatus": "任务已启动",
                "dayreport": "100",
                "version": "PC桌面版",
                "city": "广东省广州市",
                "bandwidth": "0.0",
                "id": "22",
                "online_time": "2016-12-14 10:28:15",
                "testgroup_name": "默认任务",
                "name": "S4Z8N1",
                "sysuuid": "00-15-00-BA-AA-59",
                "brasname": "",
                "testgroup": "1",
                "dnsip": null,
                "phonenum": null,
                "oltname": "",
                "run_interval": "60",
                "useruid": "S4Z8N1",
                "isp_man": "",
                "vpnip": null,
                "isp": "电信",
                "onlinestatus": "在线",
                "networkdevice": null,
                "ip": "119.131.76.210",
                "address": null,
                "county": "",
                "oltport": null,
                "device": null,
                "uplink": null
            }, {
                "oltip": null,
                "brasip": null,
                "accesslayer": null,
                "model": "PC桌面版",
                "location": "未知",
                "city_man": "",
                "brasport": null,
                "networktype": null,
                "contact": null,
                "accesstype": null,
                "teststatus": "任务已启动",
                "dayreport": "100",
                "version": "PC桌面版",
                "city": "广东省广州市",
                "bandwidth": "0.0",
                "id": "21",
                "online_time": "2016-12-13 09:01:23",
                "testgroup_name": "默认任务",
                "name": "EAXTF4",
                "sysuuid": "A0-88-69-6B-0C-0F",
                "brasname": "",
                "testgroup": "1",
                "dnsip": null,
                "phonenum": null,
                "oltname": "",
                "run_interval": "60",
                "useruid": "EAXTF4",
                "isp_man": "",
                "vpnip": null,
                "isp": "电信",
                "onlinestatus": "在线",
                "networkdevice": null,
                "ip": "113.111.65.138",
                "address": null,
                "county": "",
                "oltport": null,
                "device": null,
                "uplink": null
            }, {
                "oltip": null,
                "brasip": null,
                "accesslayer": null,
                "model": "PC桌面版",
                "location": "未知",
                "city_man": "",
                "brasport": null,
                "networktype": null,
                "contact": null,
                "accesstype": null,
                "teststatus": "任务已启动",
                "dayreport": "100",
                "version": "PC桌面版",
                "city": null,
                "bandwidth": "0.0",
                "id": "20",
                "online_time": "2016-12-12 16:16:23",
                "testgroup_name": "默认任务",
                "name": "6YNCPM",
                "sysuuid": "08-00-27-DE-E2-BD",
                "brasname": "",
                "testgroup": "1",
                "dnsip": null,
                "phonenum": null,
                "oltname": "",
                "run_interval": "60",
                "useruid": "6YNCPM",
                "isp_man": "",
                "vpnip": null,
                "isp": null,
                "onlinestatus": "在线",
                "networkdevice": null,
                "ip": "183.232.175.3",
                "address": null,
                "county": "",
                "oltport": null,
                "device": null,
                "uplink": null
            }, {
                "oltip": null,
                "brasip": null,
                "accesslayer": null,
                "model": "PC桌面版",
                "location": "未知",
                "city_man": "",
                "brasport": null,
                "networktype": null,
                "contact": null,
                "accesstype": null,
                "teststatus": "任务已启动",
                "dayreport": "100",
                "version": "PC桌面版",
                "city": "广东省广州市",
                "bandwidth": "0.0",
                "id": "19",
                "online_time": "2016-12-23 09:07:01",
                "testgroup_name": "默认任务",
                "name": "NNP2QP",
                "sysuuid": "70-77-81-16-B2-9F",
                "brasname": "",
                "testgroup": "1",
                "dnsip": null,
                "phonenum": null,
                "oltname": "",
                "run_interval": "60",
                "useruid": "NNP2QP",
                "isp_man": "",
                "vpnip": null,
                "isp": "电信",
                "onlinestatus": "在线",
                "networkdevice": null,
                "ip": "113.111.65.84",
                "address": null,
                "county": "",
                "oltport": null,
                "device": null,
                "uplink": null
            }, {
                "oltip": null,
                "brasip": null,
                "accesslayer": null,
                "model": "PC桌面版",
                "location": "未知",
                "city_man": "",
                "brasport": null,
                "networktype": null,
                "contact": null,
                "accesstype": null,
                "teststatus": "任务已启动",
                "dayreport": "100",
                "version": "PC桌面版",
                "city": "广东省广州市",
                "bandwidth": "0.0",
                "id": "18",
                "online_time": "2016-12-29 11:03:34",
                "testgroup_name": "默认任务",
                "name": "UX6SUX",
                "sysuuid": "4C-BB-58-35-78-DD",
                "brasname": "",
                "testgroup": "1",
                "dnsip": null,
                "phonenum": null,
                "oltname": "",
                "run_interval": "60",
                "useruid": "UX6SUX",
                "isp_man": "",
                "vpnip": null,
                "isp": "电信",
                "onlinestatus": "在线",
                "networkdevice": null,
                "ip": "121.33.175.124",
                "address": null,
                "county": "",
                "oltport": null,
                "device": null,
                "uplink": null
            }, {
                "oltip": null,
                "brasip": null,
                "accesslayer": null,
                "model": "PC桌面版",
                "location": "未知",
                "city_man": "",
                "brasport": null,
                "networktype": null,
                "contact": null,
                "accesstype": null,
                "teststatus": "任务已启动",
                "dayreport": "100",
                "version": "PC桌面版",
                "city": "广东省广州市",
                "bandwidth": "0.0",
                "id": "17",
                "online_time": "2017-01-09 15:21:54",
                "testgroup_name": "默认任务",
                "name": "8ZX58Y",
                "sysuuid": "00-0C-29-74-99-5E",
                "brasname": "",
                "testgroup": "1",
                "dnsip": null,
                "phonenum": null,
                "oltname": "",
                "run_interval": "60",
                "useruid": "8ZX58Y",
                "isp_man": "",
                "vpnip": null,
                "isp": "电信",
                "onlinestatus": "在线",
                "networkdevice": null,
                "ip": "113.111.65.166",
                "address": null,
                "county": "",
                "oltport": null,
                "device": null,
                "uplink": null
            }, {
                "oltip": null,
                "brasip": null,
                "accesslayer": null,
                "model": "硬件版",
                "location": "未知",
                "city_man": "",
                "brasport": null,
                "networktype": null,
                "contact": null,
                "accesstype": null,
                "teststatus": "任务已启动",
                "dayreport": "100",
                "version": "blink",
                "city": null,
                "bandwidth": "0.0",
                "id": "16",
                "online_time": "2016-12-07 07:50:28",
                "testgroup_name": "默认任务",
                "name": "78:A3:51:18:82:74",
                "sysuuid": "78:A3:51:18:82:74",
                "brasname": "",
                "testgroup": "1",
                "dnsip": null,
                "phonenum": null,
                "oltname": "",
                "run_interval": "60",
                "useruid": "Q3F1UD",
                "isp_man": "",
                "vpnip": null,
                "isp": null,
                "onlinestatus": "在线",
                "networkdevice": null,
                "ip": "120.197.83.180",
                "address": null,
                "county": "",
                "oltport": null,
                "device": null,
                "uplink": null
            }, {
                "oltip": null,
                "brasip": null,
                "accesslayer": null,
                "model": "硬件版",
                "location": "未知",
                "city_man": "西安市",
                "brasport": null,
                "networktype": null,
                "contact": null,
                "accesstype": null,
                "teststatus": "任务已启动",
                "dayreport": "100",
                "version": "blink",
                "city": null,
                "bandwidth": "0.0",
                "id": "15",
                "online_time": "2016-12-04 22:23:25",
                "testgroup_name": "默认任务",
                "name": "F4:8E:38:C5:A0:2C",
                "sysuuid": "F4:8E:38:C5:A0:2C",
                "brasname": null,
                "testgroup": "1",
                "dnsip": null,
                "phonenum": null,
                "oltname": null,
                "run_interval": "60",
                "useruid": "5DHG5N",
                "isp_man": null,
                "vpnip": null,
                "isp": null,
                "onlinestatus": "在线",
                "networkdevice": null,
                "ip": "124.47.32.116",
                "address": "北大街光辉巷-骨干探针",
                "county": "新城区",
                "oltport": null,
                "device": null,
                "uplink": null
            }, {
                "oltip": null,
                "brasip": null,
                "accesslayer": null,
                "model": "硬件版",
                "location": "未知",
                "city_man": "西安市",
                "brasport": null,
                "networktype": null,
                "contact": null,
                "accesstype": null,
                "teststatus": "任务已启动",
                "dayreport": "100",
                "version": "blink",
                "city": null,
                "bandwidth": "0.0",
                "id": "13",
                "online_time": "2016-12-04 11:23:52",
                "testgroup_name": "默认任务",
                "name": "78:A3:51:1F:01:64",
                "sysuuid": "78:A3:51:1F:01:64",
                "brasname": "XA-BL-BAS-1.MAN.ME60",
                "testgroup": "1",
                "dnsip": null,
                "phonenum": null,
                "oltname": null,
                "run_interval": "60",
                "useruid": "QAZZRC",
                "isp_man": null,
                "vpnip": null,
                "isp": null,
                "onlinestatus": "在线",
                "networkdevice": null,
                "ip": "10.26.1.102",
                "address": "太乙路乐居场正街乐居场棚A4标段6号楼",
                "county": "碑林区",
                "oltport": null,
                "device": null,
                "uplink": null
            }, {
                "oltip": null,
                "brasip": null,
                "accesslayer": null,
                "model": "硬件版",
                "location": "未知",
                "city_man": "西安市",
                "brasport": null,
                "networktype": null,
                "contact": null,
                "accesstype": null,
                "teststatus": "任务已启动",
                "dayreport": "100",
                "version": "blink",
                "city": null,
                "bandwidth": "0.0",
                "id": "12",
                "online_time": "2016-12-03 20:28:35",
                "testgroup_name": "默认任务",
                "name": "78:A3:51:1C:02:18",
                "sysuuid": "78:A3:51:1C:02:18",
                "brasname": "XA-BL-BAS-3.MAN.ME60",
                "testgroup": "1",
                "dnsip": null,
                "phonenum": null,
                "oltname": null,
                "run_interval": "60",
                "useruid": "XGVVAB",
                "isp_man": null,
                "vpnip": null,
                "isp": null,
                "onlinestatus": "在线",
                "networkdevice": null,
                "ip": "182.81.226.35",
                "address": "东关南街街道办蔡家巷小区",
                "county": "碑林区",
                "oltport": null,
                "device": null,
                "uplink": null
            }, {
                "oltip": null,
                "brasip": null,
                "accesslayer": null,
                "model": "硬件版",
                "location": "未知",
                "city_man": "西安市",
                "brasport": null,
                "networktype": null,
                "contact": null,
                "accesstype": null,
                "teststatus": "任务已启动",
                "dayreport": "100",
                "version": "blink",
                "city": null,
                "bandwidth": "0.0",
                "id": "11",
                "online_time": "2016-12-02 18:32:50",
                "testgroup_name": "默认任务",
                "name": "78:A3:51:21:FD:7C",
                "sysuuid": "78:A3:51:21:FD:7C",
                "brasname": "XA-BL-BAS-2.MAN.ME60",
                "testgroup": "1",
                "dnsip": null,
                "phonenum": null,
                "oltname": null,
                "run_interval": "60",
                "useruid": "DKPFRS",
                "isp_man": null,
                "vpnip": null,
                "isp": null,
                "onlinestatus": "在线",
                "networkdevice": null,
                "ip": "111.19.57.235",
                "address": "太乙路乐居场正街乐居场棚A4标段3号楼",
                "county": "碑林区",
                "oltport": null,
                "device": null,
                "uplink": null
            }, {
                "oltip": null,
                "brasip": null,
                "accesslayer": null,
                "model": "硬件版",
                "location": "未知",
                "city_man": "西安市",
                "brasport": null,
                "networktype": null,
                "contact": null,
                "accesstype": null,
                "teststatus": "任务已启动",
                "dayreport": "100",
                "version": "blink",
                "city": null,
                "bandwidth": "0.0",
                "id": "10",
                "online_time": "2016-12-02 12:20:31",
                "testgroup_name": "默认任务",
                "name": "78:A3:51:1E:E7:B0",
                "sysuuid": "78:A3:51:1E:E7:B0",
                "brasname": "XA-BL-BAS-1.MAN.ME60",
                "testgroup": "1",
                "dnsip": null,
                "phonenum": null,
                "oltname": null,
                "run_interval": "60",
                "useruid": "6DRS3J",
                "isp_man": null,
                "vpnip": null,
                "isp": null,
                "onlinestatus": "在线",
                "networkdevice": null,
                "ip": "182.80.220.172",
                "address": "太乙路乐居场正街乐居场棚A4标段6号楼 ",
                "county": "碑林区",
                "oltport": null,
                "device": null,
                "uplink": null
            }, {
                "oltip": null,
                "brasip": null,
                "accesslayer": null,
                "model": "硬件版",
                "location": "未知",
                "city_man": "",
                "brasport": null,
                "networktype": null,
                "contact": null,
                "accesstype": null,
                "teststatus": "任务已启动",
                "dayreport": "100",
                "version": "blink",
                "city": null,
                "bandwidth": "0.0",
                "id": "9",
                "online_time": "2016-12-02 11:43:53",
                "testgroup_name": "默认任务",
                "name": "78:A3:51:21:FB:68",
                "sysuuid": "78:A3:51:21:FB:68",
                "brasname": "",
                "testgroup": "1",
                "dnsip": null,
                "phonenum": null,
                "oltname": "",
                "run_interval": "60",
                "useruid": "8GDJ2C",
                "isp_man": "",
                "vpnip": null,
                "isp": null,
                "onlinestatus": "在线",
                "networkdevice": null,
                "ip": "113.111.65.243",
                "address": null,
                "county": "",
                "oltport": null,
                "device": null,
                "uplink": null
            }, {
                "oltip": null,
                "brasip": null,
                "accesslayer": null,
                "model": "硬件版",
                "location": "未知",
                "city_man": "西安市",
                "brasport": null,
                "networktype": null,
                "contact": null,
                "accesstype": null,
                "teststatus": "任务已启动",
                "dayreport": "100",
                "version": "blink",
                "city": null,
                "bandwidth": "0.0",
                "id": "8",
                "online_time": "2016-12-02 19:19:42",
                "testgroup_name": "默认任务",
                "name": "78:A3:51:22:00:98",
                "sysuuid": "78:A3:51:22:00:98",
                "brasname": "XA-BL-BAS-0.MAN.ME62",
                "testgroup": "1",
                "dnsip": null,
                "phonenum": null,
                "oltname": null,
                "run_interval": "60",
                "useruid": "VE4B5E",
                "isp_man": null,
                "vpnip": null,
                "isp": null,
                "onlinestatus": "在线",
                "networkdevice": null,
                "ip": "139.148.28.226",
                "address": "兴庆路兴庆机房",
                "county": "碑林区",
                "oltport": null,
                "device": null,
                "uplink": null
            }]
        };

        /*页面刚加载,模拟异步数据*/
        /********************************************************/

        vm.users = probe_data.rows;
        console.log(vm.users);
    }
});

