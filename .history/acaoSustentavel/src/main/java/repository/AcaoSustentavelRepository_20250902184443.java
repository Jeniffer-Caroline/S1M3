package repository;

import entity.AcaoSustentavel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AcaoSustentavelRepository extends JpaRepository<AcaoSustentavel, Long> {
    List<AcaoSustentavel> findByCategoria(AcaoSustentavel.CategoriaAcao categoria);
    List<AcaoSustentavel> findByDescricaoContainingString (String descricao);
    List<AcaoSustentavel> findByTituloContainingString (String titulo);
    List<AcaoSustentavel> findByDataRealizacaoBetween(LocalDate dataInicio, LocalDate dataFim);
    List<AcaoSustentavel> findByCategoria (Categoria categoria);
}
