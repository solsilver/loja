package com.br.nathan.Loja.Repository;

import com.br.nathan.Loja.model.Cartoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartoesRepository extends JpaRepository<Cartoes, Long> {
}
