package com.kpfu.itis.serialization;

import java.net.*;
import java.io.*;

public class SerialServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(10007);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 10007.");
            System.exit(1);
        }

        Socket clientSocket = null;

        try {
            System.out.println("Waiting for Client");
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

        ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());

        
        Student student = null;

        try {
            student = (Student) in.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Server recieved info about student: " + student + " from Client");

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
} 