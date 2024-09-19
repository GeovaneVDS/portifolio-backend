import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando instância do Cinema e adicionando filmes
        Cinema cinema = new Cinema();
        cinema.adicionarFilme(new Filme("Homem Aranha", 15.0, 12));
        cinema.adicionarFilme(new Filme("O Senhor dos Anéis", 20.0, 14));
        cinema.adicionarFilme(new Filme("Frozen", 12.0, 6));
        cinema.adicionarFilme(new Filme("A Origem", 18.0, 16));
        cinema.adicionarFilme(new Filme("Avatar", 22.0, 10));

        while (true) {
            try {
                // Pedindo informações do cliente
                System.out.println("Qual o seu nome?");
                String nomeCliente = scanner.nextLine();

                System.out.println("Qual a sua idade?");
                int idadeCliente = Integer.parseInt(scanner.nextLine());

                Cliente cliente = new Cliente(nomeCliente, idadeCliente);

                // Escolha do filme
                System.out.println("Que filme você deseja assistir?");
                String nomeFilme = scanner.nextLine();

                Filme filmeEscolhido = cinema.buscarFilmePorNome(nomeFilme);

                if (filmeEscolhido == null) {
                    System.out.println("Filme não encontrado.");
                    continue;
                }

                // Escolha do assento
                System.out.println("Qual assento você deseja?");
                String assentoEscolhido = scanner.nextLine().toUpperCase();

                // Tentando vender o ingresso
                cinema.venderIngresso(cliente, filmeEscolhido, assentoEscolhido);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // Pergunta se deseja continuar
            System.out.println("Deseja realizar outra compra? (s/n)");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("n")) {
                break;
            }
        }
        scanner.close();
    }
}




