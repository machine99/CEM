Vue.component('data-table', {
    template: '<table></table>',
    props: ['users'],
    data() {
        return {
            headers: [
                {title: '用户ID', name: 'userId'},
                {title: '用户名', name: 'username', class: 'some-special-class'},
                {title: '邮箱', name: 'email'},
                {title: '手机号', name: 'mobile'},
                {title: '状态', name: 'status'},
                {title: '创建时间', name: 'createTime'},
            ],
            rows: [],
            dtHandle: null
        }
    },
    // watch: {
    //     users(val, oldVal) {
    //         let vm = this;
    //         vm.rows = [];
    //         // You should _probably_ check that this is changed data... but we'll skip that for this example.
    //         val.forEach(function (item) {
    //             // Fish out the specific column data for each item in your data set and push it to the appropriate place.
    //             // Basically we're just building a multi-dimensional array here. If the data is _already_ in the right format you could
    //             // skip this loop...
    //             let row = [];
    //
    //             row.push(item.userId);
    //             row.push(item.username);
    //             row.push(item.email);
    //             row.push(item.mobile);
    //             row.push(item.status === 0 ? '禁用' : '正常');
    //             row.push(item.createTime);
    //
    //             vm.rows.push(row);
    //
    //             console.log(item)
    //         });
    //
    //         // Here's the magic to keeping the DataTable in sync.
    //         // It must be cleared, new rows added, then redrawn!
    //         vm.dtHandle.clear();
    //         vm.dtHandle.rows.add(vm.rows);
    //         vm.dtHandle.draw();
    //     }
    // },
    mounted() {
        let vm = this;
        // Instantiate the datatable and store the reference to the instance in our dtHandle element.
        vm.dtHandle = $(this.$el).DataTable({
            // Specify whatever options you want, at a minimum these:
            columns: vm.headers,
            // data: vm.rows,
            searching: false,
            paging: true,
            serverSide: true,
            info: false,
            ajax: function (data, callback, settings) {
                //封装请求参数
                let param = {};
                param.limit = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
                param.start = data.start;//开始的记录序号
                param.page = (data.start / data.length) + 1;//当前页码
                console.log(param);
                //ajax请求数据
                $.ajax({
                    type: "GET",
                    url: "../sys/user/list",
                    cache: false,  //禁用缓存
                    data: param,  //传入组装的参数
                    dataType: "json",
                    success: function (result) {
                        console.log(result);
                        //setTimeout仅为测试延迟效果
                        setTimeout(function () {
                            //封装返回数据
                            let returnData = {};
                            returnData.draw = data.draw;//这里直接自行返回了draw计数器,应该由后台返回
                            returnData.recordsTotal = result.page.totalCount;//返回数据全部记录
                            returnData.recordsFiltered = result.page.totalCount;//后台不实现过滤功能，每次查询均视作全部结果
                            // returnData.data = result.page.list;//返回的数据列表
                            // 重新整理返回数据以匹配表格
                            let rows = [];
                            result.page.list.forEach(function (item) {
                                let row = [];
                                row.push(item.userId);
                                row.push(item.username);
                                row.push(item.email);
                                row.push(item.mobile);
                                row.push(item.status === 0 ? '禁用' : '正常');
                                row.push(item.createTime);
                                rows.push(row);
                            });
                            returnData.data = rows;
                            //console.log(returnData);
                            //调用DataTables提供的callback方法，代表数据已封装完成并传回DataTables进行渲染
                            //此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
                            callback(returnData);
                        }, 200);
                    }
                });
            }
        });
    }
});

new Vue({
    el: '#tabledemo',
    data: {
        users: [],
        search: ''
    },
    computed: {
        filteredUsers: function () {
            let self = this;
            let search = self.search.toLowerCase();
            return self.users.filter(function (user) {
                return user.username.toLowerCase().indexOf(search) !== -1 ||
                    user.email.toLowerCase().indexOf(search) !== -1 ||
                    user.mobile.indexOf(search) !== -1
            })
        }
    },
    mounted() {
        // let vm = this;
        // $.ajax({
        //     url: '../sys/user/list',
        //     dataType: 'json',
        //     data: {
        //         username: null,
        //         page: 10,
        //         limit: 10
        //     },
        //     success(r) {
        //         vm.users = r.page.list;
        //     }
        // });
    }
});