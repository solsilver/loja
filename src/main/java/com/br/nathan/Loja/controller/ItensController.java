package com.br.nathan.Loja.controller;

import com.br.nathan.Loja.model.Itens;
import com.br.nathan.Loja.service.ItensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("Itens")
public class ItensController {
    @Autowired
    private ItensService itensService;

    @PostMapping
    public ResponseEntity<?> criarItens(@RequestBody Itens itens) {
        Itens itensOutput = itensService.saveItens(itens);
        URI location = UriComponentsBuilder.fromUriString("http://localhost:8080/Itens/{id}").
                buildAndExpand(itensOutput.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
