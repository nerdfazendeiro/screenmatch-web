package br.com.rafaelsilveiradev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.rafaelsilveiradev.dto.SerieDTO;
import br.com.rafaelsilveiradev.model.Serie;

import java.util.List;
import java.util.stream.Collectors;

import br.com.rafaelsilveiradev.repository.SerieRepository;

@Service
public class SerieService {
    @Autowired
    private SerieRepository repositorio;
    
    public List<SerieDTO> obterTodasAsSeries() {
        return converteDados(repositorio.findAll());
    }

    public List<SerieDTO> obterTop5Series() {
        return converteDados(repositorio.findTop5ByOrderByAvaliacaoDesc());
    }

    private List<SerieDTO> converteDados(List<Serie> series){
        return series.stream()
        .map(s -> new SerieDTO(s.getId(), s.getTitulo(), s.getTotalTemporadas(), s.getAvaliacao(), s.getGenero(), s.getAtores(), s.getPoster(), s.getSinopse()))
        .collect(Collectors.toList());
    }
}
