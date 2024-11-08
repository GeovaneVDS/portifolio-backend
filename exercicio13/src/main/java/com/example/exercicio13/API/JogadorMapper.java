package com.example.exercicio13.API;

import org.springframework.stereotype.Component;
import com.example.exercicio13.MODEL.Jogador;

import java.util.Random;

@Component
public class JogadorMapper {
    public Jogador toEntity(JogadorDTO dto) {
        Jogador jogador = new Jogador();
        jogador.setNome(dto.getNome());
        jogador.setApelido(dto.getApelido());
        jogador.setHabilidade(new Random().nextInt(101));
        return jogador;
    }

    public JogadorDTO toDTO(Jogador jogador) {
        return new JogadorDTO(jogador.getNome(), jogador.getApelido(), jogador.getHabilidade());
    }
}
