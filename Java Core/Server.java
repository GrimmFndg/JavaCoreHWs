package Theme_6;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.*;

public class Server {

    private static List<ClientHandler> clientHandlerList = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(7777)) {

            System.out.println("Server started! Waiting for users...");
            runThreadForGlobalAlertMessage();

            while (true) {
                Socket socket = serverSocket.accept();
                clientHandlerList.add(new ClientHandler(socket));
                System.out.println("Client connected! Current online clients: " + clientHandlerList.size());
                System.out.println("Say(Global): ");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private static void runThreadForGlobalAlertMessage(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try (Scanner scanner = new Scanner(System.in)) {
                    System.out.println("Say(Global): ");
                    while (!Thread.currentThread().isInterrupted() && scanner.hasNextLine()) {
                        String msg = scanner.nextLine();
                        Iterator<ClientHandler> iterator = clientHandlerList.iterator();
                        while (iterator.hasNext()) {
                            ClientHandler handler = iterator.next();
                            try {
                                handler.sendMessage(msg);
                            } catch (EOFException | SocketException ex) {
                                System.out.println("Client is offline.");
                                ex.printStackTrace();
                                iterator.remove();
                                System.out.println("Current online clients: " + clientHandlerList.size());
                            }
                        }
                        System.out.println("Say(Global): ");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();

    }




}

