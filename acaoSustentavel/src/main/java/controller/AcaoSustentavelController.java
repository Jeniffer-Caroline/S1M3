package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.AcaoSustentavelRequest;
import dto.AcaoSustentavelResponse;
import entity.AcaoSustentavel;
import jakarta.validation.Valid;
import service.AcaoSustentavelService;

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
    public ResponseEntity<List<AcaoSustentavelResponse>> buscarAcoesPorCategoria(@RequestParam("tipo") AcaoSustentavel.CategoriaAcao tipo) {
        List<AcaoSustentavelResponse> responses = acaoSustentavelService.buscarAcoesPorCategoria(tipo);
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
