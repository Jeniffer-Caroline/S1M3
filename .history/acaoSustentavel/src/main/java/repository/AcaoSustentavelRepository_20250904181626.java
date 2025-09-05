package repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.AcaoSustentavel;

public interface AcaoSustentavelRepository extends JpaRepository<AcaoSustentavel, Long> {
    List<AcaoSustentavel> findByCategoria(AcaoSustentavel.CategoriaAcao categoria);
    List<AcaoSustentavel> findByDescricaoContaining (String descricao);
    List<AcaoSustentavel> findByTituloContaining (String titulo);
    List<AcaoSustentavel> findByDataRealizacaoBetween(LocalDate dataInicio, LocalDate dataFim);
}
