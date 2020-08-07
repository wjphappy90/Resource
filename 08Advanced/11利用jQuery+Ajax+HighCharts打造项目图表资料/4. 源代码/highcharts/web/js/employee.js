$(function () {
    //创建姓名和工资的数组
    var names = new Array();
    var salarys = new Array();

    //使用ajax从服务器加载数据
    $.get("employee", function (data) {
        for (var i = 0; i < data.length; i++) {
            //得到每个员工
            //创建姓名数据的数组
            names[i] = data[i].name;
            //创建工资数据的数组
            salarys[i] = data[i].salary;
        }

        //创建图表
        var options = {
            chart: {
                type: 'column'
            },
            title: {
                text: '员工工资一览表'
            },
            xAxis: {
                //x方向的名字，数据从数组中得到
                categories: names,
                crosshair: true
            },
            yAxis: {
                min: 0,
                title: {
                    text: '工资'
                }
            },
            series: [{
                name: '工资',
                //垂直y方向的数字，数据从上面的数组中得到
                data: salarys
            }]
        };
        // 图表初始化函数
        var chart = Highcharts.chart('container', options);
    });
});

