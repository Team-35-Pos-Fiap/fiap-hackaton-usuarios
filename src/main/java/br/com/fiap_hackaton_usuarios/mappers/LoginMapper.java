package br.com.fiap_hackaton_usuarios.mappers;

import br.com.fiap_hackaton_usuarios.entities.db.LoginDb;
import br.com.fiap_hackaton_usuarios.entities.domain.Login;
import br.com.fiap_hackaton_usuarios.entities.dto.request.LoginDtoRequest;
import br.com.fiap_hackaton_usuarios.entities.dto.response.LoginDtoResponse;
import org.springframework.stereotype.Component;

@Component
public abstract class LoginMapper {

    // dto -> domain -> db

    // 1 - dto -> domain
    public static Login toLogin(LoginDtoRequest login) {
        return new Login(null, login.matricula(), login.senha());
    }

    // 2 - domain -> db

    public static LoginDb toLogin(Login login) {
        return new LoginDb(login.getId(), login.getMatricula(), login.getSenha());
    }

    // db -> domain -> dto

    // 3 - db -> domain

    public static Login toLogin(LoginDb login) {
        return new Login(login.getId(), login.getMatricula(), login.getSenha());
    }

    // 4 - domain -> dto

    public static LoginDtoResponse toLoginDto(Login login) {
        return new LoginDtoResponse(login.getMatricula());
    }
}
