/**
 * Created by yuanbaby on 2017/4/25.
 */
// 注册
var probetable = new Vue({
    el: '#probedata_table',
    data:{
        headers: [
            {title: ''},
            {title: '<div class="checkbox"> <label> <input type="checkbox" id="checkAll"></label> </div>'},
            {title: '<div style="display:none">id</div>'},
            {title: '<div style="width:142px">组名</div>'},
            {title: '<div style="width:142px">描述</div>'},
            {title: '<div style="width:52px">操作</div>'}
        ],
        rows: [],
        dtHandle: null,

    },
    /*watch: {
     users(val, oldVal) {


     }
     },*/
    methods: {
        reset: function () {
            let vm = this;
            vm.probedata = {};/*清空probedata*/
            vm.dtHandle.clear();
            console.log("重置");
            vm.dtHandle.draw();    /*重置*/
        },
        currReset:function () {
            let vm = this;
            vm.dtHandle.clear();
            console.log("当前页面重绘");
            vm.dtHandle.draw(false);    /*当前页面重绘*/
        },
        redraw:function () {
            let vm = this;
            vm.dtHandle.clear();
            console.log("页面重绘");
            vm.dtHandle.draw();    /*重绘*/
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
            paging: true,
            serverSide: true,
            info: false,
            ordering: false, /*禁用排序功能*/
            /*bInfo: false,*/

            /*bLengthChange: false,*/    /*禁用Show entries*/
            /*scrollY: 432,    /!*表格高度固定*!/*/
            oLanguage: {
                sLengthMenu: "每页 _MENU_ 行数据",
                oPaginate: {
                    sNext: '<i class="fa fa-chevron-right" ></i>',  /*图标替换上一页,下一页*/
                    sPrevious: '<i class="fa fa-chevron-left" ></i>'
                }
            },
            sDom: 'Rfrtlip',  /*显示在左下角*/
            ajax: function (data, callback, settings) {
                //封装请求参数
                let param = {};
                param.limit = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
                param.start = data.start;//开始的记录序号
                param.page = (data.start / data.length) + 1;//当前页码
                console.log(param);
                //ajax请求数据
                $.ajax({
                    type: "POST",   /*GET会乱码*/
                    url: "../testgroup/list",
                    cache: false,  //禁用缓存
                    data: param,  //传入组装的参数
                    dataType: "json",
                    success: function (result) {
                        console.log(result);

                        //封装返回数据
                        let returnData = {};
                        returnData.draw = data.draw;//这里直接自行返回了draw计数器,应该由后台返回
                        returnData.recordsTotal = result.page.totalCount;//返回数据全部记录
                        returnData.recordsFiltered = result.page.totalCount;//后台不实现过滤功能，每次查询均视作全部结果
                        // returnData.data = result.page.list;//返回的数据列表
                        // 重新整理返回数据以匹配表格
                        let rows = [];
                        var i = param.start+1;
                        result.page.list.forEach(function (item) {
                            let row = [];
                            row.push(i++);
                            row.push('<div class="checkbox"> <label> <input type="checkbox" name="selectFlag"></label> </div>');
                            row.push('<div class="probe_id">'+item.id+'</div>');
                            row.push(item.name);
                            row.push(item.more);
                            row.push('<a class="fontcolor" onclick="delete_this(this)" id='+item.id+'>删除</a>');
                            rows.push(row);
                        });
                        returnData.data = rows;
                        console.log(returnData);
                        //调用DataTables提供的callback方法，代表数据已封装完成并传回DataTables进行渲染
                        //此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
                        callback(returnData);
                    }
                });
            }
        });
        new AjaxUpload('#excel_import', {
            action: '../sys/upload/upload',
            name: 'file',
            autoSubmit: true,
            responseType: "json",
            onSubmit: function (file, extension) {
                if (!(extension && /^(xls|xlsx)$/.test(extension.toLowerCase()))) {
                    alert('请上传xls或xlsx格式的Excel文件！');
                    return false;
                }
            },
            onComplete: function (file, r) {
                if (r.code == 0) {
                    alert(r.msg);
                } else {
                    alert(r.msg);
                }
            }
        });
    }
});