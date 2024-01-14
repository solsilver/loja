package com.br.nathan.Loja.Repository;

import com.br.nathan.Loja.model.Cartoes;
import com.br.nathan.Loja.model.Itens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensRepository extends JpaRepository<Itens, Long> {
}
