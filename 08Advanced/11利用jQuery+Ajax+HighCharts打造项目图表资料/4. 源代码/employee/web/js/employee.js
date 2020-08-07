$(function () {

    //创建两个数组，数组的长度是可变的
    var names = new Array();
    var salarys = new Array();

    //使用ajax方法得到服器端数据
    $.get("employee",function (data) {
        //遍历5个对象
        for (var i = 0; i < data.length; i++) {
            //得到每个员工的名字和工资
            names[i] = data[i].name;
            salarys[i] = data[i].salary;
        }

        //创建图表
        var options = {
            //指定图表的类型
            chart: {
                type: "column"   //柱形图
            },
            title: {
                text: "员工工资一览表"
            },
            xAxis: {
                //指定x的分类
                categories: names,
            },
            yAxis: {
                //设置最小值为0
                min: 0,
                title: {
                    text: "工资"
                }
            },
            //数据数列
            series : [{
                name: "工资",
                //指定工资的数组
                data: salarys
            }]
        };

        //绑定到div对象上
        $("#container").highcharts(options);
    });

});