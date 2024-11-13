package pos.websocket.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.db.ArticlesCheckOpen;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import pos.websocket.GuiWebSocket;
import pos.websocket.model.FormSearchArticles;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class WebSocketHandlerSearchArticles extends TextWebSocketHandler {

    private final GuiWebSocket guiWebSocket;
    private final ObjectMapper objectMapper;

    public WebSocketHandlerSearchArticles(GuiWebSocket guiWebSocket, ObjectMapper objectMapper) {
        this.guiWebSocket = guiWebSocket;
        this.objectMapper = objectMapper;
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        System.out.println("Received message: " + payload);
        System.out.println("######session.getUri()");
        System.out.println(session.getUri());
        FormSearchArticles searchArticles = objectMapper.readValue(payload, FormSearchArticles.class);
        ArticlesCheckOpen articlesCheckOpen = null;
        if (Objects.requireNonNull(session.getUri()).toString().equals("ws://192.168.23.205:8080/api/v1/search-article")) {
            articlesCheckOpen = guiWebSocket.searchArticle(searchArticles.getEventData());
            System.out.println("######articlesCheckOpen");
            System.out.println(articlesCheckOpen);
        } else if (Objects.requireNonNull(session.getUri()).toString().equals("ws://192.168.23.205:8080/api/v1/search-article/confirm-age")) {
            guiWebSocket.confirmAge(searchArticles.getCustomerAge());
        }

        if (articlesCheckOpen != null) {
            String json = objectMapper.writeValueAsString(articlesCheckOpen);
            System.out.println("Result: " + json);
        } else {
            String error = "{ " +
                    "\"timestamp\": \""+ LocalDateTime.now() + "\", " +
                    "\"status\": 404, " +
                    "\"error\": " + "\"Not Found\", " +
                    "\"path\": \"/api/v1/search-article\" }";

            System.out.println("###Error");
            System.out.println(error);
        }
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
