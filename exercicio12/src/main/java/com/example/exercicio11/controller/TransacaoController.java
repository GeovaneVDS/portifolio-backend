package com.example.exercicio11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.exercicio11.service.TransacoesService;
import com.example.exercicio11.dto.TransacaoRequestDTO;
import com.example.exercicio11.dto.TransacaoResponseDTO;
import com.example.exercicio11.dto.ContaDTO;
import com.example.exercicio11.mapper.ContaMapper;
import com.example.exercicio11.Transacao;




@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacoesService transacoesService;

    @PostMapping
    public ResponseEntity<TransacaoResponseDTO> gerarTransacao(@RequestBody TransacaoRequestDTO requestDTO) {
        try {
            Transacao transacao = transacoesService.realizarTransacao(requestDTO.origem(), requestDTO.destino(), requestDTO.valor());
            ContaDTO origemDTO = ContaMapper.toContaDTO(transacao.getOrigem());
            ContaDTO destinoDTO = ContaMapper.toContaDTO(transacao.getDestino());
            TransacaoResponseDTO responseDTO = new TransacaoResponseDTO(origemDTO, destinoDTO, transacao.getValor());
            return ResponseEntity.ok(responseDTO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
