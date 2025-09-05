package iuh.fit.se.websocketdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.websocket.DecodeException;
import jakarta.websocket.Decoder;
import jakarta.websocket.EndpointConfig;

public class MessageDecoder implements Decoder.Text<Message> {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void init(EndpointConfig endpointConfig) {
        Text.super.init(endpointConfig);
        System.out.println("Initializing message decoder");
    }

    @Override
    public Message decode(String s) throws DecodeException {
        try {
            return objectMapper.readValue(s, Message.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean willDecode(String s) {
        try {
            objectMapper.readTree(s);
            return true;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {
        Text.super.destroy();
        System.out.println("Destroyed message decoder");
    }
}
