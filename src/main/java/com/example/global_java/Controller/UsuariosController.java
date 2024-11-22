package com.example.global_java.Controller;

import com.example.global_java.Entidade.DTOs.UsuarioDTO;
import com.example.global_java.Service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping
    public ResponseEntity<Page<UsuarioDTO>> listarTodos(Pageable pageable) {
        Page<UsuarioDTO> usuarios = usuariosService.listarTodos(pageable);
        usuarios.forEach(usuario -> {
            usuario.add(linkTo(methodOn(UsuariosController.class).buscarPorId(usuario.getUsuarioId())).withSelfRel());
            usuario.add(linkTo(methodOn(UsuariosController.class).listarTodos(pageable)).withRel("todos-usuarios"));
        });
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long id) {
        UsuarioDTO usuario = usuariosService.buscarPorId(id);
        usuario.add(linkTo(methodOn(UsuariosController.class).buscarPorId(id)).withSelfRel());
        usuario.add(linkTo(methodOn(UsuariosController.class).listarTodos(Pageable.unpaged())).withRel("todos-usuarios"));
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> criar(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioCriado = usuariosService.criar(usuarioDTO);
        usuarioCriado.add(linkTo(methodOn(UsuariosController.class).buscarPorId(usuarioCriado.getUsuarioId())).withSelfRel());
        usuarioCriado.add(linkTo(methodOn(UsuariosController.class).listarTodos(Pageable.unpaged())).withRel("todos-usuarios"));
        return ResponseEntity.ok(usuarioCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizar(@PathVariable Long id, @Valid @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioAtualizado = usuariosService.atualizar(id, usuarioDTO);
        usuarioAtualizado.add(linkTo(methodOn(UsuariosController.class).buscarPorId(id)).withSelfRel());
        usuarioAtualizado.add(linkTo(methodOn(UsuariosController.class).listarTodos(Pageable.unpaged())).withRel("todos-usuarios"));
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioDTO> deletar(@PathVariable Long id) {
        usuariosService.deletar(id);
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.add(linkTo(methodOn(UsuariosController.class).listarTodos(Pageable.unpaged())).withRel("todos-usuarios"));
        usuarioDTO.add(linkTo(methodOn(UsuariosController.class).criar(new UsuarioDTO())).withRel("criação-de-usuario"));

        return ResponseEntity.ok(usuarioDTO);
    }
}
