package com.example.global_java.Controller;

import com.example.global_java.Entidade.DTOs.InteracoesDTO;
import com.example.global_java.Service.InteracoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/interacoes")
public class InteracoesController {

    @Autowired
    private InteracoesService interacoesService;

    @GetMapping
    public ResponseEntity<Page<InteracoesDTO>> listarTodos(Pageable pageable) {
        Page<InteracoesDTO> interacoes = interacoesService.listarTodos(pageable);
        return ResponseEntity.ok(interacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InteracoesDTO> buscarPorId(@PathVariable Long id) {
        InteracoesDTO interacao = interacoesService.buscarPorId(id);
        return ResponseEntity.ok(interacao);
    }

    @PostMapping
    public ResponseEntity<InteracoesDTO> criar(@Valid @RequestBody InteracoesDTO interacoesDTO) {
        InteracoesDTO interacaoCriada = interacoesService.criar(interacoesDTO);
        return ResponseEntity.ok(interacaoCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InteracoesDTO> atualizar(@PathVariable Long id, @Valid @RequestBody InteracoesDTO interacoesDTO) {
        InteracoesDTO interacaoAtualizada = interacoesService.atualizar(id, interacoesDTO);
        return ResponseEntity.ok(interacaoAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        interacoesService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
