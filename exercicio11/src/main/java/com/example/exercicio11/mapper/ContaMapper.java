package com.example.exercicio11.mapper;
import com.example.exercicio11.dto.ContaDTO;
import com.example.exercicio11.Conta;

public class ContaMapper {
    public static ContaDTO toContaDTO(Conta conta) {
        return new ContaDTO(conta.getCodigo(), conta.getCliente());
    }
}
