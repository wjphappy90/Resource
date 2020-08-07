package utils;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class MessageUtil {

    public final static String TYPE = "type";
    public final static String DATA = "data";
    public final static String FROM_NAME = "fromName";
    public final static String TO_NAME = "toName";

    public final static String TYPE_MESSAGE = "message";
    public final static String TYPE_USER = "user";


    //组装消息, 然后返回一个json格式的消息数据
    public static String getContent(String type, String fromName, String toName, String content) {
        Map<String, Object> userMap = new HashMap<String, Object>();
        userMap.put(MessageUtil.TYPE, type);
        userMap.put(MessageUtil.DATA, content);
        userMap.put(MessageUtil.FROM_NAME, fromName);
        userMap.put(MessageUtil.TO_NAME, toName);

        String jsonMsg = JSON.toJSONString(userMap);
        return jsonMsg;
    }
}