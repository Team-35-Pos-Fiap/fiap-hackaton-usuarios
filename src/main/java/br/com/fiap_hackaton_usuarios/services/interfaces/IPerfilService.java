package br.com.fiap_hackaton_usuarios.services.interfaces;

import br.com.fiap_hackaton_usuarios.entities.db.PerfilDb;
import br.com.fiap_hackaton_usuarios.entities.dto.response.PerfilDtoResponse;

import java.util.List;

public interface IPerfilService {
    PerfilDb buscarPorId(Integer id);
    List<PerfilDtoResponse> buscarTodos();
}
