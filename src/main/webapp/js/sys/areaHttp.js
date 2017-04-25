/**
 * Created by apple on 2017/4/6.
 */
var get_area;
var flag = 0;
/*标志位,判断highcharts绘图Vue点击时间更新的series*/

var staus = 0;

var get_data;

$(document).on("click", ".dropdown-menu li a", function () {
    get_area = $(this).text().trim();
    /*trim()去除空格*/
    /*获取下拉值*/
    $('#area').val(get_area);
    /*区域选择框赋值*/
    console.log(get_area);
});

var data_fitst = [];

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
var new_data1 = ['新城区', '碑林区', '莲湖区', '雁塔区', '未央区', '灞桥区', '长安区', '阎良区']
$('#area').typeahead({
    /*输入提示框*/
    source: new_data1,
    items: 7        /*下拉菜单中显示的最大的条目数。*/

});

var options = {
    chart: {
        type: 'column'
    },
    title: {
        text: ''
    },
    xAxis: {

        categories: []

    },
    yAxis: {
        title: {
            text: '结果(ms)'
        }
    },
    credits: {
        enabled: false
    },
    series: [{
        name: 'DNS时延',
        data: []
    }, {
        name: 'TCP时延',
        data: []
    }, {
        name: '服务器时延',
        data: []
    }
    ]
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
        startDate: new Date(new Date() - 1000 * 60 * 60 * 24 * 4).toLocaleDateString(), /*前4天日期*/
        endDate: (new Date()).toLocaleDateString(), /*当前日期*/
    },
    function (start, end, label) {          /*日期选择触发事件*/
        /*console.log("A new date range was chosen: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));*/
        starttime = start.format('YYYY-MM-DD HH:mm:ss');
        endtime = end.format('YYYY-MM-DD HH:mm:ss');
    });

var new_search = new Vue({
    /*监听查询事件*/
    el: '#search',
    methods: {
        search: function () {
            console.log("你选择了时间区间" + starttime + "to" + endtime);
            var postdata = {};
            postdata.area = $('#area').val();
            postdata.starttime = starttime;
            postdata.endtime = endtime;
            $.ajax({
                /*后台取得数据,赋值给观察者*/
                type: "POST",
                url: "../resulthttptest/countyhttplist",
                cache: false,  //禁用缓存
                data: postdata,  //传入组装的参数
                dataType: "json",
                success: function (result) {
                    console.log(result);
                    console.log("成功返回!" + typeof (result.resultCountyHttptestList));
                    console.log(result.resultCountyHttptestList);
                    console.log(result.resultCountyHttptestList.length);
                    if (result.resultCountyHttptestList.length != 0 && result.resultCountyHttptestList[0] != null) {
                        if (result.resultCountyHttptestList.length == 1) {
                            flag = 1;
                        } else {
                            flag = 0;
                        }
                        new_data.users = result.resultCountyHttptestList;
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
    el: '#reset',
    methods: {
        reset: function () {
            /****************************/
            /*重置,回到页面加载时的数据*/
            var postdata = {};
            postdata.area = '';
            postdata.starttime = new Date(new Date() - 1000 * 60 * 60 * 24 * 4).Format("yyyy-MM-dd") + " 00:00:00";
            /*前4天日期*/
            postdata.endtime = (new Date()).Format("yyyy-MM-dd") + " 23:59:59";
            /*当前日期*/
            console.log(postdata);
            $.ajax({
                /*后台取得数据,赋值给观察者*/
                type: "POST",
                url: "../resulthttptest/countyhttplist",
                cache: false,  //禁用缓存
                data: postdata,  //传入组装的参数
                dataType: "json",
                success: function (result) {
                    console.log(result);
                    console.log("成功返回!" + typeof (result.resultCountyHttptestList));
                    console.log(result.resultCountyHttptestList[0]);
                    console.log(result.resultCountyHttptestList.length);
                    if (result.resultCountyHttptestList.length == 2) {
                        staus = 0;
                        flag = 0;
                        button_change.delay();
                        /*option先回到状态0,注意,不然会出错*/
                        new_data.users = result.resultCountyHttptestList;
                    } else {
                        toastr.warning('最近4天没有对应数据！');
                    }
                }
            });
        }
    }
});

var button_change = new Vue({
    /*实例化Vue*/
    el: '#charts_button',
    data: {
        option_delay: {
            /*设置时延option*/
            title: {
                text: ''
            },
            series_delay: [{
                name: 'DNS时延',
                data: []
            }, {
                name: 'TCP时延',
                data: []
            }, {
                name: '服务器时延',
                data: []
            }
            ],
            yAxis: {
                title: {
                    text: '结果(ms)'
                }
            }
        },
        option_qoe: {
            /*设置qoe option*/
            title: {
                text: 'qoe对比'
            },
            series_qoe: [{
                name: 'qoe',
                data: []
            }
            ],
            yAxis: {
                title: {
                    text: '结果(分)'
                },
                max: 100
            }
        },
        option_speed: {
            /*设置速率option*/
            title: {
                text: '速率'
            },
            series_speed: [{
                name: '速率',
                data: []
            }
            ],
            yAxis: {
                title: {
                    text: '结果(Mbps)'
                },
                max: 100
            },
        }


    },
    // 在 `methods` 对象中定义方法
    methods: {
        /*事件监听*/
        delay: function () {
            staus = 0;
            console.log("时延");
            options.title = this.option_delay.title;
            /*设置标题*/

            options.series = this.option_delay.series_delay;
            /*设置数据*/

            options.yAxis = this.option_delay.yAxis;
            /*设置y轴*/
            options.tooltip = {};
            /*设置数据提示框*/
            var chart = new Highcharts.Chart('container', options)
            /*重新绘图*/
        },
        speed: function () {
            staus = 1;
            console.log("速率");
            options.title = this.option_speed.title;
            options.series = this.option_speed.series_speed;
            options.yAxis = this.option_speed.yAxis;
            options.tooltip = {};
            var chart = new Highcharts.Chart('container', options)
        },
        qoe: function () {
            staus = 2;
            console.log("qoe");
            options.title = this.option_qoe.title;
            options.series = this.option_qoe.series_qoe;
            options.yAxis = this.option_qoe.yAxis;
            options.tooltip = {};
            var chart = new Highcharts.Chart('container', options)
        }
    }
});


Vue.component('data-table', {
    template: '<table class="table table-bordered table-hover table-striped" id="area_table"></table>',
    props: ['users'],
    data() {
        return {
            headers: [
                {title: '区县'},
                {title: 'DNS时延(ms)',},
                {title: 'TCP时延(ms)'},
                {title: '服务器时延(ms)'},
                {title: '速率(Mbps)'},
                {title: 'qoe(分)'}
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

            options.xAxis.categories = [];
            if (staus == 0) {                       /*先清空当前状态option的data*/
                options.series[0].data = [];
                /*动态设置option*/
                options.series[1].data = [];
                options.series[2].data = [];
            } else if (staus == 1) {
                options.series[0].data = [];
            } else {
                options.series[0].data = [];
            }

            button_change.option_delay.series_delay[0].data = [];
            /*清空所有监听事件的option数据*/
            /*动态设置button_change.option*/
            button_change.option_delay.series_delay[1].data = [];
            button_change.option_delay.series_delay[2].data = [];
            button_change.option_speed.series_speed[0].data = [];
            button_change.option_qoe.series_qoe[0].data = [];

            for (var i = 0; i <= times; i++) {                          /*观察user是否变化,重绘HighCharts图*/
                options.xAxis.categories[i] = val[i].county;
                if (staus == 0) {                                       /*设置当前状态option*/
                    options.series[0].data[i] = val[i].dnsDelay;
                    /*动态设置option*/
                    options.series[1].data[i] = val[i].connectDelay;
                    options.series[2].data[i] = val[i].responseDelay;
                } else if (staus == 1) {
                    options.series[0].data[i] = val[i].speed;
                } else {
                    options.series[0].data[i] = val[i].qoe;
                }

                button_change.option_delay.series_delay[0].data[i] = val[i].dnsDelay;
                /*设置监听事件所有option*/
                /*动态设置button_change.option*/
                button_change.option_delay.series_delay[1].data[i] = val[i].connectDelay;
                button_change.option_delay.series_delay[2].data[i] = val[i].responseDelay;
                button_change.option_speed.series_speed[0].data[i] = val[i].speed;
                button_change.option_qoe.series_qoe[0].data[i] = val[i].qoe;
            }
            var chart = new Highcharts.Chart('container', options);


            // You should _probably_ check that this is changed data... but we'll skip that for this example.
            val.forEach(function (item) {              /*观察user是否变化,更新表格数据*/
                // Fish out the specific column data for each item in your data set and push it to the appropriate place.
                // Basically we're just building a multi-dimensional array here. If the data is _already_ in the right format you could
                // skip this loop...
                let row = [];

                row.push(item.county);
                row.push(item.dnsDelay);
                row.push(item.connectDelay);
                row.push(item.responseDelay);
                row.push(item.speed);
                row.push(item.qoe);

                // console.log(item);

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
            dom: 'Bfrtip',
            buttons: [
                'copy', 'excel', 'pdf'
            ]
        });

        /*new $.fn.dataTable.Buttons( vm.dtHandle, {
         buttons: [
         'copy', 'excel', 'pdf'
         ]
         } );*/
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
    alasql('SELECT * INTO XLSX("区县Http对比.xlsx",{headers:true}) \
                    FROM HTML("#area_table",{headers:true})');

}







