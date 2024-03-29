package web.coder;

import com.google.gson.Gson;
import web.entity.Message;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class MessageDecode implements Decoder.Text<Message> {

    private static Gson gson = new Gson();

    public Message decode(String s) throws DecodeException {
        return gson.fromJson(s, Message.class);
    }

    public boolean willDecode(String s) {
        return s != null;
    }

    public void init(EndpointConfig endpointConfig) {

    }

    public void destroy() {

    }
}
