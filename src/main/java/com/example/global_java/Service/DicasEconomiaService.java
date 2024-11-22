package com.example.global_java.Service;

import com.example.global_java.Entidade.DicasEconomia;
import com.example.global_java.Entidade.DTOs.DicasEconomiaDTO;
import com.example.global_java.Exception.Dicas_EconomiaNotFoundException;
import com.example.global_java.Repository.DicasEconomiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DicasEconomiaService {

    @Autowired
    private DicasEconomiaRepository dicasEconomiaRepository;

    public Page<DicasEconomiaDTO> listarTodos(Pageable pageable) {
        return dicasEconomiaRepository.findAll(pageable)
                .map(this::toDTO);
    }

    public DicasEconomiaDTO buscarPorId(Long id) {
        DicasEconomia dicasEconomia = dicasEconomiaRepository.findById(id)
                .orElseThrow(() -> new Dicas_EconomiaNotFoundException("Dica não encontrada com ID: " + id));
        return toDTO(dicasEconomia);
    }

    public DicasEconomiaDTO criar(DicasEconomiaDTO dicasEconomiaDTO) {
        DicasEconomia dicasEconomia = toEntity(dicasEconomiaDTO);
        return toDTO(dicasEconomiaRepository.save(dicasEconomia));
    }
    public DicasEconomiaDTO atualizar(Long id, DicasEconomiaDTO dicasEconomiaDTO) {
        DicasEconomia dicasExistente = dicasEconomiaRepository.findById(id)
                .orElseThrow(() -> new Dicas_EconomiaNotFoundException("Dica não encontrada com ID: " + id));

        dicasExistente.setTitulo(dicasEconomiaDTO.getTitulo());
        dicasExistente.setDescricao(dicasEconomiaDTO.getDescricao());
        dicasExistente.setDataPublicacao(dicasEconomiaDTO.getDataPublicacao());

        return toDTO(dicasEconomiaRepository.save(dicasExistente));
    }
    public void deletar(Long id) {
        DicasEconomia dicasEconomia = dicasEconomiaRepository.findById(id)
                .orElseThrow(() -> new Dicas_EconomiaNotFoundException("Dica não encontrada com ID: " + id));
        dicasEconomiaRepository.delete(dicasEconomia);
    }

    private DicasEconomiaDTO toDTO(DicasEconomia dicasEconomia) {
        return new DicasEconomiaDTO(
                dicasEconomia.getDicaId(),
                dicasEconomia.getTitulo(),
                dicasEconomia.getDescricao(),
                dicasEconomia.getDataPublicacao()
        );
    }
    private DicasEconomia toEntity(DicasEconomiaDTO dicasEconomiaDTO) {
        DicasEconomia dicasEconomia = new DicasEconomia();
        dicasEconomia.setDicaId(dicasEconomiaDTO.getDicaId());
        dicasEconomia.setTitulo(dicasEconomiaDTO.getTitulo());
        dicasEconomia.setDescricao(dicasEconomiaDTO.getDescricao());
        dicasEconomia.setDataPublicacao(dicasEconomiaDTO.getDataPublicacao());
        return dicasEconomia;
    }
}
