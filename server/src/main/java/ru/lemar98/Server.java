package ru.lemar98;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try (ServerSocket socket = new ServerSocket(3000)) {

            Socket client = socket.accept();
            System.out.println("Client connected!");

            InputStreamReader inputStreamReader = new InputStreamReader(client.getInputStream());

            BufferedReader reader = new BufferedReader(inputStreamReader);

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Received message: " + line);
            }

        } catch (IOException exception) {
            throw new RuntimeException("Socket threw an exception: " + exception);
        }
    }
}