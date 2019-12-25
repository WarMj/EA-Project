$(function() {
    layui.use('table', function(){
        var table = layui.table;

        //sub1-1表格加载
        table.render({
            elem: '#sub1-1_table'
            ,height: 500
            ,id: "sub1-1_table"
            ,url: '/student/listStudentInformation' //数据接口
            ,page: true //开启分页
            ,parseData: function(res) { //res 即为原始返回的数据
                return {
                    "code": 0, //解析接口状态
                    // "msg": res.message, //解析提示文本
                    "count": res.length, //解析数据长度
                    "data": res //解析数据列表
                }
            }
            ,cols: [[ //表头
                {field: 'sid', title: '学号', sort: true}
                ,{field: 'name', title: '用户名'}
                ,{field: 'sex', title: '性别', sort: true}
                ,{field: 'university', title: '学校', sort: true}
                ,{field: 'college', title: '学院', sort: true}
                ,{field: 'major', title: '专业', sort: true}
                ,{field: 'sclass', title: '班级', sort: true}
            ]]
        });

        //搜索框
        var $ = layui.$, active = {
            reload: function(){
                var reloadKey = $('#reloadKey');

                if (reloadKey.val() != "") {
                    //执行条件重载
                    table.reload('sub1-1_table', {
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                        ,url:"/student/selectStudentBySid/"
                        ,where: {
                            sid: reloadKey.val()
                        }
                    }, 'data');
                } else {
                    //执行全部重载
                    table.reload('sub1-1_table', {
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                        ,url:"/student/listStudentInformation/"
                    }, 'data');
                }
            }
        };

        $('.sub1-1_table_header .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        //sub1-2表格加载
        table.render({
            elem: '#sub1-2_table'
            ,height: 500
            ,cellMinWidth: 100
            ,url: '/student/listStudentInformation' //数据接口
            ,page: true //开启分页
            ,toolbar: 'default'
            ,parseData: function(res) { //res 即为原始返回的数据
                return {
                    "code": 0, //解析接口状态
                    // "msg": res.message, //解析提示文本
                    "count": res.length, //解析数据长度
                    "data": res //解析数据列表
                }
            }
            ,cols: [[ //表头
                {field: 'sid', title: '学号', sort: true}
                ,{field: 'name', title: '姓名'}
                ,{field: 'sex', title: '性别', sort: true}
                ,{field: 'university', title: '学校', sort: true}
                ,{field: 'college', title: '学院'}
                ,{field: 'major', title: '专业', sort: true}
                ,{field: 'sclass', title: '班级', sort: true}
                ,{fixed: 'right', title:'操作', toolbar: '#rightToolBar', fixed: 'right', sort: true}
            ]]

        });

        //监听头工具条
        table.on('toolbar(sub1-2_table)', function(obj){
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）
            if(layEvent === 'add') {
                var index = layer.open({
                    type: 2
                    ,shadeClose: true
                    ,shade: 0.8
                    ,maxmin: true
                    ,area: ['30%', '80%']
                    ,title: "新增学生信息"
                    ,content: '/studentEdit.html?action=add'
                    ,end: function () {
                        //执行全部重载
                        table.reload('sub1-2_table', {
                            page: {
                                curr: 1 //重新从第 1 页开始
                            }
                            ,url:"/student/listStudentInformation/"
                        }, 'data');
                    }
                });
            }
        });

        //监听行工具条
        table.on('tool(sub1-2_table)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）
            if(layEvent === 'detail'){ //查看
            } else if(layEvent === 'del'){ //删除
                layer.confirm('真的删除行么', function(index){
                    //向服务端发送删除指令
                    $.get("/student/deleteStudentBySid",  {sid: data.sid}, function(result) {
                        obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                        layer.close(index);
                        layer.msg("删除成功");
                    })
                });
            } else if(layEvent === 'edit'){ //编辑
                var index = layer.open({
                    type: 2
                    ,shadeClose: true
                    ,shade: 0.8
                    ,maxmin: true
                    ,area: ['30%', '80%']
                    ,title: "修改学生信息"
                    ,content: '/studentEdit.html?action=edit&sid=' + data.sid
                    ,end: function () {
                        //执行全部重载
                        table.reload('sub1-2_table', {
                            page: {
                                curr: 1 //重新从第 1 页开始
                            }
                            ,url:"/student/listStudentInformation/"
                        }, 'data');
                    }
                });

                //同步更新缓存对应的值
                // obj.update({
                //     username: '123'
                //     ,title: 'xxx'
                // });
            } else if(layEvent === 'LAYTABLE_TIPS'){
                layer.alert('Hi，头部工具栏扩展的右侧图标。');
            }
        });

    });
})