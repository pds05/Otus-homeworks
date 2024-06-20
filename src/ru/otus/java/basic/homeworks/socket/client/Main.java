package ru.otus.java.basic.homeworks.socket.client;

import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введи 'Y' для подключения к серверу");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        if (userInput.equalsIgnoreCase("y")) {
            try (Socket socket = new Socket("localhost", 8888)) {
                socket.setSoTimeout(0);
                PingClient pingClient = new PingClient(socket);
                String result = pingClient.read();
                System.out.println(result);
                userInput = scanner.nextLine();
                do {
                    pingClient.send(userInput);
                    result = pingClient.read();
                    System.out.println("Результат=" + result);
                    System.out.println("Введи новое выражение или 'Exit' для выхода");
                    userInput = scanner.nextLine();
                } while (!userInput.toLowerCase().equals("exit"));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}