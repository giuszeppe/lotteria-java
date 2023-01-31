package booking;

import java.util.concurrent.locks.ReentrantLock;

public class Camera {
    private int numero;
    private int numLetti;
    private Boolean prenotata;
    private String descrizione;
    private float prezzoPerPersona;

    private ReentrantLock lock;

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public Boolean getPrenotata() {
        return prenotata;
    }

    public void setPrenotata(Boolean prenotata) {
        this.prenotata = prenotata;
    }


    public Camera(int numero, int numLetti, Tipologia t){
        this.lock = new ReentrantLock();
        this.numero = numero;
        this.numLetti = numLetti;
        this.prenotata = false;
        switch(t){
            case DELUXE:
                descrizione="descrizione deluxe";
                prezzoPerPersona = (float) 100.0;
                break;
            case STANDARD:
                descrizione="descrizione standard";
                prezzoPerPersona = (float) 70.0;
                break;
            case ECONOMY:
                descrizione="descrizione economy";
                prezzoPerPersona = (float) 50.0;
                break;
            default: descrizione="errore di qualche tipo";
        }
    }
    public String toString(){
        StringBuilder strb = new StringBuilder("Camera num:");
        strb.append(numero);
        strb.append("; numero letti: ");
        strb.append(numLetti);
        strb.append("; prenotata: ");
        strb.append(prenotata);
        strb.append("; descrizione: ");
        strb.append(descrizione);
        return strb.toString();
    }
}
