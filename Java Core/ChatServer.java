package Theme_7;



import Theme_7.Authentication.AuthService;
import Theme_7.Authentication.AuthServiceImpl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatServer {

    private static final Pattern AUTH_PATTERN = Pattern.compile("^/auth (\\w+) (\\w+)$");

    private AuthService authService = new AuthServiceImpl();

    private Map<String, ClientHandler> clientHandlerMap = new ConcurrentHashMap<>();


    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        chatServer.start(7777);
    }

    public void start(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started!");
            while (true) {
                Socket socket = serverSocket.accept();


                DataInputStream inp = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                System.out.println("New client connected!");

                try {
                    String authMessage = inp.readUTF();
                    Matcher matcher = AUTH_PATTERN.matcher(authMessage);
                    if (matcher.matches()) {
                        String username = matcher.group(1);
                        String password = matcher.group(2);

                        Thread timer = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    ClientHandler clientHandler = clientHandlerMap.get(username);
                                    Thread.sleep(120_000);
                                    if (clientHandler.isConnected == false){
                                        try {
                                            System.out.println("Socket closed");
                                            socket.close();

                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }else {

                                        System.out.println("Клиент подключен.");
                                    }


                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        });

                        if (authService.authUser(username, password)) {
                            clientHandlerMap.put(username, new ClientHandler(username, socket, this));
                            out.writeUTF("/auth successful");
                            out.flush();
                            System.out.printf("Authorization for user %s successful%n", username);
                            ClientHandler clientHandler = clientHandlerMap.get(username);
                            clientHandler.isConnected = true;
                        } else {
                            System.out.printf("Authorization for user %s failed%n", username);
                            out.writeUTF("/auth fails");
                            out.flush();
                            socket.close();
                        }
                    } else {
                        System.out.printf("Incorrect authorization message %s%n", authMessage);
                        out.writeUTF("/auth fails");
                        out.flush();
                        socket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String userTo, String userFrom, String msg) throws IOException {
        ClientHandler clientHandler = clientHandlerMap.get(userTo);
        if (clientHandler != null) {
            clientHandler.sendMessage(userFrom, msg);
        }
    }

    public void unsubscribe(ClientHandler clientHandler) {
        clientHandlerMap.remove(clientHandler.getUsername());
    }

}
