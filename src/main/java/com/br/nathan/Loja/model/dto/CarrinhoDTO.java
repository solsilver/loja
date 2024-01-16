package com.br.nathan.Loja.model.dto;

import com.br.nathan.Loja.model.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CarrinhoDTO {
    private Float valortotal;
    private List<Item> itens;
}
