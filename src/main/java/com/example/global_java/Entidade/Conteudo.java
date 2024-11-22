package com.example.global_java.Entidade;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;

@Entity
public class Conteudo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conteudoId;
    @NotBlank
    private String titulo;
    private String descricao;
    private String tipo;

    private LocalDate dataPublicacao = LocalDate.now();

    public Conteudo() {}

    public Conteudo(String descricao, Long conteudoId, String titulo, String tipo, LocalDate dataPublicacao) {
        this.descricao = descricao;
        this.conteudoId = conteudoId;
        this.titulo = titulo;
        this.tipo = tipo;
        this.dataPublicacao = dataPublicacao;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Long getConteudoId() {
        return conteudoId;
    }

    public void setConteudoId(Long conteudoId) {
        this.conteudoId = conteudoId;
    }
}
