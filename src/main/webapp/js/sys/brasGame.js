/**
 * BRAS游戏感知对应的js
 * Created by tomxie on 2017/5/2.
 */

var get_area;
var flag = 0;
var starttime;
var endtime;
/*标志位,判断highcharts绘图Vue点击时间更新的series*/

var status = 0;
/*引入status表示当前状态option,解决bug 0:rtt_avg 1:tcpDelay 2:loss 3:qoe*/

var get_data;

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
var new_data1 = ['新城区', '碑林区', '莲湖区', '雁塔区', '未央区', '灞桥区', '长安区', '阎良区'];

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
        name: 'ping时延',
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
        console.log("A new date range was chosen: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
        console.log("地区选择:" + typeof(get_area) == "undefined");
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
            // postdata.area = $('#area').val();
            postdata.starttime = starttime;
            postdata.endtime = endtime;
            $.ajax({
                /*后台取得数据,赋值给观察者*/
                type: "POST",
                url: "../resultgametest/brasgamelist",
                cache: false,  //禁用缓存
                data: postdata,  //传入组装的参数
                dataType: "json",
                success: function (result) {
                    console.log(result);
                    console.log("成功返回!" + typeof (result.resultBRASGametestList));
                    console.log(result.resultBRASGametestList);
                    console.log(result.resultBRASGametestList.length);
                    if (result.resultBRASGametestList.length != 0 && result.resultBRASGametestList[0] != null) {
                        if (result.resultBRASGametestList.length == 1) {
                            flag = 1;
                        } else {
                            flag = 0;
                        }
                        new_data.users = result.resultBRASGametestList;
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
            // postdata.area = '';
            postdata.starttime = new Date(new Date() - 1000 * 60 * 60 * 24 * 4).Format("yyyy-MM-dd") + " 00:00:00";
            /*前4天日期*/
            postdata.endtime = (new Date()).Format("yyyy-MM-dd") + " 23:59:59";
            /*当前日期*/
            console.log(postdata);
            $.ajax({
                /*后台取得数据,赋值给观察者*/
                type: "POST",
                url: "../resultgametest/brasgamelist",
                cache: false,  //禁用缓存
                data: postdata,  //传入组装的参数
                dataType: "json",
                success: function (result) {
                    console.log(result);
                    if (result.resultBRASGametestList.length == 2) {
                        staus = 0;
                        flag = 0;
                        button_change.delay();
                        /*option先回到状态0,注意,不然会出错*/
                        new_data.users = result.resultBRASGametestList;
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
        option_rtt_avg: {
            /*设置时延option*/
            title: {
                text: ''
            },
            series_rtt_avg: [{
                name: 'ping时延',
                data: []
            },
            ],
            yAxis: {
                title: {
                    text: '结果(ms)'
                }
            }
        },
        option_tcpDelay: {
            /*设置时延option*/
            title: {
                text: ''
            },
            series_tcpDelay: [{
                name: '连接时延',
                data: []
            },
            ],
            yAxis: {
                title: {
                    text: '结果(ms)'
                }
            }
        },
        option_loss: {
            /*设置丢包option*/
            title: {
                text: ''
            },
            series_loss: [{
                name: '丢包',
                data: []
            }
            ],
            yAxis: {
                title: {
                    text: '结果(%)'
                },
                max: 100
            },
            tooltip: {
                /*数据提示框*/
                valueSuffix: '%'    /* y值后缀字符串*/
            }
        },
        option_qoe: {
            /*设置qoe option*/
            title: {
                text: ''
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
        }
    },
    // 在 `methods` 对象中定义方法
    methods: {
        /*事件监听*/
        rtt_avg: function () {
            status = 0;
            console.log("ping时延");
            options.title = this.option_rtt_avg.title;
            /*设置标题*/

            options.series = this.option_rtt_avg.series_rtt_avg;
            /*设置数据*/

            options.yAxis = this.option_rtt_avg.yAxis;
            /*设置y轴*/
            options.tooltip = {};
            /*设置数据提示框*/
            var chart = new Highcharts.Chart('container', options)
            /*重新绘图*/
        },

        tcpDelay: function () {
            status = 1;
            console.log("连接时延");
            options.title = this.option_tcpDelay.title;
            /*设置标题*/

            options.series = this.option_tcpDelay.series_tcpDelay;
            /*设置数据*/

            options.yAxis = this.option_tcpDelay.yAxis;
            /*设置y轴*/
            options.tooltip = {};
            /*设置数据提示框*/
            var chart = new Highcharts.Chart('container', options)
            /*重新绘图*/
        },
        loss: function () {
            status = 2;
            console.log("丢包");
            options.title = this.option_loss.title;
            options.series = this.option_loss.series_loss;
            options.yAxis = this.option_loss.yAxis;
            options.tooltip = this.option_loss.tooltip;
            var chart = new Highcharts.Chart('container', options)
        },
        qoe: function () {
            status = 3;
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
    template: '<table class="table table-bordered table-hover table-striped" id="bras_table"></table>',
    props: ['users'],
    data() {
        return {
            headers: [
                {title: 'BRAS'},
                {title: 'ping时延(ms)',},
                {title: '连接时延(ms)'},
                {title: '丢包(%)'},
                {title: 'qoe(分)'}
            ],
            rows: [],
            dtHandle: null
        }
    },
    watch: {
        users(val) {
            let vm = this;
            vm.rows = [];
            var times = 1;
            if (flag == 1) {
                times = 0;
            }

            options.xAxis.categories = [];
            if (status == 0) {                       /*先清空当前状态option的data*/
                options.series[0].data = [];
            } else if (status == 1) {
                options.series[0].data = [];
            } else if (status == 2) {
                options.series[0].data = [];
            } else {
                options.series[0].data = [];
            }

            button_change.option_rtt_avg.series_rtt_avg[0].data = [];
            /*清空所有监听事件的option数据*/
            /*动态设置button_change.option*/
            button_change.option_tcpDelay.series_tcpDelay[0].data = [];
            button_change.option_loss.series_loss[0].data = [];
            button_change.option_qoe.series_qoe[0].data = [];

            for (var i = 0; i <= times; i++) {                          /*观察user是否变化,重绘HighCharts图*/
                options.xAxis.categories[i] = val[i].brasName;
                if (status == 0) {                                       /*设置当前状态option*/
                    options.series[0].data[i] = val[i].rtt_avg;
                    /*动态设置option*/
                } else if (status == 1) {
                    options.series[0].data[i] = val[i].tcpDelay;
                } else if (status == 2) {
                    options.series[0].data[i] = val[i].loss;
                } else {
                    options.series[0].data[i] = val[i].qoe;
                }

                button_change.option_rtt_avg.series_rtt_avg[0].data[i] = val[i].rtt_avg;
                /*设置监听事件所有option*/
                /*动态设置button_change.option*/
                button_change.option_tcpDelay.series_tcpDelay[0].data[i] = val[i].tcpDelay;
                button_change.option_loss.series_loss[0].data[i] = val[i].loss;
                button_change.option_qoe.series_qoe[0].data[i] = val[i].qoe;
            }
            var chart = new Highcharts.Chart('container', options);


            val.forEach(function (item) {              /*观察user是否变化,更新表格数据*/
                let row = [];

                row.push(item.brasName);
                row.push(item.rtt_avg);
                row.push(item.tcpDelay);
                row.push(item.loss);
                row.push(item.qoe);

                console.log(item);

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
        }
    },
    mounted() {
        Reset.reset();
        /*调用reset,即为页面加载状态*/
    }
});


/*导出表格到excel*/
function exportExcel() {
    alasql('SELECT * INTO XLSX("BRAS游戏感知对比.xlsx",{headers:true}) \
                    FROM HTML("#bras_table",{headers:true})');

}
