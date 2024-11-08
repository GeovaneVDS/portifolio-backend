package com.example.exercicio13.SERVICE;

import com.example.exercicio13.API.JogadorDTO;
import com.example.exercicio13.API.JogadorMapper;
import com.example.exercicio13.MODEL.Jogador;
import com.example.exercicio13.MODEL.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private JogadorMapper jogadorMapper;

    public JogadorDTO criarJogador(JogadorDTO jogadorDTO) {
        Jogador jogador = jogadorMapper.toEntity(jogadorDTO);
        jogador = jogadorRepository.save(jogador);
        return jogadorMapper.toDTO(jogador);
    }

    public List<JogadorDTO> listarJogadores() {
        List<JogadorDTO> lista = jogadorRepository
                .findAll()
                .stream()
                .map(jogador -> jogadorMapper.toDTO(jogador))
                .collect(Collectors.toList());
        return lista;
    }
}
