package com.backend.ws;

import com.alibaba.fastjson2.JSON;
import com.backend.config.GetHttpSessionConfig;
import com.backend.pojo.Message;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@ServerEndpoint(value = "/chat", configurator = GetHttpSessionConfig.class)
public class ChatEndpoint {

    private static final Map<String, Session> onlineUser = new ConcurrentHashMap<>();

    private HttpSession httpSession;

    // import jakarta.websocket.Session; 注意包名
    @OnOpen
    public void onOpen(Session session, EndpointConfig config){
        httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());

        String user = (String) httpSession.getAttribute("user");
        onlineUser.put(user,session);

    }

    // 浏览器发送消息到服务器，onMessage会被执行
    @OnMessage
    public void onMessage(String message){
        try {
            Message messageObj = JSON.parseObject(message, Message.class);
            String receiver = messageObj.getReceiver();
            String content = messageObj.getContent();
            Session session = onlineUser.get(receiver);
            String user = (String) httpSession.getAttribute("user");
            session.getBasicRemote().sendText(content);
        } catch (IOException ignored) {

        }
    }

    @OnClose
    public void onClose(Session session){
        String user = (String) httpSession.getAttribute("user");
        onlineUser.remove(user);
    }


}
