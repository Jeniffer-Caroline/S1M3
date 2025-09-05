package service;


import dto.AcaoSustentavelRequest;
import dto.AcaoSustentavelResponse;
import entity.AcaoSustentavel;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AcaoSustentavelRepository;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AcaoSustentavelService {

    @Autowired
    private AcaoSustentavelRepository repository;

    public List<AcaoSustentavelResponse> listarTodasAsAcoes() {
        List<AcaoSustentavel> acoes = repository.findAll();
        return acoes.stream()
                .map(AcaoSustentavelResponse::new)
                .collect(Collectors.toList());
    }

    public AcaoSustentavelResponse buscarAcaoPorId(Long id) {
        AcaoSustentavel acao = repository.findById(id).orElseThrow();
        return new AcaoSustentavelResponse(acao);
    }

    public AcaoSustentavelResponse criarAcaoSustentavel(@NotNull AcaoSustentavelRequest request) {
        AcaoSustentavel acao = new AcaoSustentavel();
        acao.setTitulo(request.getTitulo());
        acao.setDescricao(request.getDescricao());
        acao.setDataRealizacao(request.getDataRealizacao());
        AcaoSustentavel acaoSalva = repository.save(acao);
        return new AcaoSustentavelResponse(acaoSalva);
    }

    public AcaoSustentavelResponse

    atualizarAcaoSustentavel(Long id,@NotNull AcaoSustentavelRequest request) {
        AcaoSustentavel acao = repository.findById(id).orElseThrow();
        acao.setTitulo(request.getTitulo());
        acao.setDescricao(request.getDescricao());
        acao.setDataRealizacao(request.getDataRealizacao());
        AcaoSustentavel acaoAtualizada = repository.save(acao);
        return new AcaoSustentavelResponse(acaoAtualizada);
    }

    public void deletarAcaoSustentavel(Long id) {
        repository.deleteById(id);
    }
}