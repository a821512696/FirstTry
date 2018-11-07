package sch.hunnu.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import sch.hunnu.dao.peopleDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WebSocketHandle extends TextWebSocketHandler {
    @Autowired
    private peopleDao dao;


    public static int OnlineCount = 0;
    private WebSocketSession session;
    //构建一个线程安全的List 来存储
    private static List<WebSocketHandle> userList = Collections.synchronizedList(new ArrayList<>());


    /**
     * 连接成功调用的方法
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

        System.out.println("连接已经建立 afterConnectionEstablished（）");
        this.session = session;
    }

    /**
     * 给服务端发信息
     */
    public static void sendMes(WebSocketMessage text,WebSocketSession session) throws IOException {
        session.sendMessage(text);
    }

    /**
     * 处理接收的text信息
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String mes = message.getPayload();

        System.out.println("处理TEXT信息 handleTextMessage: "+message.toString());
        System.out.println("接收到的信息："+mes);

        ObjectMapper ob = new ObjectMapper();

       String str = ob.writeValueAsString(dao.selectFtAll());

       TextMessage text = new TextMessage(str);
        sendMes(text,session);

    }



    /**
     * 当传输信息产生错误时调用
     * @param session
     * @param exception
     * @throws Exception
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.println("处理传输错误 handleTransportError: "+exception.getMessage());
    }

    /**
     * 连接关闭时调用
     * @param session
     * @param status
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("连接关闭afterConnectionClosed : "+status.getReason());
    }



}
