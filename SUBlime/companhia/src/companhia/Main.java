package companhia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o fator aeroportuário: ");
        double fatorAeroportuario = scanner.nextDouble();

        RelatorioVoos relatorio = new RelatorioVoos();

        for (int i = 0; i < 4; i++) {
            System.out.println("\nVoo " + (i + 1) + ":");
            System.out.print("Informe a distância (km): ");
            double distancia = scanner.nextDouble();
            System.out.print("Informe a velocidade média (km/h): ");
            double velocidadeMedia = scanner.nextDouble();
            System.out.print("Seu voo é comercial, charter ou privado? ");
            String tipoVoo = scanner.next();

            switch (tipoVoo) {
                case "comercial":
                    relatorio.adicionarVoo(new VooComercial(distancia, velocidadeMedia, tipoVoo));
                    break;
                case "charter":
                    System.out.print("Informe quantidade de passageiros: ");
                    int quantidadePassageiros = scanner.nextInt();
                    relatorio.adicionarVoo(new VooCharter(distancia, velocidadeMedia, tipoVoo, quantidadePassageiros));
                    break;
                case "privado":
                    System.out.print("Informe a velocidade mínima (km/h): ");
                    double velocidadeMinima = scanner.nextDouble();
                    relatorio.adicionarVoo(new VooPrivado(distancia, velocidadeMedia, tipoVoo, velocidadeMinima));
                    break;
                default:
                    System.out.println("Tipo de voo não existe");
                    i--;
                    break;
            }
        }

        relatorio.imprimirRelatorio(fatorAeroportuario);

        scanner.close();
    }
}