package com.br.nathan.Loja.service;

import com.br.nathan.Loja.Repository.CompradorRepository;
import com.br.nathan.Loja.model.Comprador;
import com.br.nathan.Loja.model.dto.CompradorDTO;
import com.br.nathan.Loja.model.dto.CompradorInputDTO;
import com.br.nathan.Loja.service.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompradorService {
    @Autowired
    private CompradorRepository compradorRepository;
    @Autowired
    private CartoesService cartoesService;
    @Autowired
    private ModelMapper modelMapper;

    public Comprador saveComprador(CompradorInputDTO compradorInputDTO) {
        Comprador comprador = modelMapper.map(compradorInputDTO, Comprador.class);
        compradorRepository.save(comprador);
        cartoesService.salvarCartoes(comprador.getCartoes(), comprador);
        return comprador;

    }

    public List<CompradorDTO> getComprador() {
        List<Comprador> comprador = compradorRepository.findAll();
        List<CompradorDTO> compradorDTOS = comprador.stream().map(c -> modelMapper.map(c, CompradorDTO.class)).toList();

        return compradorDTOS;
    }


    public CompradorDTO getCompradorById(Long id) {
        Comprador comprador = compradorRepository.findById(id)
                .orElseThrow( () -> new ObjectNotFoundException("comprador nao encontrado") );

        return modelMapper.map(comprador,CompradorDTO.class);
    }
}
