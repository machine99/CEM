/**
 * Created by apple on 2017/4/19.
 */
var get_area;
var flag = 0;
var starttime;
var endtime;
/*标志位,判断highcharts绘图Vue点击时间更新的series*/

var staus = 0;
/*引入status表示当前状态option,解决bug 0:ping 1:loss 2:qoe*/

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


var json = {};
var options = {
    chart: {
        type: 'spline'
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
        name: '视频感知',
        data: []
    },{
        name: '网页感知',
        data: []
    }, {
        name: '游戏感知',
        data: []
    }, {
        name: '下载感知',
        data: []
    },{
        name: 'ping感知',
        data: []
    },
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
        /*页面刚加载时,默认时间区间为最近4天*/
        startDate: new Date(new Date() - 1000 * 60*60*24*4).toLocaleDateString(),  /*前4天日期*/
        endDate: (new Date()).toLocaleDateString() ,    /*当前日期*/
    },
    function (start, end, label) {          /*日期选择触发事件*/
        /*console.log("A new date range was chosen: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));*/
        starttime = start.format('YYYY/MM/DD');
        endtime = end.format('YYYY/MM/DD');

    });
var new_search = new Vue({        /*监听查询事件*/
    el:'#search',
    methods:{
        search:function () {
            console.log("你选择了时间区间"+starttime+"to"+endtime);
            var postdata = {};
            postdata.area = $('#area').val();
            postdata.starttime = starttime;
            postdata.endtime = endtime;
            $.ajax({                           /*后台取得数据,赋值给观察者*/
                type: "POST",
                url: "../resultpingtest/areapinglist",
                cache: false,  //禁用缓存
                data: postdata,  //传入组装的参数
                dataType: "json",
                success: function (result) {
                    console.log("成功返回!"+typeof (result.areaPingList));
                    console.log(result.areaPingList);
                    console.log(result.areaPingList.length);
                    if(result.areaPingList.length==1){
                        flag=1;
                    }else {
                        flag=0;
                    }
                    new_data.users = result.areaPingList;
                }
            });
        }
    }
});
var Reset = new Vue({               /*重置,默认时间区间为最近4天*/
    el: '#reset',
    methods: {
        reset: function () {
            var postdata = {};
            postdata.area = '';
            postdata.starttime = new Date(new Date() - 1000 * 60*60*24*4).toLocaleDateString();    /*当前日期*/
            postdata.endtime = (new Date()).toLocaleDateString();  /*前4天日期*/
            console.log(postdata);
            $.ajax({                           /*后台取得数据,赋值给观察者*/
                type: "POST",
                url: "../resultpingtest/areapinglist",
                cache: false,  //禁用缓存
                data: postdata,  //传入组装的参数
                dataType: "json",
                success: function (result) {
                    console.log("成功返回!"+typeof (result.areaPingList));
                    console.log(result.areaPingList);
                    console.log(result.areaPingList.length);
                    staus = 0;
                    flag = 0;
                    button_change.delay();
                    /*option先回到状态0,注意,不然会出错*/
                    result.areaPingList[0].rttAvg = 18.888888;   /*重新赋值,区分和其他选择日期的值,表示重置了*/
                    new_data.users = result.areaPingList;
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
                text: 'ping时延对比'
            },
            series_delay: [{
                name: '平均时延',
                data: []
            }, {
                name: '最大时延',
                data: []
            }, {
                name: '最小时延',
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
        option_loss: {
            /*设置丢包option*/
            title: {
                text: '丢包率'
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
        loss: function () {
            staus = 1;
            console.log("丢包");
            options.title = this.option_loss.title;

            options.series = this.option_loss.series_loss;
            options.yAxis = this.option_loss.yAxis;
            options.tooltip = this.option_loss.tooltip;
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
                {title: '平均时延(ms)', class: 'some-special-class'},
                {title: '最大时延(ms)'},
                {title: '最小时延(ms)'},
                {title: '丢包(%)'},
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
            button_change.option_loss.series_loss[0].data = [];
            button_change.option_qoe.series_qoe[0].data = [];

            for (var i = 0; i <= times; i++) {                          /*观察user是否变化,重绘HighCharts图*/
                options.xAxis.categories[i] = val[i].guid;
                if (staus == 0) {                                       /*设置当前状态option*/
                    options.series[0].data[i] = val[i].rttAvg;
                    /*动态设置option*/
                    options.series[1].data[i] = val[i].rttMax;
                    options.series[2].data[i] = val[i].rttMin;
                } else if (staus == 1) {
                    options.series[0].data[i] = val[i].loss;
                } else {
                    options.series[0].data[i] = val[i].qoe;
                }

                button_change.option_delay.series_delay[0].data[i] = val[i].rttAvg;
                /*设置监听事件所有option*/
                /*动态设置button_change.option*/
                button_change.option_delay.series_delay[1].data[i] = val[i].rttMax;
                button_change.option_delay.series_delay[2].data[i] = val[i].rttMin;
                button_change.option_loss.series_loss[0].data[i] = val[i].loss;
                button_change.option_qoe.series_qoe[0].data[i] = val[i].qoe;
            }
            var chart = new Highcharts.Chart('container', options);


            // You should _probably_ check that this is changed data... but we'll skip that for this example.
            val.forEach(function (item) {              /*观察user是否变化,更新表格数据*/
                // Fish out the specific column data for each item in your data set and push it to the appropriate place.
                // Basically we're just building a multi-dimensional array here. If the data is _already_ in the right format you could
                // skip this loop...
                let row = [];

                row.push(item.guid);
                row.push(item.rttAvg);
                row.push(item.rttMax);
                row.push(item.rttMin);
                row.push(item.loss);
                row.push(item.qoe);

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

            bLengthChange: false,    /*禁用Show entries*/
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
        /* let vm = this;
         /!*********************************************!/
         var area1 = {
         guid: "新城区",
         rttAvg: 18,
         rttMax: 21,
         rttMin: 17,
         loss: 0.03,
         qoe: 98
         };
         var area2 = {
         guid: "碑林区",
         rttAvg: 19,
         rttMax: 23,
         rttMin: 18,
         loss: 0.02,
         qoe: 96
         };
         console.log("返回值的函数:"+Reset.reset());
         data_fitst = [area1, area2];
         /!*页面刚加载,模拟异步数据*!/
         /!********************************************************!/

         vm.users = data_fitst;
         console.log(vm.users);*/
        Reset.reset();        /*调用reset,即为页面加载状态*/
    }
});


/*导出表格到excel*/
function exportExcel() {
    alasql('SELECT * INTO XLSX("区县Ping对比.xlsx",{headers:true}) \
                    FROM HTML("#area_table",{headers:true})');

}







