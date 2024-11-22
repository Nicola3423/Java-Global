package com.example.global_java.Service;

import com.example.global_java.Entidade.Conteudo;
import com.example.global_java.Entidade.Interacoes;
import com.example.global_java.Entidade.Usuario;
import com.example.global_java.Entidade.DTOs.InteracoesDTO;
import com.example.global_java.Exception.InteracoesNotFoundException;
import com.example.global_java.Repository.ConteudoRepository;
import com.example.global_java.Repository.InteracoesRepository;
import com.example.global_java.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InteracoesService {

    @Autowired
    private InteracoesRepository interacoesRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ConteudoRepository conteudoRepository;

    public Page<InteracoesDTO> listarTodos(Pageable pageable) {
        return interacoesRepository.findAll(pageable)
                .map(this::toDTO);
    }

    public InteracoesDTO buscarPorId(Long id) {
        Interacoes interacao = interacoesRepository.findById(id)
                .orElseThrow(() -> new InteracoesNotFoundException("Interação não encontrada com ID: " + id));
        return toDTO(interacao);
    }

    public InteracoesDTO criar(InteracoesDTO interacoesDTO) {
        Usuario usuario = usuarioRepository.findById(interacoesDTO.getUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com ID: " + interacoesDTO.getUsuarioId()));
        Conteudo conteudo = conteudoRepository.findById(interacoesDTO.getConteudoId())
                .orElseThrow(() -> new IllegalArgumentException("Conteúdo não encontrado com ID: " + interacoesDTO.getConteudoId()));

        Interacoes interacao = new Interacoes();
        interacao.setTipoInteracao(interacoesDTO.getTipoInteracao());
        interacao.setDataInteracao(interacoesDTO.getDataInteracao());
        interacao.setUsuario(usuario);
        interacao.setConteudo(conteudo);

        return toDTO(interacoesRepository.save(interacao));
    }
    public InteracoesDTO atualizar(Long id, InteracoesDTO interacoesDTO) {
        Interacoes interacaoExistente = interacoesRepository.findById(id)
                .orElseThrow(() -> new InteracoesNotFoundException("Interação não encontrada com ID: " + id));

        Usuario usuario = usuarioRepository.findById(interacoesDTO.getUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com ID: " + interacoesDTO.getUsuarioId()));
        Conteudo conteudo = conteudoRepository.findById(interacoesDTO.getConteudoId())
                .orElseThrow(() -> new IllegalArgumentException("Conteúdo não encontrado com ID: " + interacoesDTO.getConteudoId()));

        interacaoExistente.setTipoInteracao(interacoesDTO.getTipoInteracao());
        interacaoExistente.setDataInteracao(interacoesDTO.getDataInteracao());
        interacaoExistente.setUsuario(usuario);
        interacaoExistente.setConteudo(conteudo);

        return toDTO(interacoesRepository.save(interacaoExistente));
    }

    public void deletar(Long id) {
        Interacoes interacao = interacoesRepository.findById(id)
                .orElseThrow(() -> new InteracoesNotFoundException("Interação não encontrada com ID: " + id));
        interacoesRepository.delete(interacao);
    }

    private InteracoesDTO toDTO(Interacoes interacao) {
        return new InteracoesDTO(
                interacao.getInteracaoId(),
                interacao.getTipoInteracao(),
                interacao.getDataInteracao(),
                interacao.getUsuario().getUsuarioId(),
                interacao.getConteudo().getConteudoId()
        );
    }
}
