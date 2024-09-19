import java.util.ArrayList;
import java.util.List;

// Classe Barco
class Barco {
    String nome;
    int tamanho;

    public Barco(String nome, int tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public int getTamanho() {
        return tamanho;
    }
}

// Classe BasePorto
class BasePorto {
    String nome;
    List<Barco> barcosAtracados;

    public BasePorto(String nome) {
        this.nome = nome;
        this.barcosAtracados = new ArrayList<>();
    }

    public void atracarBarco(Barco barco) {
        barcosAtracados.add(barco);
        System.out.println(barco.getNome() + " atracado no " + nome);
    }

    public void desatracarBarco(Barco barco) {
        barcosAtracados.remove(barco);
        System.out.println(barco.getNome() + " desatracado do " + nome);
    }
}

// Classe PortoPequeno
class PortoPequeno extends BasePorto {

    public PortoPequeno(String nome) {
        super(nome);
    }

    @Override
    public void atracarBarco(Barco barco) {
        if (barco.getTamanho() <= 10) {
            super.atracarBarco(barco);
        } else {
            System.out.println(barco.getNome() + " não pode ser atracado no " + nome + " (tamanho maior que 10)");
        }
    }
}

// Classe PortoGrande
class PortoGrande extends BasePorto {

    public PortoGrande(String nome) {
        super(nome);
    }

    @Override
    public void atracarBarco(Barco barco) {
        if (barco.getTamanho() >= 10) {
            super.atracarBarco(barco);
        } else {
            System.out.println(barco.getNome() + " não pode ser atracado no " + nome + " (tamanho menor que 10)");
        }
    }
}

// Classe Principal
public class Main {
    public static void main(String[] args) {
        // Criando os barcos
        Barco barco1 = new Barco("Barco 1", 2);
        Barco barco2 = new Barco("Barco 2", 5);
        Barco barco3 = new Barco("Barco 3", 7);
        Barco barco4 = new Barco("Barco 4", 12);
        Barco barco5 = new Barco("Barco 5", 20);

        // Criando portos
        PortoPequeno portoPequeno = new PortoPequeno("Porto Pequeno");
        PortoGrande portoGrande = new PortoGrande("Porto Grande");

        // Lista de barcos
        Barco[] barcos = {barco1, barco2, barco3, barco4, barco5};

        // Tentando atracar os barcos
        for (Barco barco : barcos) {
            if (barco.getTamanho() <= 10) {
                portoPequeno.atracarBarco(barco);
            } else {
                portoGrande.atracarBarco(barco);
            }
        }
    }
}