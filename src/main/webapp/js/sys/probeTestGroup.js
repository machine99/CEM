/**
 * Created by yuanbaby on 2017/4/25.
 */

var status;
var group_id;
var idArray = new Array();
var target_groupidArray = new Array();
var testGroupNames = new Array();
var aliasNames = new Array();
var targetidBygroupid = new Array();
var targetGroupId = new Array();
var targetAdd = new Array();
var targetUpdate = new Array();
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
            probeform_data.users = 1; //相关测试目标表格归一
            $('#probetesttarget_title').hide();//隐藏相关测试目标表格
            $('#handle_button').hide(); //隐藏相关测试目标表格
            $('#tabledemo').hide();     //隐藏相关测试目标表格
            $('#myModal').modal('show');

        },
        testagentupdate: function () {     /*监听编辑触发事件*/
            status = 1;/*状态1表示编辑*/
            $('#probetesttarget_title').show();//显示相关测试目标表格
            $('#handle_button').show(); //显示相关测试目标表格
            $('#tabledemo').show();     //显示相关测试目标表格

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
                group_id = tds.eq(2).text();
                this.gettarget_group(group_id);  /*搜索中间表中对应group_id的内容*/
                $('.alias_namesselector').prop("disabled", true);//将select元素设置为不可变,

                $('.checkboxable').prop("disabled", false);  //单选框可选  // 此处还是必须的,如果user没用变,放在draw后面的readOnly就不会执行,也就不会改变这个状态
                $('#handle_button button').prop("disabled", false);  //添加删除按钮可用
                probeform_data.modaltitle = "测试任务组编辑";
                /*修改模态框标题*/
                $('#myModal').modal('show');
            } else {
                toastr.warning('请选择一条记录再编辑！');
            }
        },
        testagentdelBatch: function () {   /*批量删除监听事件*/
            status = 2;/*状态2表示测试任务组删除*/
            idArray = [];  /*删除前先清空id数组*/
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
            status = 3;/*状态3表示查看*/
            $('#probetesttarget_title').show();//显示相关测试目标表格
            $('#handle_button').show(); //显示相关测试目标表格
            $('#tabledemo').show();     //显示相关测试目标表格

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

                group_id = tds.eq(2).text();
                this.gettarget_group(group_id);  /*搜索中间表中对应group_id的内容*/
                $('.alias_namesselector').prop("disabled", true);//将select元素设置为不可变
                $('.checkboxable').prop("disabled", true);  //单选框不可选
                $('#handle_button button').prop("disabled", true);  //添加删除按钮不可用

                probeform_data.modaltitle = "查看";
                /*修改模态框标题*/
                $('#myModal').modal('show');
            } else {
                toastr.warning('请选择一条记录再查看！');
            }
        },
        gettarget_group:function (group_id) {  /*获取中间表信息*/
            targetGroupId = [];   //调用前清空该数组
            let param = {};
            param.group_id = group_id;
            $.ajax({
                type: "POST",   /*GET会乱码*/
                url: "../targetgroup/list",
                cache: false,  //禁用缓存
                data: param,  //传入组装的参数
                dataType: "json",
                /* contentType:"application/json",  /!*必须要,不可少*!/*/
                success: function (result) {
                   console.log(result);
                    for(var i=0;i<result.page.list.length;i++){     /*观察者,获取中间表id*/
                        targetGroupId[i] =  result.page.list[i].id
                    }
                    probeform_data.users = targetGroupId;
                    targetidBygroupid = result.page.list;

                }
            });
        },
        readOnly:function (group_id) {
            $(".testgroup_namesselector").val(group_id);
            $('.testgroup_namesselector').prop("disabled", true);//将select元素设置为不可变


            var trs = $("#myModal table").find("tr");
            if(targetidBygroupid.length!=0){
            for(var i=0;i<targetidBygroupid.length;i++){
                var tds = trs.eq(i).find("td");
                tds.eq(3).find("select").val(targetidBygroupid[i].targetId); //获取targetId并赋id对应的值
            }
            console.log("状态:"+status);
            $('.alias_namesselector').prop("disabled", true);//将select元素设置为不可变,
            if(status==3){   //判断是否为查看
                $('.checkboxable').prop("disabled", true);  //单选框不可选
                $('#handle_button button').prop("disabled", true);  //添加删除按钮不可用
            }else {
                $('.checkboxable').prop("disabled", false);  //单选框可选
                $('#handle_button button').prop("disabled", false);  //添加删除按钮可用
            }
            }else {
                console.log("错误,数组没值!");   /*这个执行先后问题先这么着吧,不知道怎么解决*/
            }
        }

    },
    mounted(){         /*动态加载测试任务组数据*/
        $.ajax({
            type: "POST",   /*GET会乱码*/
            url: "../testgroup/list",
            cache: false,  //禁用缓存
            dataType: "json",
            /* contentType:"application/json",  /!*必须要,不可少*!/*/
            success: function (result) {
                for(var i=0;i<result.page.list.length;i++){
                    testGroupNames[i] = {id: result.page.list[i].id,name:result.page.list[i].name}
                }
                probeform_data.testgroup_names = testGroupNames;
            }
        });
        $.ajax({
            type: "POST",   /*GET会乱码*/
            url: "../testtarget/list",
            cache: false,  //禁用缓存
            dataType: "json",
            /* contentType:"application/json",  /!*必须要,不可少*!/*/
            success: function (result) {
                for(var i=0;i<result.page.list.length;i++){
                    aliasNames[i] = {id: result.page.list[i].id,alias:result.page.list[i].alias}
                }
                probeform_data.alias_names = aliasNames;
            }
        });
    },
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
Vue.component('data-table', {
    template: '<table class="table table-bordered" id="target_table"></table>',
    props: ['users'],
    data() {
        return {
            headers: [
                {title: '<div style="white-space:nowrap;width:50px">序号</div>'},
                {title: '<div style="white-space:nowrap;width:50px">操作</div>'},
                {title: '<div style="display:none">id</div>'},
                {title: '<div style="white-space:nowrap;width:270px">目标id</div>'},
                {title: '<div style="white-space:nowrap;width:270px">分组id</div>'},
            ],
            rows: [],
            dtHandle: null,
        }
    },
    watch: {
        users(val, oldVal) {
            let vm = this;
            vm.rows = [];
            if(val[1].length!=0&&val[2].length!=0){
            var aliasnamesoptionstring = "";
            var testgroupnamesoptionstring = "";
            for (var j = 0; j < val[1].length; j++) {
                aliasnamesoptionstring += "<option value=" + val[1][j].id + ">" + val[1][j].alias + "</option>";
            }
            for (var k = 0; k < val[2].length; k++) {
                testgroupnamesoptionstring += "<option value=" + val[2][k].id + ">" + val[2][k].name + "</option>";
            }
            var i = 1;
            // You should _probably_ check that this is changed data... but we'll skip that for this example.
                val[0].forEach(function (item) {              /*观察user是否变化,更新表格数据*/
                // Fish out the specific column data for each item in your data set and push it to the appropriate place.
                // Basically we're just building a multi-dimensional array here. If the data is _already_ in the right format you could
                // skip this loop...
                let row = [];
                row.push(i++);
                row.push('<div class="checkbox"> <label> <input type="checkbox" class="checkboxable" name="selectFlag"></label> </div>');
                row.push('<div class="probe_id">'+item+'</div>');
                row.push('<select class="form-control alias_namesselector" name="alias_names" style="width: 265px">'+aliasnamesoptionstring+'</select>');
                row.push('<select class="form-control testgroup_namesselector" name="testgroup_names" style="width: 265px">'+testgroupnamesoptionstring+'</select>');
                /*console.log(item);*/

                vm.rows.push(row);
            });

            // Here's the magic to keeping the DataTable in sync.
            // It must be cleared, new rows added, then redrawn!
            vm.dtHandle.clear();
            vm.dtHandle.rows.add(vm.rows);
            vm.dtHandle.draw();
                probedata_handle.readOnly(group_id);  /*！！！重要,改变这个状态只有在表格draw之后才有效果*/
                probeform_data.targetadd_selectable(); /*！！！重要,改变这个状态只有在表格draw之后才有效果*/
            }else {
                console.log("数据延误！")
            }
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
            scrollY: '300px',   /*表格内容滚动*/
            scrollCollapse: true,

            bLengthChange: false,    /*禁用Show entries*/
        });


    }
});
/*模态框数据提交*/
var probeform_data = new Vue({
    el: '#myModal',
    data: {
        modaltitle: "测试机管理录入", /*定义模态框标题*/
        users: [],  //存中间表id
        search: '',
        testgroup_names: [],
        alias_names:[],
        updateflag:0,
        trs:[],
        targetaddtrs:[]

    },
    computed: {
        filteredUsers: function () {                 /*此处可以对传入数据进行处理*/
            let self = this;
            return [self.users,self.alias_names,self.testgroup_names];
            /*let search = self.search.toLowerCase();
             return self.users.filter(function (user) {
             return user.username.toLowerCase().indexOf(search) !== -1 ||
             user.email.toLowerCase().indexOf(search) !== -1 ||
             user.mobile.indexOf(search) !== -1
             })*/
        }
    },
    mounted() {
         this.users = [0];  //随便赋一值
    },
    // 在 `methods` 对象中定义方法
    methods: {
        targetadd:function () {
            this.targetaddtrs = [];     //tr数组先清空
            targetAdd = []; //删除前,先清空相关数组
            this.users.push(0); //末尾添加一个0元素,赋值观察者增添一行
            $('#targetaddaffirm').css("display","block");  //确认添加弹出
        },
        targetadd_selectable:function () {
            var index=$.inArray(0,this.users); //第一个0所在索引位置
            if(index!=-1){  //如果不包含0,即没有点击增加来新增加tr
                console.log(index+":"+this.users.length);
                for(var i=index;i<this.users.length+1;i++){
                var newtr = $("#myModal table").find("tr").eq(i+2);
                newtr.click();
                }
                $('.selected .alias_namesselector').prop("disabled", false);//将选中编辑元素设置为可变,
            }
        },
        targetupdate:function () {
            this.trs = [];     //tr数组先清空
            targetUpdate = []; //删除前,先清空相关数组
            this.trs = $("#myModal table").find("tr").filter('.selected');
            if (this.trs.length == 0) {
                toastr.warning('请选择相关目标编辑项目！');
            }else {
                $('#targetupdateaffirm').css("display","block");
                $('.selected .alias_namesselector').prop("disabled", false);//将选中编辑元素设置为可变,
                this.updateflag = 1; //flag为1表示要修改
            }
        },
        targetaddaffirm:function () {
            this.targetaddtrs = $("#myModal table").find("tr").filter('.selected');
            for(var i=0;i<this.targetaddtrs.length;i++){       /*取得选中编辑行的entity对象数组*/
                var tds = this.targetaddtrs.eq(i).find("td");
                targetAdd[i] = {id:tds.eq(2).text(),targetId:tds.eq(3).find('select').val(),groupId:tds.eq(4).find('select').val()};
            }
            console.log(targetAdd);
            this.targetadd_ajax();
            $('#targetaddaffirm').css("display","none");//隐藏按钮
        },
        targetupdateaffirm:function () {
            if(this.updateflag==1){
                for(var i=0;i<this.trs.length;i++){       /*取得选中编辑行的entity对象数组*/
                    var tds = this.trs.eq(i).find("td");
                    targetUpdate[i] = {id:tds.eq(2).text(),targetId:tds.eq(3).find('select').val(),groupId:tds.eq(4).find('select').val()};
                }
                console.log(targetUpdate);
                this.targetupdate_ajax();
                $('#targetupdateaffirm').css("display","none");//隐藏按钮
                this.updateflag = 0;  //编辑flag归零
            }
        },
        targetdelet:function () {
            target_groupidArray = []; //删除前,先清空相关测试目标id数组
            var trs = $("#myModal table").find("tr").filter('.selected');
            if (trs.length == 0) {
                toastr.warning('请选择删除项目！');
            }else {
                for(var i=0;i<trs.length;i++){       /*取得选中行的id*/
                    var tds = trs.eq(i).find("td");
                    if(tds.eq(2).text()==0){
                        trs.eq(i).remove();     //如果是增添项就直接移除
                        this.users.pop(); //删除数组中最后一个元素0
                    }else {
                    target_groupidArray[i] = parseInt(tds.eq(2).text());   /*将id加入数组中*/
                    }
                }
                if(target_groupidArray.length!=0){
                this.targetdelet_ajax();
                console.log(target_groupidArray)
                }
                var isadd = $.inArray(0,this.users);  //检测users中是否有零元素
                if(isadd == -1){              //有增添项就显示确认增加按钮
                    $('#targetaddaffirm').css("display","none");
                }else {
                    $('#targetaddaffirm').css("display","block");
                }

            }
            /*find被选中的行*/
        },
        targetdelet_ajax:function () {
            var ids = JSON.stringify(target_groupidArray);    /*对象数组字符串*/
            $.ajax({
                type: "POST",   /*GET会乱码*/
                url: "../targetgroup/delete",
                cache: false,  //禁用缓存
                data: ids,  //传入组装的参数
                dataType: "json",
                contentType:"application/json",  /*必须要,不可少*/
                success: function (result) {
                    console.log("传递成功");
                    toastr.success("相关目标删除成功!");

                    probedata_handle.gettarget_group(group_id);  /*搜索中间表中对应group_id的内容*//*观察者,更新相关目标总记录数*/
                    target_groupidArray = []; //清空相关测试目标id数组

                }
            });
        },
        targetupdate_ajax:function () {
            var target_group = JSON.stringify(targetUpdate);
            $.ajax({
                type: "POST",   /*GET会乱码*/
                url: "../targetgroup/updatebatch",
                cache: false,  //禁用缓存
                data: target_group,  //传入组装的参数
                dataType: "json",
                contentType:"application/json",  /*必须要,不可少*/
                success: function (result) {
                    console.log("传递成功");
                    toastr.success("相关目标更新成功!");

                    probedata_handle.gettarget_group(group_id);  /*搜索中间表中对应group_id的内容*//*观察者,更新相关目标总记录数*/
                    targetUpdate = []; //清空相关测试目标entity对象数组

                }
            });
        },
        targetadd_ajax:function () {
            var target_group = JSON.stringify(targetAdd);
            $.ajax({
                type: "POST",   /*GET会乱码*/
                url: "../targetgroup/savebatch",
                cache: false,  //禁用缓存
                data: target_group,  //传入组装的参数
                dataType: "json",
                contentType:"application/json",  /*必须要,不可少*/
                success: function (result) {
                    console.log("传递成功");
                    toastr.success("相关目标增加成功!");

                    probedata_handle.gettarget_group(group_id);  /*搜索中间表中对应group_id的内容*//*观察者,更新相关目标总记录数*/
                    targetAdd = []; //清空相关测试目标entity对象数组

                }
            });
        },
        cancel:function () {
            $('#targetupdateaffirm').css("display","none");//隐藏按钮
            $('#targetaddaffirm').css("display","none");//隐藏按钮
        },
        submit: function () {
            var testagentJson = getFormJson($('#probeform_data'));
            if(testagentJson["name"]==""){                  /*必选*/
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
    /*模态框相关目标测试表格*/
    $('#myModal tbody').on('click', 'tr', function () {   /*表格某一行选中状态*/
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
                //ajax请求数据
                $.ajax({
                    type: "POST",   /*GET会乱码*/
                    url: "../testgroup/list",
                    cache: false,  //禁用缓存
                    data: param,  //传入组装的参数
                    dataType: "json",
                    success: function (result) {
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

