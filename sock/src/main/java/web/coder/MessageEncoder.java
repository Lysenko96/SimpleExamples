package web.coder;

import com.google.gson.Gson;
import web.entity.Message;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MessageEncoder implements Encoder.Text<Message> {

    private static Gson gson = new Gson();

    public String encode(Message message) throws EncodeException {
        return gson.toJson(message);
    }

    public void init(EndpointConfig endpointConfig) {

    }

    public void destroy() {

    }
}
