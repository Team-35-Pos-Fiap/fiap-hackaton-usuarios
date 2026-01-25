package br.com.fiap_hackaton_usuarios.repositories.interfaces;

import br.com.fiap_hackaton_usuarios.entities.db.UsuarioDb;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface IUsuarioRepository {
    UsuarioDb recuperaDadosUsuarioPorId(UUID id);
    UsuarioDb recuperaDadosUsuarioInativoPorId(UUID id);
    UsuarioDb recuperaDadosUsuarioAtivoPorId(UUID id);
    UsuarioDb recuperarDadosUsuarioPorIdLogin(UUID loginId);
    Page<UsuarioDb> recuperaDadosUsuarios(final Integer pagina);
    void salvar(UsuarioDb usuario);
    boolean emailJaCadastrado(String email);
}