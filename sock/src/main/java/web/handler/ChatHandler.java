package web.handler;

import web.coder.MessageDecode;
import web.coder.MessageEncoder;
import web.entity.Message;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@ServerEndpoint(value = "/chat/{username}", decoders = {MessageDecode.class}, encoders = {MessageEncoder.class})
public class ChatHandler {

    private Session session;
    private String username;
    private static Logger logger = Logger.getLogger(ChatHandler.class.getName());
    private static List<Session> sessionList = new ArrayList<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username){
        this.session = session;
        this.username = username;
        logger.info("add session");
        sessionList.add(session);
    }

    @OnClose
    public void onClose(Session session){
        logger.info("remove session");
        sessionList.remove(session);
    }

    @OnError
    public void onError(Session session, Throwable throwable){
        logger.info("session " + session);
        logger.info("throwable " + Arrays.toString(throwable.getStackTrace()));
    }

    @OnMessage
    public  void onMessage(Session session, Message msg){
        msg.setAuthor(this.username);
        sessionList.forEach(s -> {
            if(s == session) return;
            try {
                s.getBasicRemote().sendObject(msg);
            } catch (IOException | EncodeException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
