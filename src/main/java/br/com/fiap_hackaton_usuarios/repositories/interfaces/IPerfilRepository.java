package br.com.fiap_hackaton_usuarios.repositories.interfaces;

import br.com.fiap_hackaton_usuarios.entities.db.PerfilDb;

import java.util.List;

public interface IPerfilRepository {
    PerfilDb buscarPorId(Integer id);
    List<PerfilDb> buscarTodos();
}
