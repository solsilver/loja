package com.br.nathan.Loja.service;

import com.br.nathan.Loja.Repository.CartoesRepository;
import com.br.nathan.Loja.model.CartoesCadastrados;
import com.br.nathan.Loja.model.Comprador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartoesService {
    @Autowired
private CartoesRepository cartoesRepository;
    public CartoesCadastrados salvarCartoes(List<CartoesCadastrados> cartoesCadastrados, Comprador comprador) {
        cartoesCadastrados.stream().forEach(t -> t.setComprador(comprador));
        cartoesRepository.saveAll(cartoesCadastrados);
        return new CartoesCadastrados();
    }
}
