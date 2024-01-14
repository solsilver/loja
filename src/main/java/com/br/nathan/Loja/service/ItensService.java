package com.br.nathan.Loja.service;

import com.br.nathan.Loja.Repository.ItensRepository;
import com.br.nathan.Loja.model.Carrinho;
import com.br.nathan.Loja.model.Itens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItensService {
@Autowired
private ItensRepository itensRepository;
    public Itens saveItens(Itens itens) {
        itensRepository.save(itens);
        //telefoneService.salvarTelefones(pessoaInput.getTelefones() , pessoaInput);
        return itens;
    }

    public List<Itens> buscasItensbyIds(List<Long> itensid) {

        return itensRepository.findAllById(itensid);
    }

    public void vinculaCarrinho(List<Itens> itens, Carrinho carrinho) {
        for( Itens iten : itens){
            iten.addCarrinho(carrinho);
        }
        itensRepository.saveAll(itens);
    }

}
