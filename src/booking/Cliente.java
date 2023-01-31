package booking;

public class Cliente {
    private String nome;
    private String CF;
    private String indirizzo;

    public Cliente(String nome, String CF, String indirizzo) {
        this.nome = nome;
        this.CF = CF;
        this.indirizzo = indirizzo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCF() {
        return CF;
    }

    public void setCF(String CF) {
        this.CF = CF;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
}
