package com.example.global_java.Entidade.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class FeedbackDTO {

    private Long feedbackId;

    @NotBlank(message = "A mensagem não pode estar em branco.")
    private String mensagem;

    @NotNull(message = "A data de feedback é obrigatória.")
    private LocalDate dataFeedback;

    @NotNull(message = "O ID do usuário é obrigatório.")
    private Long usuarioId;

    @NotNull(message = "O ID do conteúdo é obrigatório.")
    private Long conteudoId;

    public FeedbackDTO() {
    }
    public FeedbackDTO(Long feedbackId, String mensagem, LocalDate dataFeedback, Long usuarioId, Long conteudoId) {
        this.feedbackId = feedbackId;
        this.mensagem = mensagem;
        this.dataFeedback = dataFeedback;
        this.usuarioId = usuarioId;
        this.conteudoId = conteudoId;
    }

    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDate getDataFeedback() {
        return dataFeedback;
    }

    public void setDataFeedback(LocalDate dataFeedback) {
        this.dataFeedback = dataFeedback;
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
