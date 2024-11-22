package com.example.global_java.Controller;

import com.example.global_java.Entidade.DTOs.DicasEconomiaDTO;
import com.example.global_java.Service.DicasEconomiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/dicas-economia")
public class DicasEconomiaController {

    @Autowired
    private DicasEconomiaService dicasEconomiaService;

    @GetMapping
    public ResponseEntity<Page<DicasEconomiaDTO>> listarTodos(Pageable pageable) {
        Page<DicasEconomiaDTO> dicas = dicasEconomiaService.listarTodos(pageable);
        return ResponseEntity.ok(dicas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DicasEconomiaDTO> buscarPorId(@PathVariable Long id) {
        DicasEconomiaDTO dica = dicasEconomiaService.buscarPorId(id);
        return ResponseEntity.ok(dica);
    }
    @PostMapping
    public ResponseEntity<DicasEconomiaDTO> criar(@Valid @RequestBody DicasEconomiaDTO dicasEconomiaDTO) {
        DicasEconomiaDTO dicaCriada = dicasEconomiaService.criar(dicasEconomiaDTO);
        return ResponseEntity.ok(dicaCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DicasEconomiaDTO> atualizar(@PathVariable Long id, @Valid @RequestBody DicasEconomiaDTO dicasEconomiaDTO) {
        DicasEconomiaDTO dicaAtualizada = dicasEconomiaService.atualizar(id, dicasEconomiaDTO);
        return ResponseEntity.ok(dicaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        dicasEconomiaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
