package com.example.global_java.Entidade;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class PontuacoesQuiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pontuacaoId;
    private int pontuacao;
    private LocalDate dataParticipacao = LocalDate.now();
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public PontuacoesQuiz() {}
    public PontuacoesQuiz(Long pontuacaoId, int pontuacao, LocalDate dataParticipacao, Usuario usuario) {
        this.pontuacaoId = pontuacaoId;
        this.pontuacao = pontuacao;
        this.dataParticipacao = dataParticipacao;
        this.usuario = usuario;
    }

    public Long getPontuacaoId() {
        return pontuacaoId;
    }

    public void setPontuacaoId(Long pontuacaoId) {
        this.pontuacaoId = pontuacaoId;
    }

    public LocalDate getDataParticipacao() {
        return dataParticipacao;
    }

    public void setDataParticipacao(LocalDate dataParticipacao) {
        this.dataParticipacao = dataParticipacao;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
