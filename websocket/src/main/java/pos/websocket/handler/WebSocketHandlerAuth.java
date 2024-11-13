package pos.websocket.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.db.User;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import pos.websocket.GuiWebSocket;
import pos.websocket.model.FormAuth;

import java.time.LocalDateTime;

@Component
public class WebSocketHandlerAuth extends TextWebSocketHandler {

    private final GuiWebSocket guiWebSocket;
    private final ObjectMapper objectMapper;

    public WebSocketHandlerAuth(GuiWebSocket guiWebSocket, ObjectMapper objectMapper) {
        this.guiWebSocket = guiWebSocket;
        this.objectMapper = objectMapper;
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        System.out.println("Received message: " + payload);
        FormAuth formAuth = objectMapper.readValue(payload, FormAuth.class);
        System.out.println("##########formAuth");
        System.out.println(formAuth);
        User user = null;
        guiWebSocket.checkCardNumber(formAuth.getCardnumber(), formAuth.getLogin(), formAuth.getPassword());
//        if (formAuth != null && formAuth.getCardnumber() != null) {
//            user = guiWebSocket.checkUserReaderData(formAuth.getCardnumber());
//        } else if (formAuth != null && formAuth.getLogin() != null && formAuth.getPassword() != null) {
//            user = guiWebSocket.checkUserData(formAuth.getLogin(), formAuth.getPassword());
//        }
//        if (user != null) {
//            String json = objectMapper.writeValueAsString(user);
//            System.out.println("Result: " + json);
//        } else {
//            String error = "{ " +
//                    "\"timestamp\": \""+ LocalDateTime.now() + "\", " +
//                    "\"status\": 404, " +
//                    "\"error\": " + "\"Not Found\", " +
//                    "\"path\": \"/api/v1/auth\" }";
//
//            System.out.println("###Error");
//            System.out.println(error);
//        }
        session.sendMessage(new TextMessage(payload));
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("Connected to client: " + session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("Connection closed: " + session.getId());
    }

}
