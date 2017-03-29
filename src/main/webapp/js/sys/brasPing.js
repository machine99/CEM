Vue.component('data-table', {
    template: '<table></table>',
    props: ['users'],
    data() {
        return {
            headers: [
                {title: '用户ID'},
                {title: '用户名', class: 'some-special-class'},
                {title: '邮箱'},
                {title: '手机号'},
                {title: '状态'},
                {title: '创建时间'}
            ],
            rows: [],
            dtHandle: null
        }
    },
    watch: {
        users(val, oldVal) {
            let vm = this;
            vm.rows = [];
            // You should _probably_ check that this is changed data... but we'll skip that for this example.
            val.forEach(function (item) {
                // Fish out the specific column data for each item in your data set and push it to the appropriate place.
                // Basically we're just building a multi-dimensional array here. If the data is _already_ in the right format you could
                // skip this loop...
                let row = [];

                row.push(item.userId);
                row.push(item.username);
                row.push(item.email);
                row.push(item.mobile);
                row.push(item.status === 0 ? '禁用' : '正常');
                row.push(item.createTime);

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
            paging: true,
            //serverSide: true,
            info: false
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
        let vm = this;
        $.ajax({
            url: '../sys/user/list',
            dataType: 'json',
            data: {
                username: null,
                page: 1,
                limit: 10
            },
            success(r) {
                vm.users = r.page.list;
            }
        });
    }
});