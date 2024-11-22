package com.example.global_java.Entidade.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class DicasEconomiaDTO {

    private Long dicaId;

    @NotBlank(message = "O título da dica não pode estar em branco.")
    @Size(max = 100, message = "O título não pode ter mais de 100 caracteres.")
    private String titulo;

    @Size(max = 500, message = "A descrição não pode ter mais de 500 caracteres.")
    private String descricao;

    @NotNull(message = "A data de publicação é obrigatória.")
    private LocalDate dataPublicacao;

    public DicasEconomiaDTO() {
    }

    public DicasEconomiaDTO(Long dicaId, String titulo, String descricao, LocalDate dataPublicacao) {
        this.dicaId = dicaId;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataPublicacao = dataPublicacao;
    }

    public Long getDicaId() {
        return dicaId;
    }

    public void setDicaId(Long dicaId) {
        this.dicaId = dicaId;
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

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
}
