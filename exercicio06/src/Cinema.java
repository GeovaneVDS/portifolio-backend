import java.util.ArrayList;
import java.util.List;

class Cinema {
    private List<Filme> filmesDisponiveis = new ArrayList<>();
    private List<Ingresso> ingressosVendidos = new ArrayList<>();
    private List<String> assentosDisponiveis = new ArrayList<>();

    public Cinema() {
        // Adicionando assentos disponíveis
        char[] fileiras = {'A', 'B', 'C', 'D', 'E', 'F'};
        for (char fileira : fileiras) {
            for (int numero = 1; numero <= 5; numero++) {
                assentosDisponiveis.add(fileira + String.valueOf(numero));
            }
        }
    }

    public void adicionarFilme(Filme filme) {
        filmesDisponiveis.add(filme);
    }

    public Filme buscarFilmePorNome(String nome) {
        for (Filme filme : filmesDisponiveis) {
            if (filme.getNome().equalsIgnoreCase(nome)) {
                return filme;
            }
        }
        return null;
    }

    public void venderIngresso(Cliente cliente, Filme filme, String assento) throws Exception {
        // Verifica se o cliente tem idade suficiente
        if (cliente.getIdade() < filme.getIdadeMinima()) {
            throw new Exception("O ingresso não pode ser vendido pois sua idade não permite!");
        }

        // Verifica se o assento está disponível
        if (!assentosDisponiveis.contains(assento)) {
            throw new Exception("O ingresso não pode ser vendido pois o assento não está mais disponível!");
        }

        // Remove o assento da lista de disponíveis e adiciona o ingresso aos vendidos
        assentosDisponiveis.remove(assento);
        Ingresso ingresso = new Ingresso(cliente, filme, assento);
        ingressosVendidos.add(ingresso);
        System.out.println(ingresso);
    }
}