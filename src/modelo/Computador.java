package modelo;

public class Computador {

    private String marca;
    private float preco;
    private HardwareBasico[] hardwares;
    private SistemaOperacional sistemaOperacional;
    private MemoriaUSB memoriaUSB;

    public Computador(String marca, float preco, HardwareBasico[] hardwares, SistemaOperacional sistemaOperacional) {
        this.marca = marca;
        this.preco = preco;
        this.hardwares = hardwares;
        this.sistemaOperacional = sistemaOperacional;
    }

    public void addMemoriaUSB(MemoriaUSB memoriaUSB) {
        this.memoriaUSB = memoriaUSB;
    }

    // O Cliente precisa somar os preços dos PCs comprados, então esse getter é necessário
    public float getPreco() {
        return preco;
    }

    public void mostraPCConfigs() {
        System.out.println("Marca: " + marca);
        System.out.println("Preço: R$ " + preco);

        for (int i = 0; i < hardwares.length; i++) {
            System.out.println("- " + hardwares[i].getNome() + ": " + hardwares[i].getCapacidade());
        }

        System.out.println("Sistema Operacional: " + sistemaOperacional.getNome() + " (" + sistemaOperacional.getTipo() + " bits)");

        if (memoriaUSB != null) {
            System.out.println("Acompanha: " + memoriaUSB.getNome() + " de " + memoriaUSB.getCapacidade() + "Gb");
        }

        System.out.println("------------------------------");
    }
}
