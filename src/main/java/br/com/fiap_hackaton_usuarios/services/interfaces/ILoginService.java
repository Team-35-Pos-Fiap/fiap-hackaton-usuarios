package br.com.fiap_hackaton_usuarios.services.interfaces;

import br.com.fiap_hackaton_usuarios.entities.dto.request.LoginDtoRequest;

public interface ILoginService {
    String validar(LoginDtoRequest dados);
    void trocarSenha(String matricula, String senha);
    boolean matriculaJaCadastrada(String matricula);
}
