package com.example.global_java.Entidade.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class InteracoesDTO {

    private Long interacaoId;

    @NotBlank(message = "O tipo de interação não pode estar em branco.")
    private String tipoInteracao;

    @NotNull(message = "A data da interação é obrigatória.")
    private LocalDate dataInteracao;

    @NotNull(message = "O ID do usuário é obrigatório.")
    private Long usuarioId;

    @NotNull(message = "O ID do conteúdo é obrigatório.")
    private Long conteudoId;

    public InteracoesDTO() {
    }

    public InteracoesDTO(Long interacaoId, String tipoInteracao, LocalDate dataInteracao, Long usuarioId, Long conteudoId) {
        this.interacaoId = interacaoId;
        this.tipoInteracao = tipoInteracao;
        this.dataInteracao = dataInteracao;
        this.usuarioId = usuarioId;
        this.conteudoId = conteudoId;
    }

    public Long getInteracaoId() {
        return interacaoId;
    }

    public void setInteracaoId(Long interacaoId) {
        this.interacaoId = interacaoId;
    }

    public String getTipoInteracao() {
        return tipoInteracao;
    }

    public void setTipoInteracao(String tipoInteracao) {
        this.tipoInteracao = tipoInteracao;
    }

    public LocalDate getDataInteracao() {
        return dataInteracao;
    }

    public void setDataInteracao(LocalDate dataInteracao) {
        this.dataInteracao = dataInteracao;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getConteudoId() {
        return conteudoId;
    }

    public void setConteudoId(Long conteudoId) {
        this.conteudoId = conteudoId;
    }
}
