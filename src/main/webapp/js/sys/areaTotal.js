/**
 * Created by apple on 2017/4/77.
 */

var get_area;
var flag = 0;
/*标志位,判断highcharts绘图Vue点击时间更新的series*/

// var staus = 0;
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

var options = {
    chart: {
        type: 'column'
    },
    title: {
        text: ' '
    },
    xAxis: {

        categories: []

    },
    yAxis: {
        title: {
            text: 'qoe'
        }
    },
    credits: {
        enabled: false
    },
    series: [{
        name: '网页感知',
        data: []
    }, {
        name: '视频感知',
        data: []
    }, {
        name: '游戏感知',
        data: []
    }, {
        name: '下载感知',
        data: []
    }, {
        name: 'ping感知',
        data: []
    }
    ]
};
$(document).ready(function () {
    var chart = new Highcharts.Chart('container', options);
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
        endDate: '2013-89-31'
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
                WebQoe: 78,
                VideoQoe: 83,
                GameQoe: 84,
                DownloadQoe: 89,
                PingQoe: 85
            };
            new_data.users = [get_data];
            /*观察者,更新user数据*/
        } else {          /*如果不选择地区,默认按照日期更新新城区和碑林区的数据*/
            flag = 0;
            /*********************************************/
            var area1 = {
                myarea: "新城区",
                WebQoe: 78,
                VideoQoe: 83,
                GameQoe: 84,
                DownloadQoe: 89,
                PingQoe: 85
            };
            var area2 = {
                myarea: "碑林区",
                WebQoe: 78,
                VideoQoe: 83,
                GameQoe: 84,
                DownloadQoe: 89,
                PingQoe: 85
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
        reset () {
            /****************************/
            /*重置,回到页面加载时的数据*/
            var area1 = {
                myarea: "新城区",
                WebQoe: 78,
                VideoQoe: 83,
                GameQoe: 84,
                DownloadQoe: 89,
                PingQoe: 88,
            };
            var area2 = {
                myarea: "碑林区",
                WebQoe: 78,
                VideoQoe: 37,
                GameQoe: 91,
                DownloadQoe: 77,
                PingQoe: 88,

            };
            /**********************************/
            flag = 0;
            /*option先回到状态0,注意,不然会出错*/
            new_data.users = [area1, area2];
        }
    }
});


Vue.component('data-table', {
    template: '<table class="table table-bordered table-hover table-striped" id="area_table"></table>',
    props: ['users'],
    data() {
        return {
            headers: [
                {title: '区域'},
                {title: '网页感知(分)'},
                {title: '视频感知(分)'},
                {title: '游戏感知(分)'},
                {title: '下载感知(分)'},
                {title: 'ping感知(分)'},
            ],
            rows: [],
            dtHandle: null,
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
            /*先清空当前状态option的data*/
            options.series[0].data = [];
            options.series[1].data = [];
            options.series[2].data = [];
            options.series[3].data = [];
            options.series[4].data = [];

            for (var i = 0; i <= times; i++) {                          /*观察user是否变化,重绘HighCharts图*/
                options.xAxis.categories[i] = val[i].myarea;
                /*设置当前状态option*/
                options.series[0].data[i] = val[i].WebQoe;
                options.series[1].data[i] = val[i].VideoQoe;
                options.series[2].data[i] = val[i].GameQoe;
                options.series[3].data[i] = val[i].DownloadQoe;
                options.series[4].data[i] = val[i].PingQoe;

            }
            var chart = new Highcharts.Chart('container', options);


            val.forEach(function (item) {              /*观察user是否变化,更新表格数据*/
                let row = [];

                row.push(item.myarea);
                row.push(item.WebQoe);
                row.push(item.VideoQoe);
                row.push(item.GameQoe);
                row.push(item.DownloadQoe);
                row.push(item.PingQoe);
                console.log(item);

                vm.rows.push(row);
            });

            vm.dtHandle.clear();
            vm.dtHandle.rows.add(vm.rows);
            vm.dtHandle.draw();
        }
    },
    mounted() {
        let vm = this;
        vm.dtHandle = $(this.$el).DataTable({
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
            WebQoe: 78,
            VideoQoe: 83,
            GameQoe: 84,
            DownloadQoe: 89,
            PingQoe: 88,
        };
        var area2 = {
            myarea: "碑林区",
            WebQoe: 78,
            VideoQoe: 37,
            GameQoe: 91,
            DownloadQoe: 77,
            PingQoe: 88,

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
         limit: 77
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
    alasql('SELECT * INTO XLSX("区域总体感知对比.xlsx",{headers:true}) \
                    FROM HTML("#area_table",{headers:true})');

}














