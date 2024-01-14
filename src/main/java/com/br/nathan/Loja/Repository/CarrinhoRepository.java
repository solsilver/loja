package com.br.nathan.Loja.Repository;

import com.br.nathan.Loja.model.Carrinho;
import com.br.nathan.Loja.model.Cartoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
}
