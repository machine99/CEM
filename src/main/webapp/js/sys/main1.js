/**
 * Created by yuanbaby on 2017/4/10.
 */
var options1 = {
    chart: {
        polar: true,
        type: 'line'
    },
    credits:{
        enabled:false // 禁用版权信息
    },
    title: {
        text: '各应用感知',
        x: -45
    },
    pane: {
        size: '80%'
    },
    xAxis: {
        categories: ['网页感知', '下载感知', '游戏感知', '网络链路',
            '视频感知'],
        tickmarkPlacement: 'on',
        lineWidth: 0
    },
    yAxis: {
        gridLineInterpolation: 'polygon',
        lineWidth: 0,
        min: 0
    },
    tooltip: {
        shared: true,
    },
    legend: {
        align: 'right',
        verticalAlign: 'top',
        y: 70,
        layout: 'vertical'
    },
    series: [{
        name: '闲时',
        data: [43000, 19000, 60000, 35000, 17000],
        pointPlacement: 'on'
    }, {
        name: '忙时',
        data: [50000, 39000, 42000, 31000, 26000],
        pointPlacement: 'on'
    }]
};


var options2 = {
    title : {
        text: '各应用网络QoE分析'
    },
    credits:{
        enabled:false // 禁用版权信息
    },
    xAxis : {
        categories: ['2016年10月', '2016年11月', '2016年12月', '2017年01月', '2017年02月', '2017年03月']
    },
    yAxis: {
        title: {
            text: '感知评分(QoE)'
        },
        min:60,
        max: 100

    },
    labels : {   /*标签项*/
        /*items: [{
         html: '水果消费',
         style: {
         left: '50px',
         top: '18px',
         color: (Highcharts.theme && Highcharts.theme.textColor) || 'black'
         }
         }]*/
    },
    series: [{
        type: 'column',
        name: '网页感知',
        data: [77, 74, 82, 77, 78, 77]
    }, {
        type: 'column',
        name: '视频感知',
        data: [78, 72, 77, 75, 74, 75]
    }, {
        type: 'column',
        name: 'Ping感知',
        data: [64, 63, 91, 62, 68, 72]
    },{
        type: 'column',
        name: '下载感知',
        data: [61, 65, 63, 78, 76, 80]
    }, {
        type: 'spline',
        name: '平均感知',
        data: [77, 73, 76, 68, 76, 78],
        marker: {
            lineWidth: 2,
            lineColor: Highcharts.getOptions().colors[3], /*可以直接填写线的颜色*/
            fillColor: 'white'  /*节点填充颜色*/
        }
    }
    ]
};

var option3 = {
    title: {
        text : '网内各地市平均感知统计'

    },
    tooltip: {   /*显示提示框组件*/
        trigger: 'item',  /*数据项图形触发*/
        formatter: '{b}<br/>{c} Q'
    },
    toolbox: {
        show: true,    /*显示工具栏组件*/
        orient: 'vertical',   /*工具栏 icon 的布局朝向。*/
        right:'20px',
        top: 'bottom',
        feature: {
            dataView: {readOnly: false},
            restore: {},
            saveAsImage: {}
        }
    },
    legend: {
        orient: 'vertical',
        x:'right',
        data:['QoE']
    },
    dataRange: {
        min: 0,
        max: 100,
        color:['#0973DE','#D8FAFE'],  /*颜色区间*/
        text:['高','低'],           // 文本，默认为数值文本
        calculable : true
    },
    series : [
        {
            name: 'QoE',
            type: 'map',
            mapType: '陕西',
            selectedMode : 'single',
            itemStyle:{
                normal:{label:{show:true}},
                emphasis:{label:{show:true}}
            },
            data:[
                {name: '榆林市',value: Math.round(Math.random()*100)},
                {name: '延安市',value: Math.round(Math.random()*100)},
                {name: '铜川市',value: Math.round(Math.random()*100)},
                {name: '宝鸡市',value: Math.round(Math.random()*100)},
                {name: '咸阳市',value: Math.round(Math.random()*100)},
                {name: '渭南市',value: Math.round(Math.random()*100)},
                {name: '西安市',value: Math.round(Math.random()*100)},
                {name: '汉中市',value: Math.round(Math.random()*100)},
                {name: '商洛市',value: Math.round(Math.random()*100)},
                {name: '安康市',value: Math.round(Math.random()*100)}
            ]
        }
    ]
};

var options4 ={
    chart : {
        type: 'column'
    },
    title : {
        text: 'TOP10门户感知排行'
    },
    credits : {
        enabled: false  /*禁用版权信息*/
    },
    xAxis : {
        categories: ['百度','腾讯','搜狐','新浪','163','凤凰网','新华网','中央网','和讯网','21cn'],
        crosshair: true   /*配置跟随鼠标或鼠标滑过点时的十字准星线*/
    },
    yAxis : {
        max: 100

    },
    tooltip : {
        /*数据提示框*/
        valueSuffix: 'Q'    /* y值后缀字符串*/
    },
    series: [{
        name: 'QOE',
        data: [81, 88, 78, 80, 85, 81, 88, 86, 79, 82]
    }]
};

var options5 ={
    chart : {
        type: 'column'
    },
    title : {
        text: '探针月感知趋势'
    },
    credits : {
        enabled: false  /*禁用版权信息*/
    },
    xAxis : {
        categories: ['2017-01','2017-02'],
        crosshair: true   /*配置跟随鼠标或鼠标滑过点时的十字准星线*/
    },
    yAxis : {
        max: 100

    },
    tooltip : {
        /*数据提示框*/
        valueSuffix: 'Q'    /* y值后缀字符串*/
    },
    series: [{
        name: 'QOE',
        data: [85, 88]
    }]
};




$(document).ready(function () {
    var chart1 = new Highcharts.Chart('container1', options1);
    var chart2 = new Highcharts.Chart('container2', options2);
    var myChart = echarts.init(document.getElementById('container3'));
    myChart.setOption(option3);
    window.onresize=myChart.resize;   /*echarts自适应窗口大小*/
    var chart4 = new Highcharts.Chart('container4', options4);
    var chart5 = new Highcharts.Chart('container5', options5);
});




new Vue({
    el: '#select_qoe',
    data: {
        selected: "平均QoE"    /*设置默认选中option*/
    },
    watch: {     /*观察者观察select的变化*/
        // 如果 select 发生改变，这个函数就会运行
        selected: function () {
            console.log(this.selected);
            this.selected_qoe();
        }
    },
    methods:{
        selected_qoe:function () {
            options5.series = [{
                name: this.selected,
                data: [80+10*Math.random(),80+10*Math.random()]
            }];
            var chart5 = new Highcharts.Chart('container5', options5);   /*重绘highcharts*/
        }
    }
});

new Vue({
    el: '#select_version',
    data: {
        selected: "硬件版"    /*设置默认选中option*/
    },
    watch: {     /*观察者观察select的变化*/
        // 如果 select 发生改变，这个函数就会运行
        selected: function () {
            console.log(this.selected);
            this.selected_qoe();
        }
    },
    methods:{
        selected_qoe:function () {
            options5.series = [{
                name: this.selected,
                data: [80+10*Math.random(),80+10*Math.random()]
            }];
            var chart5 = new Highcharts.Chart('container5', options5);   /*重绘highcharts*/
        }
    }
});

