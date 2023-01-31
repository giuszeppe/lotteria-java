package client_server_time;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerTime {
    ServerSocket server = null;
    Socket client = null;
    Date dataServer = new Date(10,10,1900);
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;

    public Socket attendi(){
        try {
            System.out.println("1 SERVER in esecuzione");

            server = new ServerSocket(6789);
            client = server.accept();

            server.close();
            inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                outVersoClient = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'instanza del server");
            System.exit(1);
        }
        return client;
    }
    public void comunica(){
        try {
            System.out.println("3 Benvenuto client, ti invio il mio tempo!");
            outVersoClient.writeBytes(new SimpleDateFormat("dd/MM/yyyy").format(dataServer));

            System.out.println("7 SERVER: fine elaborazione ... me voy");
            client.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione del server");
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        ServerTime serverTime = new ServerTime();
        serverTime.attendi();
        serverTime.comunica();
    }
}
