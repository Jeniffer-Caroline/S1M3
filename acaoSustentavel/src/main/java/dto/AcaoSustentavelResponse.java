package dto;

import entity.AcaoSustentavel;

import java.time.LocalDate;

public class AcaoSustentavelResponse {
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDate dataRealizacao;

    public AcaoSustentavelResponse(AcaoSustentavel acaoSustentavel) {
        this.id = acaoSustentavel.getId();
        this.titulo = acaoSustentavel.getTitulo();
        this.descricao = acaoSustentavel.getDescricao();
        this.dataRealizacao = acaoSustentavel.getDataRealizacao();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(LocalDate dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }
}
