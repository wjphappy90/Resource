<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="format-detection" content="telephone=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <meta name="mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta content="yes" name="apple-mobile-web-app-capable">
    <meta content="yes" name="apple-touch-fullscreen">
    <meta name="full-screen" content="yes">
    <meta content="default" name="apple-mobile-web-app-status-bar-style">
    <meta name="screen-orientation" content="portrait">
    <meta name="browsermode" content="application">
    <meta name="msapplication-tap-highlight" content="no">
    <meta name="x5-orientation" content="portrait">
    <meta name="x5-fullscreen" content="true">
    <meta name="x5-page-mode" content="app">
    <base target="_blank">
    <title>黑马-聊天室</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="css/chat.css">
    <script src="js/jquery-1.9.1.min.js"></script>

    <script type="text/javascript">
        <%
            String name = session.getAttribute("username")+"";
        %>
        var self = "<%= name %>";
    </script>
    <script type="text/javascript" src="js/ws.js"></script>
</head>


<body  onload="startWebSocket(self);">

<img style="width:100%;height:100%" src="img/chat_bg.jpg">

<div class="abs cover contaniner">
    <div class="abs cover pnl">
        <div class="top pnl-head" style="padding: 20px ; color: white;" id="userName"></div>
        <div class="abs cover pnl-body" id="pnlBody">
            <div class="abs cover pnl-left">
                <div class="abs cover pnl-msgs scroll" id="show">
                    <div class="pnl-list" id="hists"><!-- 历史消息 --></div>
                    <div class="pnl-list" id="msgs">
                        <!-- 消息这展示区域 -->
                    </div>
                </div>

                <div class="abs bottom pnl-text">
                    <div class="abs cover pnl-input">
                        <textarea class="scroll" id="context_text" onkeydown="sendMessage(self)" wrap="hard" placeholder="在此输入文字信息..."></textarea>
                        <div class="abs atcom-pnl scroll hide" id="atcomPnl">
                            <ul class="atcom" id="atcom"></ul>
                        </div>
                    </div>

                    <div class="abs br pnl-btn" id="submit" style="background-color: rgb(32, 196, 202); color: rgb(255, 255, 255);" onclick="sendMsg(self)">
                        发送
                    </div>
                    <div class="pnl-support" id="copyright"><a href="http://www.itcast.cn">传智播客,版本所有</a></div>
                </div>
            </div>


            <div class="abs right pnl-right">
                <div class="slider-container hide"></div>
                <div class="pnl-right-content">
                    <div class="pnl-tabs">
                        <div class="tab-btn active" id="hot-tab">好友列表</div>
                    </div>
                    <div class="pnl-hot">
                        <ul class="rel-list unselect" id="userlist">
                        </ul>
                    </div>

                </div>


                <div class="pnl-right-content">
                    <div class="pnl-tabs">
                        <div class="tab-btn active">系统广播</div>
                    </div>
                    <div class="pnl-hot">
                        <ul class="rel-list unselect" id="broadcastList">
                        </ul>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>