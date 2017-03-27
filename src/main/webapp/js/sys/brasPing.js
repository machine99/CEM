/**
 * Created by tomxie on 2017/3/27.
 */
const MOCK_DATA = {
    head: [
        {title: 'ID'},
        {title: '標題'}
    ],
    body: [
        [1, '測試資料1'],
        [2, '測試資料2'],
        [3, '測試資料3'],
        [4, '測試資料4'],
        [5, '測試資料5'],
        [6, '測用資料6']
    ]
};
console.log("init");


Vue.component('data-table', {
    props: ['head', 'data'],
    template: '<table></table>',
    data: function () {
        return {
            instance: null
        }
    },
    watch: {
        data: function (newData) {
            if (this.instance) {
                this.instance.clear();
                this.instance.rows.add(newData);
                this.instance.draw();
            }
        }
    },
    ready: function () {
        this.instance = $(this.$el).dataTable({
            columns: this.head,
            data: this.data,
            "paging": false,
            "ordering": false,
            "info": false
        })
    }
});

var vm = new Vue({
    el: '#app',
    data: {
        list: {
            head: [
                {title: 'ID'},
                {title: '標題'}
            ],
            body: [
                [1, '測試資料1'],
                [2, '測試資料2'],
                [3, '測試資料3'],
                [4, '測試資料4'],
                [5, '測試資料5'],
                [6, '測用資料6']
            ]
        }
    },
    methods: {
        fetch: function () {
            setTimeout(function () {
                //this.list = MOCK_DATA;
                console.log("copy");
            }, 500)
        },
        addMockData: function () {
            let id = this.list.body[this.list.body.length - 1][0] + 1;
            this.list.body.push([
                id,
                `測試資料${id}`
            ])
        }
    },

    mounted: function () {
        this.fetch();
        console.log("fetch");
    }
});
