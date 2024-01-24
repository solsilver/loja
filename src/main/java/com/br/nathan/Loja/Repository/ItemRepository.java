package com.br.nathan.Loja.Repository;

import com.br.nathan.Loja.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
