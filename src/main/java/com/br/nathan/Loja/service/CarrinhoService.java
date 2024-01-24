package com.br.nathan.Loja.service;

import com.br.nathan.Loja.Repository.CarrinhoRepository;
import com.br.nathan.Loja.model.Carrinho;
import com.br.nathan.Loja.model.Item;
import com.br.nathan.Loja.model.dto.ItensDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;
    @Autowired
    private ItemService itemService;

    public List<Carrinho> getall() {
        List<Carrinho> carrinhos = carrinhoRepository.findAll();
        return carrinhos;
    }

    public Carrinho adicionarItens(Long id, ItensDTO itensid) {
        Carrinho carrinho = carrinhoRepository.findById(id).get();
        List<Item> itens = itemService.buscasItensbyIds(itensid.getId()
                .stream().toList());
        for (Item iten : itens) {
            carrinho.setValortotal(iten.getValor() + carrinho.getValortotal());
        }
        itemService.vinculaCarrinho(itens, carrinho);
        carrinho.setItens(itens);


        return carrinhoRepository.save(carrinho);
    }


}
