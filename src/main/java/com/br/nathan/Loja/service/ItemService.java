package com.br.nathan.Loja.service;

import com.br.nathan.Loja.Repository.ItemRepository;
import com.br.nathan.Loja.model.Carrinho;
import com.br.nathan.Loja.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Item saveItens(Item item) {
        itemRepository.save(item);
        return item;
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
