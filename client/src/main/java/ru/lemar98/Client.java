package ru.lemar98;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket server = new Socket("127.0.0.1", 3000)) {
            Scanner scanner = new Scanner(System.in);

            OutputStream outputStream = server.getOutputStream();

            System.out.println("Connected to server!");

            String text = "";

            while (scanner.hasNextLine() && !text.equalsIgnoreCase("end")) {
                text = scanner.nextLine();
                text += "\n";
                outputStream.write(text.getBytes(StandardCharsets.UTF_8));
                outputStream.flush();
            }

        } catch (IOException exception) {
            throw new RuntimeException("Socket error occurred: " + exception);
        }
    }
}