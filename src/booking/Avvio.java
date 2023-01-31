package booking;

public class Avvio {
    public static void main(String[] args) {
        Monitor m1 = new Monitor(1);
        Camera c1 = new Camera(1, 2, Tipologia.DELUXE);
        Camera c2 = new Camera(2, 2, Tipologia.STANDARD);
        Camera c3 = new Camera(3, 5, Tipologia.STANDARD);
        Albergo albergo = new Albergo("AlbergoIbra", "via dell'azienda", 6);
        albergo.addCamera(c1);
        albergo.addCamera(c2);
        albergo.addCamera(c3);
        albergo.printCamere();
        Cliente Ibra = new Cliente("Ibra", "ibr2", "passignano (tutta quanta)");
        Cliente cliente2 = new Cliente("Cliente 2 ", "codice 2", "via del cliente 2");
        Prenotazione p1, p2,p3,p4;
        p1 = new Prenotazione(c1, Ibra, 1);
        p2 = new Prenotazione(c1, cliente2, 1);
        p4 = new Prenotazione(c2, cliente2, 1);
        p3 = new Prenotazione(c3, cliente2, 1);
        p1.start();
        p2.start();
        p3.start();
        p4.start();

        try {
            p1.join();
            p2.join();
            p3.join();
            p4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
    }
}
