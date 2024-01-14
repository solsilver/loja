package com.br.nathan.Loja.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Cartoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String codigo;
    @ManyToOne
    @JoinColumn(name = "comprador_id")
    private Comprador comprador;
}
