package com.br.nathan.Loja.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float valorTotal;
    @ManyToMany(mappedBy = "carrinhos")
    private List<Item> itens;
}
