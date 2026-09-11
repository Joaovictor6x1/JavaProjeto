package modelo;

public class HardwareBasico {

    private String nome;
    private float capacidade;

    public HardwareBasico(String nome, float capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
    }

    //getters
    public String getNome() {
        return nome;
    }

    public float getCapacidade() {
        return capacidade;
    }
}
