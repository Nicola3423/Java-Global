package com.example.global_java.Service;

import com.example.global_java.Entidade.Usuario;
import com.example.global_java.Entidade.DTOs.UsuarioDTO;
import com.example.global_java.Exception.UsuariosNotFoundException;
import com.example.global_java.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Page<UsuarioDTO> listarTodos(Pageable pageable) {
        return usuarioRepository.findAll(pageable)
                .map(this::toDTO);
    }
    public UsuarioDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuariosNotFoundException("Usuário não encontrado com ID: " + id));
        return toDTO(usuario);
    }
    public UsuarioDTO criar(UsuarioDTO usuarioDTO) {
        Usuario usuario = toEntity(usuarioDTO);
        return toDTO(usuarioRepository.save(usuario));
    }
    public UsuarioDTO atualizar(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuariosNotFoundException("Usuário não encontrado com ID: " + id));

        usuarioExistente.setNome(usuarioDTO.getNome());
        usuarioExistente.setEmail(usuarioDTO.getEmail());
        usuarioExistente.setSenha(usuarioDTO.getSenha());
        usuarioExistente.setDataCadastro(usuarioDTO.getDataCadastro());

        return toDTO(usuarioRepository.save(usuarioExistente));
    }
    public void deletar(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuariosNotFoundException("Usuário não encontrado com ID: " + id));
        usuarioRepository.delete(usuario);
    }
    private UsuarioDTO toDTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getUsuarioId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getDataCadastro()
        );
    }
    private Usuario toEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setUsuarioId(usuarioDTO.getUsuarioId());
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setDataCadastro(usuarioDTO.getDataCadastro());
        usuario.setSenha(usuarioDTO.getSenha());
        return usuario;
    }
}
