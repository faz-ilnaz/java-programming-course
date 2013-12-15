package com.kpfu.itis.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class SerialClient {
	
	public static String host = "127.0.0.1";
	
    public static void main(String[] args) throws IOException, InterruptedException {

        Socket echoSocket = null;
        ObjectOutputStream out = null;
        ObjectInputStream in = null;

        try {
            echoSocket = new Socket(host, 10007);

            out = new ObjectOutputStream(echoSocket.getOutputStream());
            in = new ObjectInputStream(echoSocket.getInputStream());

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + host);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: " + host);
            System.exit(1);
        }
        
        /* Send and read Student */
        byte[] photo = Files.readAllBytes(Paths.get("images/default_avatar.jpg"));
        Student student = new Student("James", "Forster", "111", photo, new Date());
        
        System.out.println("Sending student: " + student + " to Server");
        Thread.sleep(2000);
        out.writeObject(student);
        out.flush();
        System.out.println("Sended");

        out.close();
        in.close();
        echoSocket.close();
    }
}
