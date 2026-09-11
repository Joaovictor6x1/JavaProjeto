package modelo;

// A associação "compra" do diagrama (Cliente -> 2..* Computador) vira, na prática,
// um array de Computador + um contador, já que não podemos usar ArrayList.
public class Cliente {

    private static final int MAX_COMPRAS = 20; // tamanho fixo do "carrinho" do cliente

    private String nome;
    private String cpf;
    private Computador[] computadoresComprados;
    private int quantidadeComprada;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.computadoresComprados = new Computador[MAX_COMPRAS];
        this.quantidadeComprada = 0;
    }

    // Não está no UML como método formal, mas é o jeito de "realizar" a associação compra.
    public void comprarComputador(Computador computador) {
        if (quantidadeComprada < MAX_COMPRAS) {
            computadoresComprados[quantidadeComprada] = computador;
            quantidadeComprada++;
        } else {
            System.out.println("Limite de compras atingido!");
        }
    }

    public float calculaTotalCompra() {
        float total = 0;
        for (int i = 0; i < quantidadeComprada; i++) {
            total = total + computadoresComprados[i].getPreco();
        }
        return total;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Computador[] getComputadoresComprados() {
        return computadoresComprados;
    }

    public int getQuantidadeComprada() {
        return quantidadeComprada;
    }
}
