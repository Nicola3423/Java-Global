package com.example.global_java.Entidade.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ConteudosDTO {

    private Long conteudoId;

    @NotBlank(message = "O título não pode estar em branco.")
    @Size(max = 100, message = "O título não pode ter mais de 100 caracteres.")
    private String titulo;

    @Size(max = 500, message = "A descrição não pode ter mais de 500 caracteres.")
    private String descricao;

    @NotBlank(message = "O tipo de conteúdo é obrigatório.")
    private String tipo;

    @NotNull(message = "A data de publicação é obrigatória.")
    private LocalDate dataPublicacao;

    public ConteudosDTO() {
    }
    public ConteudosDTO(Long conteudoId, String titulo, String descricao, String tipo, LocalDate dataPublicacao) {
        this.conteudoId = conteudoId;
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.dataPublicacao = dataPublicacao;
    }
    public Long getConteudoId() {
        return conteudoId;
    }

    public void setConteudoId(Long conteudoId) {
        this.conteudoId = conteudoId;
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
}
