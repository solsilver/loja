package com.br.nathan.Loja.controller;

import com.br.nathan.Loja.model.Carrinho;
import com.br.nathan.Loja.model.dto.ItensDTO;
import com.br.nathan.Loja.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Carrinho")
public class CarrinhoControler {
    @Autowired
    private CarrinhoService carrinhoService;

    @GetMapping
    public ResponseEntity<List<Carrinho>> buscarTodos() {
        List<Carrinho> estudantes = carrinhoService.getall();
        return ResponseEntity.ok().body(estudantes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrinho> addcarrinho(@PathVariable("id") Long id, @RequestBody ItensDTO itensDTO) {
        Carrinho carrinho = carrinhoService.adicionarItens(id, itensDTO);

        return ResponseEntity.ok().body(carrinho);
    }
}
