package iuh.fit.se.websocketdemo;

import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/chatEndpoint/{username}",
        encoders = {MessageEncoder.class},
        decoders = {MessageDecoder.class}
)
public class ClassServerEndpoint {
    ChatSession chatSession = new ChatSession();
    private static Session session;
    private static Set<Session> chatters = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {
        this.session = session;
        Map<String, String> charusers = chatSession.getUsers();
        charusers.put(session.getId(), username);
        chatSession.setUsers(charusers);
        chatters.add(session);
        System.out.println(charusers);
        Message message = new Message();
        message.setUserName(username);
        message.setMessage("Welcome " + username + "!");
        broadcast(message);
    }

    @OnMessage
    public void onMessage(Session session, Message message) {
        Map<String, String> charusers = chatSession.getUsers();
        // Có vẻ không cần thiết vì bên client(websocket.js) có gửi userName qua rồi trừ khi tự thay đổi userName
        message.setUserName(charusers.get(session.getId()));
        broadcast(message);
    }

    @OnClose
    public void onClose(Session session) {
        chatters.remove(session);
        Message message = new Message();
        Map<String, String> chatusers = chatSession.getUsers();
        String chatuser = chatusers.get(session.getId());
        message.setUserName(chatuser);
        chatusers.remove(chatuser);
        message.setMessage("Disconnected from server");
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        throwable.printStackTrace();
        System.out.println("There has been an error with session " + session.getId());
    }

    private static void broadcast(Message message) {
        chatters.forEach(session -> {
            synchronized (session) {
                try {
                    session.getBasicRemote().sendObject(message);
                } catch (EncodeException | IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
