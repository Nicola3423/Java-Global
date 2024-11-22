package com.example.global_java.Service;

import com.example.global_java.Entidade.PontuacoesQuiz;
import com.example.global_java.Entidade.Usuario;
import com.example.global_java.Entidade.DTOs.PontuacoesQuizDTO;
import com.example.global_java.Exception.PontuacoesQuizNotFoundException;
import com.example.global_java.Repository.PontuacoesQuizRepository;
import com.example.global_java.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PontuacoesQuizService {

    @Autowired
    private PontuacoesQuizRepository pontuacoesQuizRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Page<PontuacoesQuizDTO> listarTodos(Pageable pageable) {
        return pontuacoesQuizRepository.findAll(pageable)
                .map(this::toDTO);
    }

    public PontuacoesQuizDTO buscarPorId(Long id) {
        PontuacoesQuiz pontuacao = pontuacoesQuizRepository.findById(id)
                .orElseThrow(() -> new PontuacoesQuizNotFoundException("Pontuação não encontrada com ID: " + id));
        return toDTO(pontuacao);
    }

    public PontuacoesQuizDTO criar(PontuacoesQuizDTO pontuacoesQuizDTO) {
        Usuario usuario = usuarioRepository.findById(pontuacoesQuizDTO.getUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com ID: " + pontuacoesQuizDTO.getUsuarioId()));

        PontuacoesQuiz pontuacao = new PontuacoesQuiz();
        pontuacao.setPontuacao(pontuacoesQuizDTO.getPontuacao());
        pontuacao.setDataParticipacao(pontuacoesQuizDTO.getDataParticipacao());
        pontuacao.setUsuario(usuario);

        return toDTO(pontuacoesQuizRepository.save(pontuacao));
    }

    public PontuacoesQuizDTO atualizar(Long id, PontuacoesQuizDTO pontuacoesQuizDTO) {
        PontuacoesQuiz pontuacaoExistente = pontuacoesQuizRepository.findById(id)
                .orElseThrow(() -> new PontuacoesQuizNotFoundException("Pontuação não encontrada com ID: " + id));

        Usuario usuario = usuarioRepository.findById(pontuacoesQuizDTO.getUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com ID: " + pontuacoesQuizDTO.getUsuarioId()));

        pontuacaoExistente.setPontuacao(pontuacoesQuizDTO.getPontuacao());
        pontuacaoExistente.setDataParticipacao(pontuacoesQuizDTO.getDataParticipacao());
        pontuacaoExistente.setUsuario(usuario);

        return toDTO(pontuacoesQuizRepository.save(pontuacaoExistente));
    }

    public void deletar(Long id) {
        PontuacoesQuiz pontuacao = pontuacoesQuizRepository.findById(id)
                .orElseThrow(() -> new PontuacoesQuizNotFoundException("Pontuação não encontrada com ID: " + id));
        pontuacoesQuizRepository.delete(pontuacao);
    }
    private PontuacoesQuizDTO toDTO(PontuacoesQuiz pontuacao) {
        return new PontuacoesQuizDTO(
                pontuacao.getPontuacaoId(),
                pontuacao.getPontuacao(),
                pontuacao.getDataParticipacao(),
                pontuacao.getUsuario().getUsuarioId()
        );
    }
}
