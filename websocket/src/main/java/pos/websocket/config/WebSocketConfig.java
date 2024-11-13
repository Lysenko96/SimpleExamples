package pos.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import pos.websocket.handler.WebSocketHandlerAuth;
import pos.websocket.handler.WebSocketHandlerSearchArticles;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final WebSocketHandlerAuth webSocketHandlerAuth;
    private final WebSocketHandlerSearchArticles webSocketHandlerSearchArticles;

    public WebSocketConfig(WebSocketHandlerAuth webSocketHandlerAuth, WebSocketHandlerSearchArticles webSocketHandlerSearchArticles) {
        this.webSocketHandlerAuth = webSocketHandlerAuth;
        this.webSocketHandlerSearchArticles = webSocketHandlerSearchArticles;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandlerAuth, "/api/v1/auth").setAllowedOrigins("*");
        registry.addHandler(webSocketHandlerSearchArticles, "/api/v1/search-article").setAllowedOrigins("*");
        registry.addHandler(webSocketHandlerSearchArticles, "/api/v1/search-article/confirm-age").setAllowedOrigins("*");
        registry.addHandler(webSocketHandlerSearchArticles, "/api/v1/search-article/confirm-excise").setAllowedOrigins("*");
    }
}
