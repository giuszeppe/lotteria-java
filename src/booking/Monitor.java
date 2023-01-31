package booking;

public class Monitor {
    int status;

    public Monitor(int s){
        status = s;
    }

    synchronized public void AspettaSegnaleDiVia(){
        while(status == 0){
            try {
                System.out.println("Prenotazione in wait");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        status--;
    }
    synchronized public void LanciaSegnaleDiVia(){
        status++;
        System.out.println("Prenotazione disponibile ");
        notify();
    }
}
