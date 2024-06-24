package br.com.rafaelsilveiradev.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.rafaelsilveiradev.repository.SerieRepository;
import br.com.rafaelsilveiradev.dto.SerieDTO;
import br.com.rafaelsilveiradev.model.Serie;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class SerieController {

    @Autowired
    private SerieRepository repositorio;

    @GetMapping("/series")
    public List<SerieDTO> obterSeries() {
        return repositorio.findAll()
                .stream()
                .map(s -> new SerieDTO(s.getId(), s.getTitulo(), s.getTotalTemporadas(), s.getAvaliacao(), s.getGenero(), s.getAtores(), s.getPoster(), s.getSinopse()))
                .collect(Collectors.toList());
    }
    
}
