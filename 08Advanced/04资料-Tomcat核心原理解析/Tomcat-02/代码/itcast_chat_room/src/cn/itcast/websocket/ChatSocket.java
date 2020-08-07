package cn.itcast.websocket;

import cn.itcast.util.MessageUtil;
import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ServerEndpoint(value = "/websocket",configurator = GetHttpSessionConfigurator.class )
public class ChatSocket {

    private  Session session;
    private  HttpSession httpSession;

    //保存当前系统中登录的用户的HttpSession信息, 及对应的Endpoint实例信息
    private static Map<HttpSession , ChatSocket> onlineUsers = new HashMap<HttpSession, ChatSocket>();
    private static int onlineCount = 0;

    @OnOpen
    public void onOpen(Session session, EndpointConfig config){

        //1. 记录webSocket的会话信息对象Session
        this.session = session;

        //2. 获取当前登录用户HttpSession信息.
        HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        this.httpSession = httpSession;

        System.out.println("当前登录用户 : " + httpSession.getAttribute("username") +", Endpoint : " +hashCode());

        //3. 记录当前登录用户信息, 及对应的Endpoint实例
        if (httpSession.getAttribute("username") != null){
            onlineUsers.put(httpSession,this);
        }

        //4. 获取当前所有登录用户 --------> ITCAST,HEIMA,TOM...
        String names = getNames();

        //5. 组装消息 ---> {"data":"HEIMA,Deng,ITCAST","toName":"","fromName":"","type":"user"}
        String message = MessageUtil.getContent(MessageUtil.TYPE_USER, "", "", names);

        //6. 通过广播的形式发送消息
        //session.getBasicRemote().sendText("");
        broadcastAllUsers(message);

        //7. 记录当前用户登录数 .
        incrCount();

    }

    //{"fromName":"Deng","toName":"HEIMA","content":"约会呀"}
    @OnMessage
    public  void onMessage(String message, Session session) throws IOException {
        System.out.println("onMessage : name = " + httpSession.getAttribute("username")+ ", message=" + message );
        //1. 获取客户端的信息内容, 并解析
        Map<String,String> messageMap = JSON.parseObject(message, Map.class);
        String fromName = messageMap.get("fromName");
        String toName = messageMap.get("toName");
        String content = messageMap.get("content");

        //2. 判定是否有接收人
        if(toName == null || toName.isEmpty()){
            return;
        }

        //3. 如果接收人是否是广播(all), 如果是, 则说明发送广播消息
        String messageContent = MessageUtil.getContent(MessageUtil.TYPE_MESSAGE, fromName, toName, content);
        System.out.println("服务端给客户端发送消息, 消息内容: " + messageContent);
        if("all".equals(toName)){
            //3.1 组装消息内容
            broadcastAllUsers(messageContent);
        }else{//4. 不是all , 则给指定的用户推送消息
            singlePushMessage(messageContent, fromName,toName);
        }

    }

    //给指定用户推送消息
    private void singlePushMessage(String content, String fromName, String toName) throws IOException {
        boolean isOnline = false;
        //1. 判定当然接收人是否在线
        for (HttpSession hsession : onlineUsers.keySet()) {
            if(toName.equals(hsession.getAttribute("username"))){
                isOnline = true;
            }
        }

        //2. 如果存在, 发送消息
        if(isOnline){
            for (HttpSession hsession : onlineUsers.keySet()) {
                if (hsession.getAttribute("username").equals(fromName) || hsession.getAttribute("username").equals(toName)){
                    onlineUsers.get(hsession).session.getBasicRemote().sendText(content);
                }
            }
        }

    }


    // 发送广播消息
    private void broadcastAllUsers(String message) {

        for (HttpSession hsession : onlineUsers.keySet()) {
            try {
                onlineUsers.get(hsession).session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    //获取所有的在线用户
    private String getNames() {
        String names = "";
        if(onlineUsers.size()>0){
            for (HttpSession hsession : onlineUsers.keySet()) {
                String username = (String) hsession.getAttribute("username");
                names += username+",";
            }
        }
        return names.substring(0,names.length()-1);
    }


    @OnClose
    public void onClose(Session session, CloseReason closeReason){
        decrCount();
        System.out.println("客户端关闭了一个连接 , 当前在线人数 : " + getOnlineCount());
    }


    @OnError
    public void onError(Session session, Throwable throwable){
        throwable.printStackTrace();
        System.out.println("服务异常");
    }


    public int getOnlineCount(){
        return onlineCount;
    }

    public synchronized void incrCount(){
        onlineCount ++;
    }

    public synchronized void decrCount(){
        onlineCount --;
    }

}
