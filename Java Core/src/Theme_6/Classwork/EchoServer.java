package Theme_6.Classwork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(7776)) {
            System.out.println("Server started!");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                Scanner sc = new Scanner(socket.getInputStream());
                /* PrintWriter pw = new PrintWriter(socket.getOutputStream());*/

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try (DataInputStream inp = new DataInputStream(socket.getInputStream());
                             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

                            while (true) {
                                String msg = inp.readUTF();
                                System.out.println("Message: " + msg);
                                out.writeUTF(msg);
                                out.flush();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
