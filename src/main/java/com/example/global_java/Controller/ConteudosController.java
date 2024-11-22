package com.example.global_java.Controller;

import com.example.global_java.Entidade.DTOs.ConteudosDTO;
import com.example.global_java.Service.ConteudosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/conteudos")
public class ConteudosController {

    @Autowired
    private ConteudosService conteudosService;

    @GetMapping
    public ResponseEntity<Page<ConteudosDTO>> listarTodos(Pageable pageable) {
        Page<ConteudosDTO> conteudos = conteudosService.listarTodos(pageable);
        return ResponseEntity.ok(conteudos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConteudosDTO> buscarPorId(@PathVariable Long id) {
        ConteudosDTO conteudo = conteudosService.buscarPorId(id);
        return ResponseEntity.ok(conteudo);
    }

    @PostMapping
    public ResponseEntity<ConteudosDTO> criar(@Valid @RequestBody ConteudosDTO conteudosDTO) {
        ConteudosDTO conteudoCriado = conteudosService.criar(conteudosDTO);
        return ResponseEntity.ok(conteudoCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConteudosDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ConteudosDTO conteudosDTO) {
        ConteudosDTO conteudoAtualizado = conteudosService.atualizar(id, conteudosDTO);
        return ResponseEntity.ok(conteudoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        conteudosService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
