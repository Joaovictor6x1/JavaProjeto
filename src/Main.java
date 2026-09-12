import java.util.Scanner;

import modelo.Cliente;
import modelo.Computador;
import modelo.HardwareBasico;
import modelo.MemoriaUSB;
import modelo.SistemaOperacional;
import processamento.ProcessarPedido;

public class Main {

    private static final int MATRICULA = 592;

    public static void main(String[] args) {

        //Promoção 1: Apple
        HardwareBasico[] hardwarePromo1 = new HardwareBasico[3];
        hardwarePromo1[0] = new HardwareBasico("Processador Core i5", 2200);
        hardwarePromo1[1] = new HardwareBasico("Memória RAM", 8);
        hardwarePromo1[2] = new HardwareBasico("HD", 500);
        SistemaOperacional soPromo1 = new SistemaOperacional("macOS Sequoia", 64);
        Computador promocao1 = new Computador("Apple", MATRICULA, hardwarePromo1, soPromo1);
        promocao1.addMemoriaUSB(new MemoriaUSB("Pen-drive", 16));

        //Promoção 2: Samsung
        HardwareBasico[] hardwarePromo2 = new HardwareBasico[3];
        hardwarePromo2[0] = new HardwareBasico("Processador Core i7", 3370);
        hardwarePromo2[1] = new HardwareBasico("Memória RAM", 16);
        hardwarePromo2[2] = new HardwareBasico("HD", 1000); // 1Tb = 1000Gb
        SistemaOperacional soPromo2 = new SistemaOperacional("Windows 8", 64);
        Computador promocao2 = new Computador("Samsung", MATRICULA + 1, hardwarePromo2, soPromo2);
        promocao2.addMemoriaUSB(new MemoriaUSB("Pen-drive", 32));

        //Promoção 3: Dell
        HardwareBasico[] hardwarePromo3 = new HardwareBasico[3];
        hardwarePromo3[0] = new HardwareBasico("Processador Core i7", 4500);
        hardwarePromo3[1] = new HardwareBasico("Memória RAM", 32);
        hardwarePromo3[2] = new HardwareBasico("HD", 2000); // 2Tb = 2000Gb
        SistemaOperacional soPromo3 = new SistemaOperacional("Windows 10", 64);
        Computador promocao3 = new Computador("Dell", MATRICULA + 2, hardwarePromo3, soPromo3);
        promocao3.addMemoriaUSB(new MemoriaUSB("HD Externo", 1000)); // 1Tb

        // Dados do cliente
        Cliente cliente = new Cliente("Maria Clara Souza", "123.456.789-00");

        Scanner entrada = new Scanner(System.in);
        int codigo;

        System.out.println("Bem-vindo(a) à PC Mania!");
        System.out.println("1 - Promoção 1 (Apple)");
        System.out.println("2 - Promoção 2 (Samsung)");
        System.out.println("3 - Promoção 3 (Dell)");
        System.out.println("0 - Finalizar compra");

        do {
            System.out.print("\nDigite o código da promoção: ");
            codigo = entrada.nextInt();

            switch (codigo) {
                case 1:
                    cliente.comprarComputador(promocao1);
                    System.out.println("PC da Promoção 1 adicionado ao carrinho!");
                    break;
                case 2:
                    cliente.comprarComputador(promocao2);
                    System.out.println("PC da Promoção 2 adicionado ao carrinho!");
                    break;
                case 3:
                    cliente.comprarComputador(promocao3);
                    System.out.println("PC da Promoção 3 adicionado ao carrinho!");
                    break;
                case 0:
                    System.out.println("Finalizando a compra...");
                    break;
                default:
                    System.out.println("Código inválido! Tente novamente.");
            }

        } while (codigo != 0);

        entrada.close();

        //Resumo da compra
        System.out.println("\n Resumo da Compra -----");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println();

        Computador[] computadoresComprados = cliente.getComputadoresComprados();
        int quantidade = cliente.getQuantidadeComprada();

        for (int i = 0; i < quantidade; i++) {
            computadoresComprados[i].mostraPCConfigs();
        }

        System.out.println("Total da compra: R$ " + cliente.calculaTotalCompra());

        //Monta um array
        Computador[] pedidoFinal = new Computador[quantidade];
        for (int i = 0; i < quantidade; i++) {
            pedidoFinal[i] = computadoresComprados[i];
        }

        ProcessarPedido.enviarPedido(pedidoFinal);
    }
}
