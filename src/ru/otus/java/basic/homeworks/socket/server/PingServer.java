package ru.otus.java.basic.homeworks.socket.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class PingServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true) {
            Socket client = serverSocket.accept();
            Thread t = new Thread(() -> {
                try {
                    processRequest(client);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            t.start();
        }
    }

    public static void processRequest(Socket client) throws IOException {
        System.out.println("Client connected");
        send(client, "Вас приветсвует удаленный калькулятор.\nЯ умею совершать математические вычисления: +,-,*,/\nВведи выражение через пробел:");
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream(), "UTF-8"));
        String line;
        while ((line = in.readLine()) != null) {
            String result;
            int operand1;
            int operand2;
            String[] expression = line.split(" ");
            try {
                operand1 = Integer.parseInt(expression[0]);
                operand2 = Integer.parseInt(expression[2]);
                String action = expression[1];
                switch (action) {
                    case "+": {
                        result = String.valueOf(operand1 + operand2);
                    }
                    break;
                    case "-": {
                        result = String.valueOf(operand1 - operand2);
                    }
                    break;
                    case "*": {
                        result = String.valueOf(operand1 * operand2);
                    }
                    break;
                    case "/": {
                        result = String.valueOf(operand1 / operand2);
                    }
                    break;
                    default: {
                        result = "К сожалению, я еще не умею выполнять " + action;
                    }
                }
            } catch (NumberFormatException e) {
                result = "Ошибочный операнд, вычисления производятся с числами: " + e.getMessage();
            }
            send(client, result);
        }
    }

    public static void send(Socket client, String message) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream(), "UTF-8"));
        out.write(message + "\n");
        out.flush();
    }
}
