package com.br.nathan.Loja.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Comprador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String genero;
    private String email;
    private LocalDate dataNascimento;
    @OneToMany(mappedBy = "comprador", cascade = CascadeType.ALL)
    private List<Cartoes> cartoes;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = " carrinho_id")
    private Carrinho carrinho;


}
