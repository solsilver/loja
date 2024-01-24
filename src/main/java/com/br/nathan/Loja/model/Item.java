package com.br.nathan.Loja.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Float valor;
    @ManyToMany
    @JoinTable(

            name = "Itens-Carrinhos",
            joinColumns = @JoinColumn(name = "itens_id"),
            inverseJoinColumns = @JoinColumn(name = "carrinho_id")

    )
    @JsonIgnore
    private List<Carrinho> carrinhos;

    public void addCarrinho(Carrinho carrinho) {
        if (this.carrinhos == null) {
            this.carrinhos = new ArrayList<>();
        }
        this.carrinhos.add(carrinho);
    }


}
