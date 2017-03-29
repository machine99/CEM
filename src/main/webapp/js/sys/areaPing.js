/**
 * Created by yuanbaby on 2017/3/29.
 */
var get_area;
var flag = 0;    /*标志位,判断highcharts绘图Vue点击时间更新的series*/

$(document).on("click", ".dropdown-menu li a", function () {
    get_area = $(this).text().trim();    /*trim()去除空格*/
    /*获取下拉值*/
    $('#area').val(get_area);
    /*区域选择框赋值*/
    console.log(get_area);
});



var area_choose = new Vue({
    el:'#area_choose',
    data:{
        items : [
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
var new_data1=['新城区','碑林区','莲湖区','雁塔区','未央区','灞桥区','长安区','阎良区']
$('#area').typeahead({     /*输入提示框*/
    source:new_data1,
    items:7        /*下拉菜单中显示的最大的条目数。*/
})

var json = {};
var options = {
    chart :{
        type: 'column'
    },
    title : {
        text: 'ping时延对比'
    },
    xAxis : {
        categories: ['新城区', '碑林区']
    },
    yAxis : {
        title: {
            text: '结果(ms)'
        }
    },
    credits : {
        enabled: false
    },
    series : [{
        name: '平均时延',
        data: [18,19]
    }, {
        name: '最大时延',
        data: [21,23]
    }, {
        name: '最小时延',
        data: [17,18]
    }
    ]
};
$(document).ready(function () {
    var chart = new Highcharts.Chart('container',options)
});


$('input[name="daterange"]').daterangepicker(
    {
        locale: {
            format: 'YYYY-MM-DD'
        },
        startDate: '2013-01-01',
        endDate: '2013-12-31'
    },
    function (start, end, label) {          /*日期选择触发事件*/
        console.log("A new date range was chosen: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
        flag = 1;  /*改变标志位*/
        var get_data = {             /*模拟异步数据*/
            AverageDelay : 18,
            MaxDelay : 22,
            MinDelay : 17,
            Loss : 0.5,
            Qoe : 98
        };
        options.xAxis = {
            categories: [get_area]    /*图表中更改地区信息*/  /*[]必须要，不然出错*/
        };
        options.series = [{
            name: '平均时延',
            data: [get_data.AverageDelay]      /*[]必须要，不然出错*/
        }, {
            name: '最大时延',
            data: [get_data.MaxDelay]
        }, {
            name: '最小时延',
            data: [get_data.MinDelay]
        }
        ];
        var chart = new Highcharts.Chart('container',options);        /*重新绘制图表*/

        new_series_delay = [{
            name: '平均时延',
            data: [get_data.AverageDelay]      /*[]必须要，不然出错*/
        }, {
            name: '最大时延',
            data: [get_data.MaxDelay]
        }, {
            name: '最小时延',
            data: [get_data.MinDelay]
        }
        ];

        new_series_loss = [{
            name: '丢包',
            data: [get_data.Loss]
        }
        ];

        new_series_qoe = [{
            name: 'qoe',
            data: [get_data.Qoe]
        }
        ]

    });
/*$('#datepicker').datetimepicker({
 minView: "month", //选择日期后，不会再跳转去选择时分秒
 format: "yyyy-mm-dd", //选择日期后，文本框显示的日期格式
 language: 'zh-CN', //汉化
 autoclose:true //选择日期后自动关闭
 });*/

var button_change = new Vue({     /*实例化Vue*/
    el:'#charts_button',
    data: {
        option_delay:{   /*设置时延option*/
            title : {
                text: 'ping时延对比'
            },
            series_delay :[{
                name: '平均时延',
                data: [18,19]
            }, {
                name: '最大时延',
                data: [21,23]
            }, {
                name: '最小时延',
                data: [17,18]
            }
            ],
            yAxis : {
                title: {
                    text: '结果(ms)'
                }
            }
        },
        option_qoe:{     /*设置qoe option*/
            title : {
                text: 'qoe对比'
            },
            series_qoe :[{
                name: 'qoe',
                data: [93,96]
            }
            ],
            yAxis : {
                title: {
                    text: '结果(分)'
                },
                max:100
            }
        },
        option_loss:{    /*设置丢包option*/
            title : {
                text: '丢包率'
            },
            series_loss :[{
                name: '丢包',
                data: [0.03,0.01]
            }
            ],
            yAxis : {
                title: {
                    text: '结果(%)'
                },
                max:100
            },
            tooltip: {     /*数据提示框*/
                valueSuffix: '%'    /* y值后缀字符串*/
            }
        }



    },
    // 在 `methods` 对象中定义方法
    methods: {                        /*事件监听*/
        delay:function () {
            console.log("时延");
            options.title = this.option_delay.title;            /*设置标题*/
            if(flag==0){
                options.series = this.option_delay.series_delay;    /*设置数据*/
            }else {
                options.series = new_series_delay;                  /*series*/
            }
            options.yAxis = this.option_delay.yAxis;           /*设置y轴*/
            options.tooltip = {};                              /*设置数据提示框*/
            var chart = new Highcharts.Chart('container',options)    /*重新绘图*/
        },
        loss:function () {
            console.log("丢包");
            options.title = this.option_loss.title;
            if(flag==0) {
                options.series = this.option_loss.series_loss;
            }else {
                options.series = new_series_loss
            }
            options.yAxis = this.option_loss.yAxis;
            options.tooltip = this.option_loss.tooltip;
            var chart = new Highcharts.Chart('container',options)
        },
        qoe: function () {
            console.log("qoe");
            options.title = this.option_qoe.title;
            if(flag==0) {
                options.series = this.option_qoe.series_qoe;
            }else {
                options.series = new_series_qoe
            }
            options.yAxis = this.option_qoe.yAxis;
            options.tooltip = {};
            var chart = new Highcharts.Chart('container',options)
        }
    }
});


