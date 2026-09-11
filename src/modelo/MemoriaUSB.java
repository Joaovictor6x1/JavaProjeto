package modelo;

// Pendrive ou HD Externo que pode (ou não) acompanhar o computador.
// É por isso que essa classe existe separada: no diagrama ela tem multiplicidade 0..1.
public class MemoriaUSB {

    private String nome;
    private int capacidade;

    public MemoriaUSB(String nome, int capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
    }

    public String getNome() {
        return nome;
    }

    public int getCapacidade() {
        return capacidade;
    }
}
