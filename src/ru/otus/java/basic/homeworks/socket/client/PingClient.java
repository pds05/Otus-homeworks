package ru.otus.java.basic.homeworks.socket.client;

import java.io.*;
import java.net.Socket;

public class PingClient {

    private final BufferedReader in;
    private final BufferedWriter out;

    public PingClient(Socket socket) throws IOException {
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        this.out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
    }

    public void send(String message) throws IOException {
        out.write(message + "\n");
        out.flush();
    }

    public String read() throws IOException {
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            content.append(line);
            if (!in.ready()) {
                break;
            } else {
                content.append(System.lineSeparator());
            }
        }
        return content.toString();
    }
}
