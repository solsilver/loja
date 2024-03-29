package com.br.nathan.Loja.model.dto;

import com.br.nathan.Loja.model.Carrinho;
import com.br.nathan.Loja.model.Cartoes;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CompradorDTO {
    private Long id;
    private String nome;
    private String genero;
    private String email;
    private LocalDate dataNascimento;
    private List<CartoesDTO> cartoes;
    private CarrinhoDTO carrinho;
}
