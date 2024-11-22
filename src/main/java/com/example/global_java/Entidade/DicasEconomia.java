package com.example.global_java.Entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
public class DicasEconomia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dicaId;
    private String titulo;
    private String descricao;
    private LocalDate dataPublicacao = LocalDate.now();

    public DicasEconomia(){

    }
    public DicasEconomia(Long dicaId, String titulo, String descricao, LocalDate dataPublicacao) {
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
