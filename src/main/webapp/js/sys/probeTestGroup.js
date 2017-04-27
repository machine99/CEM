/**
 * Created by yuanbaby on 2017/4/25.
 */

var status;
var idArray = new Array();

/*各种监听事件*/
var probedata_handle = new Vue({
    el: '#handle',
    data: {},
    methods: {
        testagentadd: function () {   /*监听录入触发事件*/
            status = 0;/*状态0,表示录入*/
            var forms = $('#probeform_data .form-control');

            $('#probeform_data input[type=text]').prop("readonly", false);
            /*去除只读状态*/
            $('#probeform_data select').prop("disabled", false);

            for (var i = 0; i < 3; i++) {
                forms[i].value = ""
            }
            probeform_data.modaltitle = "测试任务组录入";
            /*修改模态框标题*/
            $('#myModal').modal('show');

        },
        testagentupdate: function () {     /*监听编辑触发事件*/
            status = 1;/*状态1表示编辑*/
            var trs = $('#probe_table tbody').find('tr:has(:checked)');
            /*find被选中的行*/
            var forms = $('#probeform_data .form-control');
            console.log(trs.length + "表单对象:" + forms.length);

            $('#probeform_data input[type=text]').prop("readonly", false);
            /*去除只读状态*/
            $('#probeform_data select').prop("disabled", false);

            if (trs.length == 0) {
                toastr.warning('请选择编辑项目！');
            } else if (trs.length == 1) {
                var tds = trs.find("td");
                for (var i = 0; i < 3; i++) {                /*tds.eq(0).text()取得td的值,注意tds[0].text()取不到*/
                    console.log(tds.eq(i + 3).text());
                    forms[i].value = tds.eq(i + 2).text();         /*给表单赋值,注意,把id值也赋值,不然后台找不到对应id*/
                }
                probeform_data.modaltitle = "测试任务组编辑";
                /*修改模态框标题*/
                $('#myModal').modal('show');
            } else {
                toastr.warning('请选择一条记录再编辑！');
            }
        },
        testagentdelBatch: function () {   /*批量删除监听事件*/
            status = 2;/*状态2表示删除*/
            var trs = $('#probe_table tbody').find('tr:has(:checked)');
            if (trs.length == 0) {
                toastr.warning('请选择删除项目！');
            }else {
                for(var i=0;i<trs.length;i++){       /*取得选中行的id*/
                    var tds = trs.eq(i).find("td");
                    idArray[i] = parseInt(tds.eq(2).text());   /*将id加入数组中*/
                    console.log(tds.eq(2).text())
                }
                delete_ajax() ; /*ajax传输*/

            }
            /*find被选中的行*/

        },
        testagentview: function () {     /*查看监听事件*/
            var trs = $('#probe_table tbody').find('tr:has(:checked)');
            /*find被选中的行*/
            var forms = $('#probeform_data .form-control');
            if (trs.length == 0) {
                toastr.warning('请选择查看项目！');
            } else if (trs.length == 1) {
                var tds = trs.find("td");
                for (var i = 0; i < 3; i++) {                /*tds.eq(0).text()取得td的值,注意tds[0].text()取不到*/
                    console.log(tds.eq(i + 2).text());
                    forms[i].value = tds.eq(i + 2).text()
                }
                $('#probeform_data input[type=text]').prop("readonly", true);//将input元素设置为readonly
                $('#probeform_data select').prop("disabled", true);//将select元素设置为不可变

                probeform_data.modaltitle = "查看";
                /*修改模态框标题*/
                $('#myModal').modal('show');
            } else {
                toastr.warning('请选择一条记录再查看！');
            }
        }

    }
});
/*删除ajax*/
function delete_ajax() {
    var ids = JSON.stringify(idArray);    /*对象数组字符串*/

    $.ajax({
        type: "POST",   /*GET会乱码*/
        url: "../testgroup/delete",
        cache: false,  //禁用缓存
        data: ids,  //传入组装的参数
        dataType: "json",
        contentType:"application/json",  /*必须要,不可少*/
        success: function (result) {
            console.log("传递成功");

            toastr.success("业务信息删除成功!");

            probetable.currReset();

            idArray = [];  /*清空id数组*/
            delete_data.close_modal();  /*关闭模态框*/
        }
    });
}
/*获取当前行探针数据id*/
function delete_this(obj) {
    delete_data.show_deleteModal();
    delete_data.id = parseInt(obj.id);   /*获取当前行探针数据id*/
    console.log(delete_data.id);
}
/*删除确认模态框*/
var delete_data = new Vue({
    el:'#myModal_delete',
    data:{
        id:null
    },
    methods:{
        show_deleteModal:function () {
            $(this.$el).modal('show');   /*弹出确认模态框*/
        },
        close_modal:function (obj) {
            $(this.$el).modal('hide');

        },
        cancel_delete:function () {

        },
        delete_data:function () {
            idArray = [];  /*清空id数组*/
            idArray[0] = this.id;
            delete_ajax() ;/*ajax传输*/

        }
    }
});
/*模态框数据提交*/
var probeform_data = new Vue({
    el: '#myModal',
    data: {
        modaltitle: "测试机管理录入", /*定义模态框标题*/
    },
    // 在 `methods` 对象中定义方法
    methods: {
        submit: function () {
            var testagentJson = getFormJson($('#probeform_data'));
            if(typeof(testagentJson["name"])=="undefined"){                  /*3个select必选*/
                toastr.warning("请录入组名!");
            }else {
                var testagent = JSON.stringify(testagentJson);  /*封装成json数组*/
                /*获取表单元素的值*/
                console.log(testagent);
                var mapstr;
                if(status==0){
                    mapstr = "save";
                }else if(status==1){
                    mapstr = "update"
                }
                $.ajax({
                    type: "POST",   /*GET会乱码*/
                    url: "../testgroup/"+mapstr,
                    cache: false,  //禁用缓存
                    data: testagent,  //传入组装的参数
                    dataType: "json",
                    contentType:"application/json",  /*必须要,不可少*/
                    success: function (result) {
                        console.log("传递成功");
                        if(status==0){
                            toastr.success("业务信息录入成功!");
                        }else if(status==1){
                            toastr.success("业务信息更新成功!");
                        }

                        probetable.currReset();
                    }
                });
            }


        }
    }
});
/*表单数据转换为json对象*/
function getFormJson(form) {      /*将表单对象变为json对象*/
    var o = {};
    var a = $(form).serializeArray();
    $.each(a, function () {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
}
/*选中表格事件*/
$(document).ready(function () {
    $('#probe_table tbody').on('click', 'tr', function () {   /*表格某一行选中状态*/
        if ($(this).hasClass('selected')) {
            $(this).removeClass('selected');
            $(this).find("input:checkbox").prop("checked", false);
            /*prop可以,attr会出错*/
        }
        else {
            /*vm.dtHandle.$('tr.selected').removeClass('selected');*/
            /*只能选中一行*/
            $(this).addClass('selected');
            $(this).find("input:checkbox").prop("checked", true);
        }
    });

    $('#checkAll').on('click', function () {
        if (this.checked) {
            $("input[name='selectFlag']:checkbox").each(function () { //遍历所有的name为selectFlag的 checkbox
                $(this).prop("checked", true);
                $(this).closest('tr').addClass('selected');
                /*取得最近的tr元素*/
            })
        } else {   //反之 取消全选
            $("input[name='selectFlag']:checkbox").each(function () { //遍历所有的name为selectFlag的 checkbox
                $(this).prop("checked", false);
                $(this).closest('tr').removeClass('selected');
                /*取得最近的tr元素*/

            })
        }
    })

});
/*注册模态框表格*/
var targetgroup_table = new Vue({
    el: '#target_group_table',
    data:{
        header:[
            {title: '<div style="white-space:nowrap;width:50px;">序号</div>'},
            {title: '<div style="white-space:nowrap;width:50px;">操作</div>'},
            {title: '<div>目标id</div>'},
            {title: '<div>分组id</div>'}
        ],
        rows: [],
        dtHandle: null,
        targetlist:[],
        grouplist:[],
        target_flag : 0,
        group_flag : 0
    },
    methods:{
        gettargetlist:function () {
            $.ajax({
                type: "POST",   /*GET会乱码*/
                url: "../testtarget/alllist",
                cache: false,  //禁用缓存
                dataType: "json",
                /*contentType:"application/json",  /!*必须要,不可少*!/*/
                success: function (result) {
                    this.targetlist = result.testtargetallList;
                    this.target_flag = 1;


                }
            });
        },
        getgrouplist:function () {
            $.ajax({
                type: "POST",   /*GET会乱码*/
                url: "../testgroup/alllist",
                cache: false,  //禁用缓存
                dataType: "json",
                /*contentType:"application/json",  /!*必须要,不可少*!/*/
                success: function (result) {
                    this.grouplist = result.testgroupallList;
                    this.group_flag = 1;


                }
            });
        }
    },
    mounted() {
        this.gettargetlist();
        this.getgrouplist();
    }
});
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