package com.example.global_java.Controller;

import com.example.global_java.Entidade.DTOs.FeedbackDTO;
import com.example.global_java.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public ResponseEntity<Page<FeedbackDTO>> listarTodos(Pageable pageable) {
        Page<FeedbackDTO> feedbacks = feedbackService.listarTodos(pageable);
        return ResponseEntity.ok(feedbacks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedbackDTO> buscarPorId(@PathVariable Long id) {
        FeedbackDTO feedback = feedbackService.buscarPorId(id);
        return ResponseEntity.ok(feedback);
    }

    @PostMapping
    public ResponseEntity<FeedbackDTO> criar(@Valid @RequestBody FeedbackDTO feedbackDTO) {
        FeedbackDTO feedbackCriado = feedbackService.criar(feedbackDTO);
        return ResponseEntity.ok(feedbackCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeedbackDTO> atualizar(@PathVariable Long id, @Valid @RequestBody FeedbackDTO feedbackDTO) {
        FeedbackDTO feedbackAtualizado = feedbackService.atualizar(id, feedbackDTO);
        return ResponseEntity.ok(feedbackAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        feedbackService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
