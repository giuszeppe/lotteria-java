package booking;

import java.util.ArrayList;
import java.util.List;

public class Albergo {
    private String nome;
    private String indirizzo;
    private int stelle;
    private List<Camera> listaCamere;

    public Albergo(String nome, String indirizzo, int stelle) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.stelle = stelle;
        this.listaCamere = new ArrayList<>();
    }
    public void addCamera(Camera c){
        listaCamere.add(c);
    }
    public void printCamere(){
        listaCamere.forEach(c -> {
            System.out.println(c.toString());
        });
    }
}


