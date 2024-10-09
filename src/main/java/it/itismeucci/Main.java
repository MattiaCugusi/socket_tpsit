package it.itismeucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        ServerSocket ss = new ServerSocket(5673);
        Socket mySocket = ss.accept();
        System.out.println("qualcuno si è collegato");

        BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
        DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());
        
        String stringaRicevuta = in.readLine();
        System.out.println("la stringa ricevuta: " + stringaRicevuta);

        String stringaMaiuscola = stringaRicevuta.toUpperCase();
        out.writeBytes(stringaMaiuscola + "\n");

        mySocket.close();

        ss.close();


    
    }
}