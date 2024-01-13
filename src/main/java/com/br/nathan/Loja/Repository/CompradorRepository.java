package com.br.nathan.Loja.Repository;

import com.br.nathan.Loja.model.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompradorRepository extends JpaRepository<Comprador, Long> {
}
