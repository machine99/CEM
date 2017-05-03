/**
 * Created by yuanbaby on 2017/5/2.
 */
var starttime;
var endtime;

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
        starttime = start.format('YYYY-MM-DD HH:mm:ss');
        endtime = end.format('YYYY-MM-DD HH:mm:ss');

    });

var new_search = new Vue({        /*监听查询事件*/
    el:'#search',
    methods:{
        search:function () {
            console.log("你选择了时间区间"+starttime+"to"+endtime);
            var postdata = {};
            postdata.starttime = starttime;
            postdata.endtime = endtime;
            $.ajax({                           /*后台取得数据,赋值给观察者*/
                type: "POST",
                url: "../resulthttptest/weblist",
                cache: false,  //禁用缓存
                data: postdata,  //传入组装的参数
                dataType: "json",
                success: function (result) {
                    console.log(result);
                    new_data.users = result.resultHttpwebtestList;
                }
            });

        }
    }
});

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

var Reset = new Vue({               /*重置,默认时间区间为最近4天*/
    el: '#reset',
    methods: {
        reset: function () {
            /****************************/
            /*重置,回到页面加载时的数据*/
            /**********************************/
            var postdata = {};
            postdata.starttime = new Date(new Date() - 1000 * 60*60*24*4).Format("yyyy-MM-dd")+" 00:00:00"; /*前4天日期*/
            postdata.endtime = (new Date()).Format("yyyy-MM-dd")+" 23:59:59";  /*当前日期*/
            console.log(postdata);
            $.ajax({                           /*后台取得数据,赋值给观察者*/
                type: "POST",
                url: "../resulthttptest/weblist",
                cache: false,  //禁用缓存
                data: postdata,  //传入组装的参数
                dataType: "json",
                success: function (result) {
                    console.log(result);
                    new_data.users = result.resultHttpwebtestList;
                }
            });
        }
    }
});

/************表格部分*************/

Vue.component('data-table', {
    template: '<table class="table table-striped table-bordered table-hover scrolltable" id="webCount_table" style="width: 1000px;"></table>',
    props: ['users'],
    data() {
        return {
            headers: [
                {title: ''},
                {title: '门户网站'},
                {title: 'qoe(分)'},
                {title: '下载速率(Mbps)'},
                {title: 'DNS时延(ms)'},
                {title: '连接时延(ms)'},
                {title: '响应时延(ms)'},
                {title: '下载时延(ms)'}
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
                row.push(item.destname);
                row.push(item.qoe);
                row.push(item.speed);
                row.push(item.dnsdelay);
                row.push(item.connectdelay);
                row.push(item.responsedelay);
                row.push(item.downloaddelay);

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

            scrollY: '450px',   /*表格内容滚动*/
            scrollCollapse: true,
            columnDefs: [
                //给第一列指定宽度为表格整个宽度的 20px
                { "width": "20px", "targets": 0 },
            ]

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

        Reset.reset();        /*调用reset,即为页面加载状态*/
    }
});

/*导出表格到excel*/
function exportExcel() {
    alasql('SELECT * INTO XLSX("网页门户指标统计.xlsx",{headers:true}) \
                    FROM HTML("#webCount_table",{headers:true})');

}