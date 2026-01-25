package br.com.fiap_hackaton_usuarios.repositories.impl;

import br.com.fiap_hackaton_usuarios.entities.db.UsuarioDb;
import br.com.fiap_hackaton_usuarios.repositories.exceptions.UsuarioNaoEncontradoException;
import br.com.fiap_hackaton_usuarios.repositories.interfaces.IUsuarioRepository;
import br.com.fiap_hackaton_usuarios.repositories.interfaces.jpa.IUsuarioJpaRepository;
import br.com.fiap_hackaton_usuarios.services.exceptions.PaginaInvalidaException;
import br.com.fiap_hackaton_usuarios.utils.MensagensUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class UsuarioRepository implements IUsuarioRepository {

    private final IUsuarioJpaRepository usuarioRepository;
    private final Integer QUANTIDADE_REGISTROS = 5;

    public UsuarioRepository(IUsuarioJpaRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioDb recuperaDadosUsuarioPorId(UUID id) {
        return getUsuarioEntity(usuarioRepository.findById(id));
    }

    @Override
    public UsuarioDb recuperaDadosUsuarioInativoPorId(UUID id) {
        return getUsuarioEntity(usuarioRepository.findByIdAndAtivoFalse(id));
    }

    @Override
    public UsuarioDb recuperaDadosUsuarioAtivoPorId(UUID id) {
        return getUsuarioEntity(usuarioRepository.findByIdAndAtivoTrue(id));
    }

    @Override
    public UsuarioDb recuperarDadosUsuarioPorIdLogin(UUID loginId){
        return getUsuarioEntity(usuarioRepository.findByIdLogin(loginId));
    }

    @Override
    public Page<UsuarioDb> recuperaDadosUsuarios(final Integer pagina) {
        if (pagina == null || pagina < 1) {
            throw new PaginaInvalidaException();
        }
        Page<UsuarioDb> usuarios = usuarioRepository.findAll(PageRequest.of(pagina - 1, QUANTIDADE_REGISTROS));

        if(usuarios.toList().isEmpty()) {
            throw new UsuarioNaoEncontradoException(MensagensUtil.recuperarMensagem(MensagensUtil.ERRO_USUARIOS_NAO_ENCONTRADOS));
        } else {
            return usuarios;
        }
    }

    @Override
    public void salvar(UsuarioDb usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public boolean emailJaCadastrado(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    private UsuarioDb getUsuarioEntity(Optional<UsuarioDb> dadosUsuario) {
        if(dadosUsuario.isPresent()) {
            return dadosUsuario.get();
        } else {
            throw new UsuarioNaoEncontradoException(MensagensUtil.recuperarMensagem(MensagensUtil.ERRO_USUARIO_NAO_ENCONTRADO));
        }
    }
}