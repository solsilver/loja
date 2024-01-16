package com.br.nathan.Loja.controller;

import com.br.nathan.Loja.model.Comprador;
import com.br.nathan.Loja.model.dto.CompradorDTO;
import com.br.nathan.Loja.service.CompradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("comprador")
public class CompradorController {
    @Autowired
    private CompradorService compradorService;

    @PostMapping
    public ResponseEntity<?> criarComprador(@RequestBody Comprador comprador) {
        Comprador compradorOutput = compradorService.saveComprador(comprador);
        URI location = UriComponentsBuilder.fromUriString("http://localhost:8080/pessoa/{id}").
                buildAndExpand(compradorOutput.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<CompradorDTO>> buscarComprador() {

        List<CompradorDTO> comprador = compradorService.getComprador();
        return ResponseEntity.ok().body(comprador);

    }
}
