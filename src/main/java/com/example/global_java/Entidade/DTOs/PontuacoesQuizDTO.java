package com.example.global_java.Entidade.DTOs;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class PontuacoesQuizDTO {

    private Long pontuacaoId;

    @Min(value = 0, message = "A pontuação deve ser maior ou igual a 0.")
    private int pontuacao;

    @NotNull(message = "A data de participação é obrigatória.")
    private LocalDate dataParticipacao;

    @NotNull(message = "O ID do usuário é obrigatório.")
    private Long usuarioId;

    public PontuacoesQuizDTO() {
    }

    public PontuacoesQuizDTO(Long pontuacaoId, int pontuacao, LocalDate dataParticipacao, Long usuarioId) {
        this.pontuacaoId = pontuacaoId;
        this.pontuacao = pontuacao;
        this.dataParticipacao = dataParticipacao;
        this.usuarioId = usuarioId;
    }

    public Long getPontuacaoId() {
        return pontuacaoId;
    }

    public void setPontuacaoId(Long pontuacaoId) {
        this.pontuacaoId = pontuacaoId;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public LocalDate getDataParticipacao() {
        return dataParticipacao;
    }

    public void setDataParticipacao(LocalDate dataParticipacao) {
        this.dataParticipacao = dataParticipacao;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
