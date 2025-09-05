package iuh.fit.se.websocketdemo;

import jakarta.websocket.*;

import java.io.IOException;
import java.net.URI;

@ClientEndpoint(
        encoders = { MessageEncoder.class },
        decoders = { MessageDecoder.class }
)
public class ChatClientEndpoint {
    private Session session = null;
    private MessageHandler messageHandler;

    public void chatClientEndpoint(URI endpointURI) {
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, endpointURI);
        } catch (DeploymentException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        try {
            session.getBasicRemote().sendText("Opening connection");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addMessageHandler(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    @OnMessage
    public void processMessage(String message) {
        System.out.println("Received message in client: " + message);
    }

    public void sendMessage(String message) {
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static interface MessageHandler {
        public void handleMessage(String message);
    }
}
