import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ObterCambio obterCambio = new ObterCambio();
        int opcao = -1;

        while (opcao != 9) {
            System.out.println("""
                *******************************************
                Seja bem-vindo(a) ao Conversor de Moeda :)
                
                1) Dólar --> Real
                2) Real --> Dólar
                3) Libra --> Real
                4) Real --> Libra
                5) Peso argentino --> Real
                6) Real --> Peso argentino
                7) Iene Japonês --> Real
                8) Real --> Iene Japonês
                9) Sair
                
                Escolha uma opção válida: 
                *******************************************
                """);

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número de 1 a 9.");
                continue;
            }

            if (opcao == 9) {
                System.out.println("Saindo do programa. Até logo!");
                break;
            }

            String de = "", para = "";

            switch (opcao) {
                case 1 -> { de = "USD"; para = "BRL"; }
                case 2 -> { de = "BRL"; para = "USD"; }
                case 3 -> { de = "GBP"; para = "BRL"; }
                case 4 -> { de = "BRL"; para = "GBP"; }
                case 5 -> { de = "ARS"; para = "BRL"; }
                case 6 -> { de = "BRL"; para = "ARS"; }
                case 7 -> { de = "JPY"; para = "BRL"; }
                case 8 -> { de = "BRL"; para = "JPY"; }
                default -> {
                    System.out.println("Opção inválida. Por favor, escolha entre 1 e 9.");
                    continue;
                }
            }

            System.out.print("Digite o valor em " + de + ": ");
            double valor;
            try {
                valor = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido.");
                continue;
            }

            ConversorMoeda conversor = new ConversorMoeda(obterCambio);

            double resultado = conversor.converter(de, para, valor);

            if (resultado == -1) {
                System.out.println("Erro ao realizar conversão.");
            } else {
                System.out.printf("Resultado: %.2f %s\n", resultado, para);
            }
        }

        scanner.close();
    }
}