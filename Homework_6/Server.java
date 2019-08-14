/**
 * lesson 6 level 2
 * @author Maluy Yaroslav
 * @version data 14.08.19
 */

//Написать консольный вариант клиент\серверного приложения, в котором пользователь может писать сообщения,
// как на клиентской стороне, так и на серверной. Т.е. если на клиентской стороне написать "Привет",
// нажать Enter то сообщение должно передаться на сервер и там отпечататься в консоли.
// Если сделать то же самое на серверной стороне, сообщение соответственно передается клиенту и печатается у него в консоли.
// Есть одна особенность, которую нужно учитывать: клиент или сервер может написать несколько сообщений подряд,
// такую ситуацию необходимо корректно обработать
package Homework_6;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        Server server = new Server();
    }
    public Server() {


            ServerSocket server = null;
            Socket socket = null;

            try {
                server = new ServerSocket(Client.PORT);
                System.out.println("Сервер запушен");
                socket = server.accept();
                System.out.println("Клиент подключился");

                Scanner in = new Scanner(socket.getInputStream());
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                Scanner sc = new Scanner(System.in);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            String str = sc.nextLine();
                            out.println("Сервер: " + str);
                        }
                    }
                }).start();

                while (true) {
                    String str = in.nextLine();
                    if (str.equals("/end"))
                        break;
                    System.out.println(str);

                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


