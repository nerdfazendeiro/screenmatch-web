package br.com.rafaelsilveiradev.controller;

import org.springframework.web.bind.annotation.RestController;
import br.com.rafaelsilveiradev.services.SerieService;
import br.com.rafaelsilveiradev.dto.SerieDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService servico;

    @GetMapping
    public List<SerieDTO> obterSeries() {
        return servico.obterTodasAsSeries();
    }

    @GetMapping("top5")
    public List<SerieDTO> obterTop5Series() {
        return servico.obterTop5Series();
    } 
}
