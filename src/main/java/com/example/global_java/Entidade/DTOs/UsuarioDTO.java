package com.example.global_java.Entidade.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

public class UsuarioDTO extends RepresentationModel<UsuarioDTO> {

    private Long usuarioId;

    @NotBlank(message = "O nome do usuário não pode estar em branco.")
    @Size(max = 100, message = "O nome não pode ter mais de 100 caracteres.")
    private String nome;

    @NotBlank(message = "O email do usuário é obrigatório.")
    @Email(message = "O email fornecido não é válido.")
    private String email;

    @NotBlank(message = "A senha do usuário é obrigatória.")
    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres.")
    private String senha;

    @NotNull(message = "A data de cadastro é obrigatória.")
    private LocalDate dataCadastro;

    public UsuarioDTO() {
    }
    public UsuarioDTO(Long usuarioId, String nome, String email, String senha, LocalDate dataCadastro) {
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
