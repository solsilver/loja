package com.br.nathan.Loja.model.dto;

import com.br.nathan.Loja.model.Carrinho;
import com.br.nathan.Loja.model.Cartoes;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CompradorInputDTO {

    @NotNull(message= "O campo nome é obrigatorio.")
    @NotBlank(message = "O campo nome nao pode estar vazio.")
    @Size(min = 5, max = 150 , message = "o nome deve ter no minimo 5 caracteres e no minimo 150 caracteres.")
    private String nome;
    @NotNull(message= "O campo genero é obrigatorio.")
    @NotEmpty(message = "O campo genero nao pode estar vazio.")
    private String genero;
    @Email(message = "Favor fornecer um email valido")
    private String email;
    @NotNull(message= "O campo data de nascimento é obrigatorio.")
    private LocalDate dataNascimento;
    @NotNull(message= "O campo é nescessario pelo menos 1 cartão")
    private List<Cartoes> cartoes;


}
