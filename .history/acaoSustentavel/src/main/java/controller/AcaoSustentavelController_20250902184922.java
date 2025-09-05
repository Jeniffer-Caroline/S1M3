package controller;

import dto.AcaoSustentavelRequest;
import dto.AcaoSustentavelResponse;
import entity.AcaoSustentavel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.AcaoSustentavelService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AcaoSustentavelController {

    @Autowired
    private AcaoSustentavelService acaoSustentavelService;

    @GetMapping("/acoes")
    public ResponseEntity<List<AcaoSustentavelResponse>> listarTodasAsAcoes() {
        List<AcaoSustentavelResponse> response = acaoSustentavelService.listarTodasAsAcoes();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/acoes/{id}")
    public ResponseEntity<AcaoSustentavelResponse> buscarAcaoPorId(@PathVariable Long id) {
        AcaoSustentavelResponse response = acaoSustentavelService.buscarAcaoPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/acoes/categoria")
    public ResponseEntity<List<AcaoSustentavelResponse>> buscarAcoesPorCategoria(@RequestParam("tipo") @Valid Categoria tipo) {
        List<AcaoSustentavel> acoes = acaoSustentavelRepository.findByCategoria(tipo);
        List<AcaoSustentavelResponse> responses = acoes.stream()
                .map(AcaoSustentavelResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @PostMapping("/acoes")
    public ResponseEntity<AcaoSustentavelResponse> criarAcaoSustentavel(@Valid @RequestBody AcaoSustentavelRequest request) {
        AcaoSustentavelResponse response = acaoSustentavelService.criarAcaoSustentavel(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/acoes/{id}")
    public ResponseEntity<AcaoSustentavelResponse> atualizarAcaoSustentavel(@PathVariable Long id, @Valid @RequestBody AcaoSustentavelRequest request) {
        AcaoSustentavelResponse response = acaoSustentavelService.atualizarAcaoSustentavel(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/acoes/{id}")
    public ResponseEntity<Void> deletarAcaoSustentavel(@PathVariable Long id) {
        acaoSustentavelService.deletarAcaoSustentavel(id);
        return ResponseEntity.ok().build();
    }

}
