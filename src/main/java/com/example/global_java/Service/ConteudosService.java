package com.example.global_java.Service;

import com.example.global_java.Entidade.Conteudo;
import com.example.global_java.Entidade.DTOs.ConteudosDTO;
import com.example.global_java.Exception.ConteudosNotFoundException;
import com.example.global_java.Repository.ConteudoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ConteudosService {

    @Autowired
    private ConteudoRepository conteudoRepository;

    public Page<ConteudosDTO> listarTodos(Pageable pageable) {
        return conteudoRepository.findAll(pageable)
                .map(this::toDTO);
    }

    public ConteudosDTO buscarPorId(Long id) {
        Conteudo conteudo = conteudoRepository.findById(id)
                .orElseThrow(() -> new ConteudosNotFoundException("Conteúdo não encontrado com ID: " + id));
        return toDTO(conteudo);
    }

    public ConteudosDTO criar(ConteudosDTO conteudosDTO) {
        Conteudo conteudo = toEntity(conteudosDTO);
        return toDTO(conteudoRepository.save(conteudo));
    }

    public ConteudosDTO atualizar(Long id, ConteudosDTO conteudosDTO) {
        Conteudo conteudoExistente = conteudoRepository.findById(id)
                .orElseThrow(() -> new ConteudosNotFoundException("Conteúdo não encontrado com ID: " + id));

        conteudoExistente.setTitulo(conteudosDTO.getTitulo());
        conteudoExistente.setDescricao(conteudosDTO.getDescricao());
        conteudoExistente.setDataPublicacao(conteudosDTO.getDataPublicacao());

        return toDTO(conteudoRepository.save(conteudoExistente));
    }
    public void deletar(Long id) {
        Conteudo conteudo = conteudoRepository.findById(id)
                .orElseThrow(() -> new ConteudosNotFoundException("Conteúdo não encontrado com ID: " + id));
        conteudoRepository.delete(conteudo);
    }
    private ConteudosDTO toDTO(Conteudo conteudo) {
        return new ConteudosDTO(
                conteudo.getConteudoId(),
                conteudo.getTipo(),
                conteudo.getDescricao(),
                conteudo.getTipo(),
                conteudo.getDataPublicacao()
        );
    }

    private Conteudo toEntity(ConteudosDTO conteudosDTO) {
        Conteudo conteudo = new Conteudo();
        conteudo.setConteudoId(conteudosDTO.getConteudoId());
        conteudo.setTitulo(conteudosDTO.getTitulo());
        conteudo.setDescricao(conteudosDTO.getDescricao());
        conteudo.setDataPublicacao(conteudosDTO.getDataPublicacao());
        conteudo.setTipo(conteudosDTO.getTipo());
        return conteudo;
    }
}
