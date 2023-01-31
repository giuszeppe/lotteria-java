package client_server_time;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ClientTime {

    String nomeServer = "localhost";
    int portaServer = 6789;
    Socket socket;
    Calendar calendarClient = new GregorianCalendar();
    Calendar calendarServer = new GregorianCalendar();
    Date serverTime = null;

    DataOutputStream outVersoServer;
    BufferedReader inDalServer;
    public Socket connetti(){
        System.out.println("2 CLIENT partito in esecuzione");
        try{
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
            System.out.println("Tempo client:" + calendarClient.getTime().toString());
            System.out.println("4 Ricezione tempo dal server");
            serverTime = new SimpleDateFormat("dd/MM/yyyy").parse(inDalServer.readLine());
            calendarServer.setTime(serverTime);


            System.out.println("5 calendar aggiornato:" + calendarServer.getTime().toString());
            System.out.println("6 CLIENT: termina elaborazione e chiude connessione");
            socket.close();
        } catch( Exception e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione");
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        ClientTime client = new ClientTime();
        client.connetti();
        client.comunica();
    }
}
