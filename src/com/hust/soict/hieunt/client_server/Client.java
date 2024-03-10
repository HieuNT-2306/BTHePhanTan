package com.hust.soict.hieunt.client_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("127.0.0.1", 9898);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        System.out.println(in.readLine());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Input your numbers (separated by space):");
            String message = scanner.nextLine();
            if (message.isEmpty()) {
                break;
            }
            out.println(message);
            String response = in.readLine();
            System.out.println(response);
        }
        socket.close();
        scanner.close();
    }
}