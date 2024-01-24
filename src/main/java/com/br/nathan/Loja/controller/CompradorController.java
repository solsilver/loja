package com.br.nathan.Loja.controller;

import com.br.nathan.Loja.model.Comprador;
import com.br.nathan.Loja.model.dto.CompradorDTO;
import com.br.nathan.Loja.model.dto.CompradorInputDTO;
import com.br.nathan.Loja.service.CompradorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("Comprador")
public class CompradorController {
    @Autowired
    private CompradorService compradorService;

    @PostMapping
    public ResponseEntity<?> criarComprador(@RequestBody @Valid  CompradorInputDTO comprador) {
        Comprador compradorOutput = compradorService.saveComprador(comprador);
        URI location = UriComponentsBuilder.fromUriString("http://localhost:8080/Pessoa/{id}").
                buildAndExpand(compradorOutput.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<CompradorDTO> buscarCompradorid( @PathVariable ("id") Long id ) {

        CompradorDTO comprador = compradorService.getCompradorById(id);
        return ResponseEntity.ok().body(comprador);

    }
    @GetMapping
    public ResponseEntity<List<CompradorDTO>> buscarComprador() {

        List<CompradorDTO> comprador = compradorService.getComprador();
        return ResponseEntity.ok().body(comprador);

    }
}
