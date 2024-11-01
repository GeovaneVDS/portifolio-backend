package com.example.exercicio11.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.exercicio11.Conta;
import com.example.exercicio11.Transacao;


@Service
public class TransacoesService {
    private List<Conta> contas;

    public TransacoesService() {
        contas = new ArrayList<>();
        contas.add(new Conta("500-1", "Fulano", 1000.0));
        contas.add(new Conta("320-2", "Ciclano", 500.0));
    }

    public Optional<Conta> encontrarConta(String codigo) {
        return contas.stream().filter(conta -> conta.getCodigo().equals(codigo)).findFirst();
    }

    public Transacao realizarTransacao(String origem, String destino, Double valor) throws IllegalArgumentException {
        Conta contaOrigem = encontrarConta(origem).orElseThrow(() -> new IllegalArgumentException("Conta origem não encontrada"));
        Conta contaDestino = encontrarConta(destino).orElseThrow(() -> new IllegalArgumentException("Conta destino não encontrada"));

        if (contaOrigem.getSaldo() < valor) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
        contaDestino.setSaldo(contaDestino.getSaldo() + valor);

        return new Transacao(contaOrigem, contaDestino, valor);
    }
}
