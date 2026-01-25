package br.com.fiap_hackaton_usuarios.repositories.interfaces;

import br.com.fiap_hackaton_usuarios.entities.db.LoginDb;

import java.util.UUID;

public interface ILoginRepository {
    LoginDb buscarPorId(UUID id);
    LoginDb buscarPorMatriculaSenha(String matricula, String senha);
    LoginDb buscarPorMatricula(String matricula);
    void salvar(LoginDb login);
    boolean matriculaJaCadastrada(String matricula);
}
