package com.example.global_java.Entidade;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Interacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interacaoId;
    private String tipoInteracao;
    private LocalDate dataInteracao = LocalDate.now();
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "conteudo_id", nullable = false)
    private Conteudo conteudo;

    public Interacoes() {}
    public Interacoes(Long interacaoId, Conteudo conteudo, Usuario usuario, String tipoInteracao, LocalDate dataInteracao) {
        this.interacaoId = interacaoId;
        this.conteudo = conteudo;
        this.usuario = usuario;
        this.tipoInteracao = tipoInteracao;
        this.dataInteracao = dataInteracao;
    }
    public LocalDate getDataInteracao() {
        return dataInteracao;
    }

    public void setDataInteracao(LocalDate dataInteracao) {
        this.dataInteracao = dataInteracao;
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

    public String getTipoInteracao() {
        return tipoInteracao;
    }

    public void setTipoInteracao(String tipoInteracao) {
        this.tipoInteracao = tipoInteracao;
    }

    public Long getInteracaoId() {
        return interacaoId;
    }

    public void setInteracaoId(Long interacaoId) {
        this.interacaoId = interacaoId;
    }
}
