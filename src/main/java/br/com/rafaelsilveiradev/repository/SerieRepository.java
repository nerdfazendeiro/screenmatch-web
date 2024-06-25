package br.com.rafaelsilveiradev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.rafaelsilveiradev.model.Serie;
import br.com.rafaelsilveiradev.model.Categoria;
import br.com.rafaelsilveiradev.model.Episodio;
public interface SerieRepository extends JpaRepository<Serie, Long>{
    Optional<Serie> findByTituloContainingIgnoreCase(String nomeSerie);

    List<Serie> findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(String nomeAtor, Double avaliacao);

    List<Serie> findTop5ByOrderByAvaliacaoDesc();

    List<Serie> findByGenero(Categoria categoria);

    List<Serie> findByTotalTemporadasLessThanEqualAndAvaliacaoGreaterThanEqual(int qtdTemporada, Double avaliacao);

    @Query("SELECT s FROM Serie s WHERE s.totalTemporadas <= :qtdTemporada AND s.avaliacao >= :avaliacao")
    List<Serie> seriesPorTemporadaeAvaliacao(int qtdTemporada, Double avaliacao);

    @Query("SELECT e FROM Serie s JOIN s.episodio e WHERE e.titulo ILIKE %:trechoEpisodio%")
    List<Episodio> episodiosPorTrecho(String trechoEpisodio);

    @Query("SELECT e FROM Serie s JOIN s.episodio e WHERE s = :serie ORDER BY e.avaliacao DESC LIMIT 5")
    List<Episodio> topEpisodioPorSerie(Serie serie);

    @Query("SELECT e FROM Serie s JOIN s.episodio e WHERE s = :serie AND YEAR(e.dataLancamento) >= :anoLancamento")
    List<Episodio> episodioPorSerieEAno(Serie serie, int anoLancamento);

    List<Serie> findTop5ByOrderByEpisodioDataLancamentoDesc();
}
