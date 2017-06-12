 /**
 * 区县感知变化趋势对应的js
 * Created by tomxie on 2017/5/4.
 */
var flag = 0;
var starttime;
var endtime;
/*标志位,判断highcharts绘图Vue点击时间更新的series*/

var staus = 0;
/*引入status表示当前状态option,解决bug 0:ping 1:loss 2:qoe*/

var get_data;

var data_fitst = [];

$(document).on("click", ".dropdown-menu li a", function () {
    get_area = $(this).text().trim();
    /*trim()去除空格*/
    /*获取下拉值*/
    $('#area').val(get_area);
    /*区域选择框赋值*/
    console.log(get_area);
});

var area_choose = new Vue({
    el: '#area_choose',
    data: {
        items: [
            {message: '新城区'},
            {message: '碑林区'},
            {message: '莲湖区'},
            {message: '雁塔区'},
            {message: '未央区'},
            {message: '灞桥区'},
            {message: '长安区'},
            {message: '阎良区'}
        ]
    }
});
$('#bras').typeahead({
    /*输入提示框*/
    source: area_choose.items,
    items: 7        /*下拉菜单中显示的最大的条目数。*/

});

var json = {};
var options = {
    chart: {
        type: 'spline'
    },
    title: {
        text: ''
    },
    xAxis: {
        type: 'datetime',
        dateTimeLabelFormats: {
            day: '%Y-%m-%d',
            week: '%Y-%m-%d',
            month: '%Y-%m-%d',
            year: '%Y-%m-%d'
        },
        title: {
            text: 'Date'
        }
    },
    yAxis: {
        title: {
            text: '结果(分)'
        },
        min: 0,
        max: 100
    },
    tooltip: {
        headerFormat: '<b>{series.name}</b><br>',
        pointFormat: '日期:{point.x:%Y-%m-%d} qoe:{point.y:.2f}分'
    },
    plotOptions: {
        spline: {
            marker: {
                enabled: true
            }
        }
    },
    series: [{
        name: '网页感知',
        data: [
            // [Date.UTC(2017, 4, 3), 91.6667],
            // [Date.UTC(2017, 4, 4), 92.1765],
            // [Date.UTC(2017, 4, 5), 93.4504]
        ]
    }, {
        name: '视频感知',
        data: [
            // [Date.UTC(2017, 4, 3), 100],
            // [Date.UTC(2017, 4, 4), 68.3517],
            // [Date.UTC(2017, 4, 5), 64.2381]
        ]
    }, {
        name: '游戏感知',
        data: [
            // [Date.UTC(2017, 4, 3), null],
            // [Date.UTC(2017, 4, 4), null],
            // [Date.UTC(2017, 4, 5), null]
        ]
    }, {
        name: '下载感知',
        data: [
            // [Date.UTC(2017, 4, 3), null],
            // [Date.UTC(2017, 4, 4), null],
            // [Date.UTC(2017, 4, 5), null]
        ]
    }, {
        name: 'ping感知',
        data: [
            // [Date.UTC(2017, 4, 3), 99],
            // [Date.UTC(2017, 4, 4), 97.0655],
            // [Date.UTC(2017, 4, 5), 96.6111]
        ]
    }]
};

$(document).ready(function () {
    var chart = new Highcharts.Chart('container', options)
});

$('input[name="daterange"]').daterangepicker(
    {
        language: 'zn-ch',
        showDropdowns: false,
        applyClass: 'btn-success sure',

        locale: {
            format: 'YYYY-MM-DD', /*时间选择器汉化*/
            applyLabel: '确定',
            cancelLabel: '取消',
            fromLabel: '开始',
            toLabel: '结束',
            monthNames: "一月_二月_三月_四月_五月_六月_七月_八月_九月_十月_十一月_十二月".split("_"),
            daysOfWeek: "一_二_三_四_五_六_日".split("_"),

        },
        /*页面刚加载时,默认时间区间为最近4天*/
        startDate: new Date(new Date() - 1000 * 60 * 60 * 24 * 4).toLocaleDateString(), /*前4天日期*/
        endDate: (new Date()).toLocaleDateString(), /*当前日期*/
    },
    function (start, end, label) {          /*日期选择触发事件*/
        // console.log("A new date range was chosen: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
        starttime = start.format('YYYY-MM-DD HH:mm:ss');
        endtime = end.format('YYYY-MM-DD HH:mm:ss');

    });
/*$('#datepicker').datetimepicker({
 minView: "month", //选择日期后，不会再跳转去选择时分秒
 format: "yyyy-mm-dd", //选择日期后，文本框显示的日期格式
 language: 'zh-CN', //汉化
 autoclose:true //选择日期后自动关闭
 });*/
var new_search = new Vue({
    /*监听查询事件*/
    el: '#search',
    methods: {
        search: function () {
            console.log("你选择了时间区间" + starttime + "to" + endtime);
            var postdata = {};
            postdata.county = $('#area').val();
            postdata.starttime = starttime;
            postdata.endtime = endtime;
            // console.log("传递的参数：");
            // console.log(postdata);
            $.ajax({
                /*后台取得数据,赋值给观察者*/
                type: "POST",
                url: "../testagent/countydailyqoelist",
                cache: false,  //禁用缓存
                data: postdata,  //传入组装的参数
                dataType: "json",
                success: function (result) {
                    // console.log(result);
                    if (result.resultCountyDailyQoeList.length != 0 && result.resultCountyDailyQoeList[0] != null) {
                        if (result.resultCountyDailyQoeList.length == 1) {
                            flag = 1;
                        } else {
                            flag = 0;
                        }
                        new_data.users = result.resultCountyDailyQoeList;
                    } else {
                        toastr.warning('该时间区间没有对应数据！');
                    }
                }
            });

        }
    }
});
// 对Date的扩展，将 Date 转化为指定格式的String
Date.prototype.Format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};

var Reset = new Vue({
    /*重置,默认时间区间为最近4天*/
    el: '#reset',
    methods: {
        reset: function () {
            /****************************/
            /*重置,回到页面加载时的数据*/
            /**********************************/
            var postdata = {};
            postdata.county = null;
            postdata.starttime = new Date(new Date() - 1000 * 60 * 60 * 24 * 4).Format("yyyy-MM-dd") + " 00:00:00";
            /*前4天日期*/
            postdata.endtime = (new Date()).Format("yyyy-MM-dd") + " 23:59:59";
            /*当前日期*/
            // console.log(postdata);
            $.ajax({
                /*后台取得数据,赋值给观察者*/
                type: "POST",
                url: "../testagent/countydailyqoelist",
                cache: false,  //禁用缓存
                data: postdata,  //传入组装的参数
                dataType: "json",
                success: function (result) {
                    // console.log(result);
                    // console.log("成功返回!" + typeof (result.resultBRASDailyQoeList));
                    // console.log(result.resultBRASDailyQoeList);
                    // console.log(result.resultBRASDailyQoeList.length);
                    if (result.resultCountyDailyQoeList.length > 0) {
                        staus = 0;
                        flag = 0;
                        /*option先回到状态0,注意,不然会出错*/
                        new_data.users = result.resultCountyDailyQoeList;
                    } else {
                        toastr.warning('最近4天没有对应数据！');
                    }
                }
            });
        }
    }
});

Vue.component('data-table', {
    template: '<table class="table table-bordered table-hover table-striped" id="bras_table"></table>',
    props: ['users'],
    data() {
        return {
            headers: [
                {title: '区县'},
                {title: '网页感知(分)'},
                {title: '视频感知(分)'},
                {title: '游戏感知(分)'},
                {title: '下载感知(分)'},
                {title: 'ping感知(分)'},
                {title: '日期'}
            ],
            rows: [],
            dtHandle: null
        }
    },
    watch: {
        users(val, oldVal) {
            let vm = this;
            vm.rows = [];
            var times = 1;
            if (flag == 1) {
                times = 0;
            }
            for (let i = 0; i < options.series.length; i++) {
                options.series[i].data = [];
            }
            // options.xAxis.categories[0] = val[0].county;
            /*观察user是否变化,重绘HighCharts图*/
            for (let i = 0; i < val.length; i++) {
                // console.log(val[i].date);
                let date_token = val[i].date.split("-");
                let year = parseInt(date_token[0]);
                let month = parseInt(date_token[1]) - 1;
                let day = parseInt(date_token[2]);
                if (isNaN(year) || isNaN(month) || isNaN(day)) {
                    continue;
                }
                // console.log(Date.UTC(year, month, day));
                options.series[0].data[i] = [Date.UTC(year, month, day), val[i].httpAvgQoe];
                options.series[1].data[i] = [Date.UTC(year, month, day), val[i].youkuAvgQoe];
                options.series[2].data[i] = [Date.UTC(year, month, day), val[i].gameAvgQoe];
                options.series[3].data[i] = [Date.UTC(year, month, day), val[i].speedAvgQoe];
                options.series[4].data[i] = [Date.UTC(year, month, day), val[i].pingAvgQoe];
            }
            // console.log(options.series);
            var chart = new Highcharts.Chart('container', options);


            // You should _probably_ check that this is changed data... but we'll skip that for this example.
            val.forEach(function (item) {              /*观察user是否变化,更新表格数据*/
                // Fish out the specific column data for each item in your data set and push it to the appropriate place.
                // Basically we're just building a multi-dimensional array here. If the data is _already_ in the right format you could
                // skip this loop...
                let row = [];

                row.push(item.county);
                row.push(item.httpAvgQoe);
                row.push(item.youkuAvgQoe);
                row.push(item.gameAvgQoe);
                row.push(item.speedAvgQoe);
                row.push(item.pingAvgQoe);
                row.push(item.date);

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
            paging: false,
            //serverSide: true,
            info: false,
            ordering: false, /*禁用排序功能*/
            /*bInfo: false,*/

            bLengthChange: false, /*禁用Show entries*/
        });


    }
});

var new_data = new Vue({
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

        Reset.reset();
        /*调用reset,即为页面加载状态*/
    }
});


/*导出表格到excel*/
function exportExcel() {
    alasql('SELECT * INTO XLSX("BRAS感知变化趋势.xlsx",{headers:true}) \
                    FROM HTML("#bras_table",{headers:true})');

}