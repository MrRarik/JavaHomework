package Homework_6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    final static int PORT = 8189;
    final static String HOST = "localhost";

    public static void main(String[] args) {
        Socket socket = null;

        try {
            socket = new Socket(HOST, PORT);

            Scanner in =  new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String str = in.nextLine();
                        System.out.println(str);
                    }
                }
            }).start();

            while (true) {
                String str = sc.nextLine();
                out.println("Клиент: " + str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
