package br.com.fiap_hackaton_usuarios.repositories.impl;

import br.com.fiap_hackaton_usuarios.entities.db.LoginDb;
import br.com.fiap_hackaton_usuarios.repositories.exceptions.LoginNaoEncontradoException;
import br.com.fiap_hackaton_usuarios.repositories.interfaces.ILoginRepository;
import br.com.fiap_hackaton_usuarios.repositories.interfaces.jpa.ILoginJpaRepository;
import br.com.fiap_hackaton_usuarios.utils.MensagensUtil;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class LoginRepository implements ILoginRepository {

    private final ILoginJpaRepository loginRepository;

    public LoginRepository(ILoginJpaRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public LoginDb buscarPorId(UUID id) {
        return getLoginEntity(loginRepository.findById(id));
    }

    @Override
    public LoginDb buscarPorMatriculaSenha(String matricula, String senha) {
        return getLoginEntity(loginRepository.findByMatriculaAndSenha(matricula, senha));
    }

    @Override
    public LoginDb buscarPorMatricula(String matricula) {
        return getLoginEntity(loginRepository.findByMatricula(matricula));
    }

    @Override
    public void salvar(LoginDb login) {
        loginRepository.save(login);
    }

    @Override
    public boolean matriculaJaCadastrada(String matricula) {
        return loginRepository.existsByMatricula(matricula);
    }

    private LoginDb getLoginEntity(Optional<LoginDb> dadosLogin) {
        if (dadosLogin.isPresent()) {
            return dadosLogin.get();
        } else {
            throw new LoginNaoEncontradoException(MensagensUtil.recuperarMensagem(MensagensUtil.ERRO_LOGIN_NAO_ENCONTRADO));
        }
    }
}