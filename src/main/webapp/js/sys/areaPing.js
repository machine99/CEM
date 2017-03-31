/**
 * Created by yuanbaby on 2017/3/29.
 */
var get_area;
var flag = 0;
/*标志位,判断highcharts绘图Vue点击时间更新的series*/
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
})

var json = {};
var options = {
    chart: {
        type: 'column'
    },
    title: {
        text: 'ping时延对比'
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
        name: '平均时延',
        data: []
    }, {
        name: '最大时延',
        data: []
    }, {
        name: '最小时延',
        data: []
    }
    ]
};
$(document).ready(function () {
    var chart = new Highcharts.Chart('container', options)
});


$('input[name="daterange"]').daterangepicker(

    {
        language:'zn-ch',
        showDropdowns:false,
        applyClass:'btn-success sure',

        locale: {
            format: 'YYYY-MM-DD',               /*时间选择器汉化*/
            applyLabel:'确定',
            cancelLabel:'取消',
            fromLabel:'开始',
            toLabel:'结束',
            monthNames:"一月_二月_三月_四月_五月_六月_七月_八月_九月_十月_十一月_十二月".split("_"),
            daysOfWeek:"一_二_三_四_五_六_日".split("_"),

        },
        startDate: '2013-01-01',
        endDate: '2013-12-31'
    },
    function (start, end, label) {          /*日期选择触发事件*/
        console.log("A new date range was chosen: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
        console.log("地区选择:"+typeof(get_area) == "undefined");
        if(typeof(get_area) != "undefined"){
        flag = 1;
        /*改变标志位*/
        get_data = {
            /*模拟异步数据*/
            myarea: get_area,
            AverageDelay: 18,
            MaxDelay: 22,
            MinDelay: 17,
            Loss: 0.5,
            Qoe: 98
        };
            new_data.users = [get_data];     /*更新user数据*/
        }else {          /*如果不选择地区,默认按照日期更新新城区和碑林区的数据*/

            /*********************************************/
            var area1 = {
                myarea: "新城区",
                AverageDelay: 18.666666,
                MaxDelay: 21.2333,
                MinDelay: 17.4,
                Loss: 0.03,
                Qoe: 98.6
            };
            var area2 = {
                myarea: "碑林区",
                AverageDelay: 19.888888,
                MaxDelay: 23.322,
                MinDelay: 18.7,
                Loss: 0.02,
                Qoe: 96.7
            };
            new_area_data = [area1, area2];
            /*页面刚加载,模拟异步数据*/
            /********************************************************/
            new_data.users = new_area_data;        /*观察者,更新highcharts表和表格*/
            console.log(new_data.users);

        }

    });
/*$('#datepicker').datetimepicker({
 minView: "month", //选择日期后，不会再跳转去选择时分秒
 format: "yyyy-mm-dd", //选择日期后，文本框显示的日期格式
 language: 'zh-CN', //汉化
 autoclose:true //选择日期后自动关闭
 });*/

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
            console.log("丢包");
            options.title = this.option_loss.title;

            options.series = this.option_loss.series_loss;

            options.yAxis = this.option_loss.yAxis;
            options.tooltip = this.option_loss.tooltip;
            var chart = new Highcharts.Chart('container', options)
        },
        qoe: function () {
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
            if(flag==1){
                times=0;                          /*先清空所有option的data*/
                options.xAxis.categories=[];
                options.series[0].data=[];
                /*动态设置option*/
                options.series[1].data=[];
                options.series[2].data=[];

                button_change.option_delay.series_delay[0].data=[];
                /*动态设置button_change.option*/
                button_change.option_delay.series_delay[1].data=[];
                button_change.option_delay.series_delay[2].data=[];
                button_change.option_loss.series_loss[0].data=[];
                button_change.option_qoe.series_qoe[0].data=[];
            }

            for (var i = 0; i <= times; i++) {                          /*观察user是否变化,重绘HighCharts图*/
                options.xAxis.categories[i] = val[i].myarea;
                options.series[0].data[i] = val[i].AverageDelay;
                /*动态设置option*/
                options.series[1].data[i] = val[i].MaxDelay;
                options.series[2].data[i] = val[i].MinDelay;

                button_change.option_delay.series_delay[0].data[i] = val[i].AverageDelay;
                /*动态设置button_change.option*/
                button_change.option_delay.series_delay[1].data[i] = val[i].MaxDelay;
                button_change.option_delay.series_delay[2].data[i] = val[i].MinDelay;
                button_change.option_loss.series_loss[0].data[i] = val[i].Loss;
                button_change.option_qoe.series_qoe[0].data[i] = val[i].Qoe;
            }
            var chart = new Highcharts.Chart('container', options);


            // You should _probably_ check that this is changed data... but we'll skip that for this example.
            val.forEach(function (item) {              /*观察user是否变化,更新表格数据*/
                // Fish out the specific column data for each item in your data set and push it to the appropriate place.
                // Basically we're just building a multi-dimensional array here. If the data is _already_ in the right format you could
                // skip this loop...
                let row = [];

                row.push(item.myarea);
                row.push(item.AverageDelay);
                row.push(item.MaxDelay);
                row.push(item.MinDelay);
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
            ordering:false,    /*禁用排序功能*/
            /*bInfo: false,*/
            bLengthChange: false,    /*禁用Show entries*/
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
        let vm = this;
        /*********************************************/
        var area1 = {
            myarea: "新城区",
            AverageDelay: 18,
            MaxDelay: 21,
            MinDelay: 17,
            Loss: 0.03,
            Qoe: 98
        };
        var area2 = {
            myarea: "碑林区",
            AverageDelay: 19,
            MaxDelay: 23,
            MinDelay: 18,
            Loss: 0.02,
            Qoe: 96
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






