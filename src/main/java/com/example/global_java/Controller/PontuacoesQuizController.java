package com.example.global_java.Controller;

import com.example.global_java.Entidade.DTOs.PontuacoesQuizDTO;
import com.example.global_java.Service.PontuacoesQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pontuacoes-quiz")
public class PontuacoesQuizController {

    @Autowired
    private PontuacoesQuizService pontuacoesQuizService;

    @GetMapping
    public ResponseEntity<Page<PontuacoesQuizDTO>> listarTodos(Pageable pageable) {
        Page<PontuacoesQuizDTO> pontuacoes = pontuacoesQuizService.listarTodos(pageable);
        return ResponseEntity.ok(pontuacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PontuacoesQuizDTO> buscarPorId(@PathVariable Long id) {
        PontuacoesQuizDTO pontuacao = pontuacoesQuizService.buscarPorId(id);
        return ResponseEntity.ok(pontuacao);
    }

    @PostMapping
    public ResponseEntity<PontuacoesQuizDTO> criar(@Valid @RequestBody PontuacoesQuizDTO pontuacoesQuizDTO) {
        PontuacoesQuizDTO pontuacaoCriada = pontuacoesQuizService.criar(pontuacoesQuizDTO);
        return ResponseEntity.ok(pontuacaoCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PontuacoesQuizDTO> atualizar(@PathVariable Long id, @Valid @RequestBody PontuacoesQuizDTO pontuacoesQuizDTO) {
        PontuacoesQuizDTO pontuacaoAtualizada = pontuacoesQuizService.atualizar(id, pontuacoesQuizDTO);
        return ResponseEntity.ok(pontuacaoAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pontuacoesQuizService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
