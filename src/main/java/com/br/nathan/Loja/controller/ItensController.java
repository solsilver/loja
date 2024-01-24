package com.br.nathan.Loja.controller;

import com.br.nathan.Loja.model.Item;
import com.br.nathan.Loja.service.ItemService;
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
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<?> criarItens(@RequestBody Item item) {
        Item itemOutput = itemService.saveItens(item);
        URI location = UriComponentsBuilder.fromUriString("http://localhost:8080/Itens/{id}").
                buildAndExpand(itemOutput.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
