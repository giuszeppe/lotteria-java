package client_server_str;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerStr {
    ServerSocket server = null;
    Socket client = null;
    String stringaRicevuta = null;
    String stringaModificata = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;

    public Socket attendi(){
        try {
            System.out.println("1 SERVER in esecuzione");

            server = new ServerSocket(67890);
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
            System.out.println("3 Benvenuto client, scrivi una frase e  la trasformo in maiuscolo. Attendo...");
            stringaRicevuta = inDalClient.readLine();
            System.out.println("6 ricevutas la stringa dal client " + stringaRicevuta);

            stringaModificata = stringaRicevuta.toUpperCase();
            System.out.println("7 invio la stringa modificata al client");
            outVersoClient.writeBytes(stringaModificata);

            System.out.println("9 SERVER: fine elaborazione ... me voy");
            client.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione del server");
            System.exit(1);
        }
    }
}
