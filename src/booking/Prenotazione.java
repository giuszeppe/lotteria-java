package booking;

import java.util.Random;

public class Prenotazione extends Thread{
    private Camera camera;
    private Cliente cliente;
    private int numPersone;
    Random rd = new Random();

    public Prenotazione(Camera camera, Cliente cliente, int numPersone) {
        this.camera = camera;
        this.cliente = cliente;
        this.numPersone = numPersone;
    }

    public void run(){
        double r = Math.random()*300;
        boolean aBuonFine = rd.nextBoolean();
        System.out.println(cliente.getNome() + " prova ad avviare una prenotazione!");
        if(camera.getPrenotata()){
            System.out.println("Prenotatione di " + cliente.getNome() + "impossibile (camera già prenotata)");
        }
        if(camera.getLock().tryLock()) {
            try {
                System.out.println("Prenotazione di " + cliente.getNome());
                sleep((int) r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
               if(!aBuonFine){
                    System.out.println("Il cliente non conferma la prenotazione");
                }else{
                    camera.setPrenotata(true);
                    System.out.println("Cliente " + cliente.getNome() + " prenota la camera");
                }
                camera.getLock().unlock();
            }
        } else {
            System.out.println("Impossibile prenotare per "+ cliente.getNome() +", la camera sta gia venendo prenotata!");
        }
    }
}
