package br.com.fiap_hackaton_usuarios.services.interfaces;

import br.com.fiap_hackaton_usuarios.entities.db.UsuarioDb;
import br.com.fiap_hackaton_usuarios.entities.dto.request.EnderecoDtoRequest;
import br.com.fiap_hackaton_usuarios.entities.dto.request.UsuarioDtoRequest;
import br.com.fiap_hackaton_usuarios.entities.dto.response.UsuarioDtoResponse;
import br.com.fiap_hackaton_usuarios.entities.dto.response.UsuarioPaginacaoDtoResponse;

import java.util.UUID;

public interface IUsuarioService {
    UsuarioDtoResponse buscarPorId(UUID id);
    UsuarioPaginacaoDtoResponse buscarUsuarios(final Integer pagina);
    void cadastrar(UsuarioDtoRequest usuario);
    void atualizarStatus(UUID id, boolean isAtivo);
    void salvar(UsuarioDb usuario);
    void atualizarPerfil(UUID id, Integer idPerfil);
    void atualizarNome(UUID id, String nome);
    void atualizarEmail(UUID id, String email);
    UsuarioDb buscarUsuarioPorIdLogin(UUID loginId);
    void atualizarDadosEndereco(UUID id, EnderecoDtoRequest dadosEndereco);
}
