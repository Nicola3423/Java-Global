package com.example.global_java.Entidade;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;
    @NotBlank
    private String mensagem;
    private LocalDate dataFeedback = LocalDate.now();
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "conteudo_id", nullable = false)
    private Conteudo conteudo;

    public Feedback() {}
    public Feedback(Long feedbackId, Conteudo conteudo, LocalDate dataFeedback, Usuario usuario, String mensagem) {
        this.feedbackId = feedbackId;
        this.conteudo = conteudo;
        this.dataFeedback = dataFeedback;
        this.usuario = usuario;
        this.mensagem = mensagem;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Conteudo getConteudo() {
        return conteudo;
    }

    public void setConteudo(Conteudo conteudo) {
        this.conteudo = conteudo;
    }

}
