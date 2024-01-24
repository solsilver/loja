package com.br.nathan.Loja.service;

import com.br.nathan.Loja.Repository.ItemRepository;
import com.br.nathan.Loja.model.Carrinho;
import com.br.nathan.Loja.model.Item;
import com.br.nathan.Loja.service.exception.ItemDuplicado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Item saveItens(Item itens) {
        List<Item> duplicado = itemRepository.findAll();
        for (Item item : duplicado) {
            if (Objects.equals(itens.getNome(), item.getNome())) {
                throw new ItemDuplicado("objeto duplicado e dseu id é " + item.getId());
            }
        }
        itemRepository.save(itens);
        return itens;
    }

    public List<Item> buscasItensbyIds(List<Long> itensid) {

        return itemRepository.findAllById(itensid);
    }

    public void vinculaCarrinho(List<Item> itens, Carrinho carrinho) {
        for (Item iten : itens) {
            iten.addCarrinho(carrinho);
        }
        itemRepository.saveAll(itens);
    }

}
