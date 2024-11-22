package com.example.global_java.Service;

import com.example.global_java.Entidade.Conteudo;
import com.example.global_java.Entidade.Feedback;
import com.example.global_java.Entidade.Usuario;
import com.example.global_java.Entidade.DTOs.FeedbackDTO;
import com.example.global_java.Exception.FeedbackNotFoundException;
import com.example.global_java.Repository.ConteudoRepository;
import com.example.global_java.Repository.FeedbackRepository;
import com.example.global_java.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ConteudoRepository conteudoRepository;

    public Page<FeedbackDTO> listarTodos(Pageable pageable) {
        return feedbackRepository.findAll(pageable)
                .map(this::toDTO);
    }
    public FeedbackDTO buscarPorId(Long id) {
        Feedback feedback = feedbackRepository.findById(id)
                .orElseThrow(() -> new FeedbackNotFoundException("Feedback não encontrado com ID: " + id));
        return toDTO(feedback);
    }

    public FeedbackDTO criar(FeedbackDTO feedbackDTO) {
        Usuario usuario = usuarioRepository.findById(feedbackDTO.getUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com ID: " + feedbackDTO.getUsuarioId()));
        Conteudo conteudo = conteudoRepository.findById(feedbackDTO.getConteudoId())
                .orElseThrow(() -> new IllegalArgumentException("Conteúdo não encontrado com ID: " + feedbackDTO.getConteudoId()));

        Feedback feedback = new Feedback();
        feedback.setMensagem(feedbackDTO.getMensagem());
        feedback.setDataFeedback(feedbackDTO.getDataFeedback());
        feedback.setUsuario(usuario);
        feedback.setConteudo(conteudo);

        return toDTO(feedbackRepository.save(feedback));
    }
    public FeedbackDTO atualizar(Long id, FeedbackDTO feedbackDTO) {
        Feedback feedbackExistente = feedbackRepository.findById(id)
                .orElseThrow(() -> new FeedbackNotFoundException("Feedback não encontrado com ID: " + id));

        Usuario usuario = usuarioRepository.findById(feedbackDTO.getUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com ID: " + feedbackDTO.getUsuarioId()));
        Conteudo conteudo = conteudoRepository.findById(feedbackDTO.getConteudoId())
                .orElseThrow(() -> new IllegalArgumentException("Conteúdo não encontrado com ID: " + feedbackDTO.getConteudoId()));

        feedbackExistente.setMensagem(feedbackDTO.getMensagem());
        feedbackExistente.setDataFeedback(feedbackDTO.getDataFeedback());
        feedbackExistente.setUsuario(usuario);
        feedbackExistente.setConteudo(conteudo);

        return toDTO(feedbackRepository.save(feedbackExistente));
    }

    public void deletar(Long id) {
        Feedback feedback = feedbackRepository.findById(id)
                .orElseThrow(() -> new FeedbackNotFoundException("Feedback não encontrado com ID: " + id));
        feedbackRepository.delete(feedback);
    }

    private FeedbackDTO toDTO(Feedback feedback) {
        return new FeedbackDTO(
                feedback.getFeedbackId(),
                feedback.getMensagem(),
                feedback.getDataFeedback(),
                feedback.getUsuario().getUsuarioId(),
                feedback.getConteudo().getConteudoId()
        );
    }
}
