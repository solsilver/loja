package com.br.nathan.Loja.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CartoesCadastrados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numero;
    private Integer codigo;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "pessoa_id")
    private Comprador comprador;
}
