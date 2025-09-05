package entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "acao_sustentavel", uniqueConstraints = @UniqueConstraint(columnNames = "titulo"))
public class AcaoSustentavel {
    public AcaoSustentavel() {
    }
    public AcaoSustentavel(String titulo, String descricao, LocalDate dataRealizacao){
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataRealizacao = dataRealizacao;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, length = 100)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private CategoriaAcao categoria;

    @Column(nullable = false)
    private LocalDate dataRealizacao;

    @Column(nullable = false, length = 100)
    private String responsavel;

    //Getters e Setters


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

    public CategoriaAcao getCategoriaAcao() {
        return categoria;
    }

    public void setCategoriaAcao(CategoriaAcao categoriaAcao) {
        this.categoria = categoriaAcao;
    }

    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(LocalDate dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public enum CategoriaAcao {
        DOACAO("Doação", "Doação de recursos ou materiais para causas ambientais"),
        RECICLAGEM("Reciclagem", "Reciclagem de materiais para reduzir o impacto ambiental"),
        PLANTIO("Plantio", "Plantio de árvores ou outras plantas para promover a biodiversidade e reduzir a poluição"),
        EDUCACAO_AMBIENTAL("Educação Ambiental", "Educação e conscientização sobre questões ambientais"),
        OUTROS("Outros", "Outras categorias de ações sustentáveis que não se enquadram nas anteriores");

        private String nome;
        private String descricao;

        CategoriaAcao(String nome, String descricao) {
            this.nome = nome;
            this.descricao = descricao;
        }

        public String getNome() {
            return nome;
        }

        public String getDescricao() {
            return descricao;
        }
    }
}

