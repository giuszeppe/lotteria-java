package client_server_str;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientStr {

    String nomeServer = "localhost";
    int portaServer = 6789;
    Socket socket;
    BufferedReader tastiera;
    String stringaUtente;
    String stringaRicevutaDalServer;
    DataOutputStream outVersoServer;
    BufferedReader inDalServer;
    public Socket connetti(){
        System.out.println("2 CLIENT partito in esecuzione");
        try{
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            socket = new Socket(nomeServer,portaServer);
            outVersoServer = new DataOutputStream(socket.getOutputStream());
            inDalServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.out.println("Host sconosciuto");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la connessione");
            System.exit(1);
        }
        return socket;
    }
    public void comunica(){
        try{
            System.out.println("4 ... inserisci la stringa da modificare");
            stringaUtente = tastiera.readLine();

            System.out.println("5 ... invio la stringa al server");
            outVersoServer.writeBytes(stringaUtente+ '\n');

            stringaRicevutaDalServer = inDalServer.readLine();
            System.out.println("8 ... risposta dal server" + '\n' + stringaRicevutaDalServer);
            System.out.println("9 CLIENT: termina elaborazione e chiude connessione");
            socket.close();
        } catch( Exception e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione");
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        ClientStr client = new ClientStr();
        client.connetti();
        client.comunica();
    }
}
