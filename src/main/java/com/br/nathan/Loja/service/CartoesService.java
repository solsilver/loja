package com.br.nathan.Loja.service;

import com.br.nathan.Loja.Repository.CartoesRepository;
import com.br.nathan.Loja.model.Cartoes;
import com.br.nathan.Loja.model.Comprador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartoesService {
    @Autowired
    private CartoesRepository cartoesRepository;

    public Cartoes salvarCartoes(List<Cartoes> cartoes, Comprador comprador) {
        cartoes.stream().forEach(c -> c.setComprador(comprador));
        cartoesRepository.saveAll(cartoes);
        return new Cartoes();
    }
}
