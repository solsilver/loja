package com.br.nathan.Loja.service;

import com.br.nathan.Loja.Repository.CompradorRepository;
import com.br.nathan.Loja.model.Comprador;
import com.br.nathan.Loja.model.dto.CompradorDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompradorService {
    @Autowired
    private CompradorRepository compradorRepository;
    @Autowired
    private CartoesService cartoesService;
    @Autowired
    private ModelMapper modelMapper;

    public Comprador saveComprador(Comprador comprador) {
        compradorRepository.save(comprador);
        cartoesService.salvarCartoes(comprador.getCartoes(), comprador);
        return comprador;

    }

    public List<CompradorDTO> getComprador() {
        List<Comprador> comprador = compradorRepository.findAll();
        List<CompradorDTO> compradorDTOS = comprador.stream().map(c -> modelMapper.map(c, CompradorDTO.class)).toList();

        return compradorDTOS;
    }


}
