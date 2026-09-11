package modelo;

// Nome do SO (ex: "Windows 10") e tipo (ex: 64, referente a bits).
public class SistemaOperacional {

    private String nome;
    private int tipo;

    public SistemaOperacional(String nome, int tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public int getTipo() {
        return tipo;
    }
}
