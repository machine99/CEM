/**
 * Created by apple on 2017/4/7.
 */

var get_area;
var flag = 0;
/*标志位,判断highcharts绘图Vue点击时间更新的series*/

var status = 0;
/*引入status表示当前状态option,解决bug 0:PingDelay 1:ConnectDelay 2:Loss 3:Qoe*/

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
        startDate: '2013-01-01',
        endDate: '2013-12-31'
    },
    function (start, end, label) {          /*日期选择触发事件*/
        console.log("A new date range was chosen: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
        console.log("地区选择:" + typeof(get_area) == "undefined");
        if (typeof(get_area) != "undefined" && $('#area').val() != '') {   /*此时应该判断输入框里内容不为空*/

            flag = 1;
            /*改变标志位*/
            get_data = {
                /*模拟异步数据*/
                myarea: get_area,
                PingDelay: 18,
                ConnectDelay: 22,
                Loss: 10,
                Qoe: 98
            };
            new_data.users = [get_data];
            /*观察者,更新user数据*/
        } else {          /*如果不选择地区,默认按照日期更新新城区和碑林区的数据*/
            flag = 0;
            /*********************************************/
            var area1 = {
                myarea: "新城区",
                PingDelay: 18,
                ConnectDelay: 22,
                Loss: 0.06,
                Qoe: 98
            };
            var area2 = {
                myarea: "碑林区",
                PingDelay: 18,
                ConnectDelay: 22,
                Loss: 15,
                Qoe: 98
            };
            new_area_data = [area1, area2];
            /*页面刚加载,模拟异步数据*/
            /********************************************************/
            new_data.users = new_area_data;
            /*观察者,更新highcharts表和表格*/
            console.log(new_data.users);
        }
    });

new Vue({
    el: '#reset',
    methods: {
        reset: function () {
            /****************************/
            /*重置,回到页面加载时的数据*/
            var area1 = {
                myarea: "新城区",
                PingDelay: 18,
                ConnectDelay: 22,
                Loss: 10,
                Qoe: 98
            };
            var area2 = {
                myarea: "碑林区",
                PingDelay: 18,
                ConnectDelay: 22,
                Loss: 15,
                Qoe: 98
            };
            /**********************************/
            status = 0;
            flag = 0;
            button_change.pingDelay();
            /*option先回到状态0,注意,不然会出错*/
            new_data.users = [area1, area2];
        }
    }
});

var button_change = new Vue({
    /*实例化Vue*/
    el: '#charts_button',
    data: {
        option_pingDelay: {
            /*设置时延option*/
            title: {
                text: ''
            },
            series_pingDelay: [{
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
        option_connectDelay: {
            /*设置时延option*/
            title: {
                text: ''
            },
            series_connectDelay: [{
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
            /*设置Qoe option*/
            title: {
                text: ''
            },
            series_qoe: [{
                name: 'Qoe',
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
        pingDelay: function () {
            status = 0;
            console.log("ping时延");
            options.title = this.option_pingDelay.title;
            /*设置标题*/

            options.series = this.option_pingDelay.series_pingDelay;
            /*设置数据*/

            options.yAxis = this.option_pingDelay.yAxis;
            /*设置y轴*/
            options.tooltip = {};
            /*设置数据提示框*/
            var chart = new Highcharts.Chart('container', options)
            /*重新绘图*/
        },

        connectDelay: function () {
            status = 1;
            console.log("连接时延");
            options.title = this.option_connectDelay.title;
            /*设置标题*/

            options.series = this.option_connectDelay.series_connectDelay;
            /*设置数据*/

            options.yAxis = this.option_connectDelay.yAxis;
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
            console.log("Qoe");
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
                {title: 'ping时延(ms)',},
                {title: '连接时延(ms)'},
                {title: '丢包(%)'},
                {title: 'Qoe(分)'}
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

            button_change.option_pingDelay.series_pingDelay[0].data = [];
            /*清空所有监听事件的option数据*/
            /*动态设置button_change.option*/
            button_change.option_connectDelay.series_connectDelay[0].data = [];
            button_change.option_loss.series_loss[0].data = [];
            button_change.option_qoe.series_qoe[0].data = [];

            for (var i = 0; i <= times; i++) {                          /*观察user是否变化,重绘HighCharts图*/
                options.xAxis.categories[i] = val[i].myarea;
                if (status == 0) {                                       /*设置当前状态option*/
                    options.series[0].data[i] = val[i].PingDelay;
                    /*动态设置option*/
                } else if (status == 1) {
                    options.series[0].data[i] = val[i].ConnectDelay;
                } else if (status == 2) {
                    options.series[0].data[i] = val[i].Loss;
                } else {
                    options.series[0].data[i] = val[i].Qoe;
                }

                button_change.option_pingDelay.series_pingDelay[0].data[i] = val[i].PingDelay;
                /*设置监听事件所有option*/
                /*动态设置button_change.option*/
                button_change.option_connectDelay.series_connectDelay[0].data[i] = val[i].ConnectDelay;
                button_change.option_loss.series_loss[0].data[i] = val[i].Loss;
                button_change.option_qoe.series_qoe[0].data[i] = val[i].Qoe;
            }
            var chart = new Highcharts.Chart('container', options);


            val.forEach(function (item) {              /*观察user是否变化,更新表格数据*/
                let row = [];

                row.push(item.myarea);
                row.push(item.PingDelay);
                row.push(item.ConnectDelay);
                row.push(item.Loss);
                row.push(item.Qoe);

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
        let vm = this;
        /*********************************************/
        var area1 = {
            myarea: "新城区",
            PingDelay: 18,
            ConnectDelay: 22,
            Loss: 10,
            Qoe: 98
        };
        var area2 = {
            myarea: "碑林区",
            PingDelay: 18,
            ConnectDelay: 22,
            Loss: 15,
            Qoe: 98
        };
        data_fitst = [area1, area2];
        /*页面刚加载,模拟异步数据*/
        /********************************************************/

        vm.users = data_fitst;
        console.log(vm.users);
        /*$.ajax({
         url: '../sys/user/list',
         dataType: 'json',
         data: {
         username: null,
         page: 1,
         limit: 10
         },
         success(r) {
         vm.users = r.page.list;
         console.log(vm.users)
         }
         });*/
    }
});


/*导出表格到excel*/
function exportExcel() {
    alasql('SELECT * INTO XLSX("区县Ping对比.xlsx",{headers:true}) \
                    FROM HTML("#area_table",{headers:true})');

}

/*$(document).ready(function() {
 alasql('SELECT * INTO HTML("#res",{headers:true}) \
 FROM XLSX("C:/Users/yuanbaby/Downloads/Ping.xlsx",\
 {headers:true})');
 alert("end of function")
 });*/






