
//定义全局的webSocket对象
var ws = null;

function startWebSocket(self) {
    //构建WebSocket对象
    if ('WebSocket' in window) {
        ws = new WebSocket("ws://localhost:8080/websocket");
    } else if ('MozWebSocket' in window) {
        ws = new MozWebSocket("ws://localhost:8080/websocket");
    } else {
        alert("not support");
    }

    //监听消息， 有消息传递， 会触发此方法
    ws.onmessage = function (evt) {
        var _data = evt.data;
        console.log(">> : " + _data);

        var o = JSON.parse(_data);

        if (o.type == 'message') { //如果后端, 响应的是消息, 在页面展示
            setMessageInnerHTML(o, self);
        } else if (o.type == 'user') { // 如果服务端响应的是用户列表, 在界面展示用户列表
            var userArry = o.data.split(',');
            $("#userlist").empty();
            $("#userlist").append('<li class="rel-item"><input type="radio" name="toUser" value="all">广播</input></li>');
            $.each(userArry, function (n, value) {
                if (value != self && value != 'admin') {
                    $("#userlist").append('<li class="rel-item"><input type="radio"  name="toUser" value="'+value+'">'+value+'</input></li>');

                    $("#broadcastList").append('<li class="rel-item">您的好友 '+value+' 已上线</li>');
                }
            });
        }
    };

    //关闭链接时触发
    ws.onclose = function (evt) {
        $('#userName').html("用户： "+ self +"<span style='float: right;color: red'>离线</span>");
    };

    //打开时触发
    ws.onopen = function (evt) {
        $('#userName').html("用户： "+ self +"<span style='float: right;color: green'>在线</span>");
    };
}

function setMessageInnerHTML(msg, self) {

    //根据后台响应的数据, 判定是展示在左侧还是右侧.
    var str = "";

    if(msg.toName == 'all'){
        $("#broadcastList").append('<li class="rel-item"> 系统广播消息： '+msg.data+' </li>');
    }else if (msg.fromName == self) {
        str = "<div class=\"msg guest\"><div class=\"msg-right\"><div class=\"msg-host headDefault\"></div><div class=\"msg-ball\" title=\"今天 17:52:06\">" + msg.data + "</div></div></div>"
    } else if(msg.toName == self){
        str = "<div class=\"msg robot\"><div class=\"msg-left\" worker=\"" + msg.fromName + "\"><div class=\"msg-host photo\" style=\"background-image: url(../img/avatar/Member002.jpg)\"></div><div class=\"msg-ball\" title=\"今天 17:52:06\">" + msg.data + "</div></div></div>";
    }

    //获取到现有的内容, 追加新的消息内容
    var msgs = document.getElementById("msgs");
    msgs.innerHTML = msgs.innerHTML + str;


    //判定消息来源的用户 , 勾选对应的好友信息
    var a = $('input[name="toUser"]');
    for(var i=0 ; i < a.length ; i++){
        if(a[i].value == msg.fromName){
            console.log(a[i]);
            a[i].checked='checked';
        }
    }
}

// 组装消息, 发送消息
function sendMsg(self) {
    var content = $("#context_text").val();

    if(!content){
        alert('请输入消息内容');
        return ;
    }

    var message = {};
    message.fromName = self;
    message.toName = $('input:radio:checked').val();  //根据界面勾选的用户, 来决定消息发送给谁
    message.content = content; //获取输入文本框中输入的内容
    var msg = JSON.stringify(message);

    console.log(" msg: "+msg);

    ws.send(msg);//发送消息
    $("#context_text").val(''); //将输入框内容置为空
}

function sendMessage(self){
    if(event.keyCode == 13){
        sendMsg(self);
    }
}
