package br.com.fiap_hackaton_usuarios.services;

import br.com.fiap_hackaton_usuarios.entities.db.LoginDb;
import br.com.fiap_hackaton_usuarios.entities.dto.request.LoginDtoRequest;
import br.com.fiap_hackaton_usuarios.repositories.exceptions.UsuarioNaoEncontradoException;
import br.com.fiap_hackaton_usuarios.repositories.interfaces.ILoginRepository;
import br.com.fiap_hackaton_usuarios.services.exceptions.LoginSemAcessoException;
import br.com.fiap_hackaton_usuarios.services.interfaces.ILoginService;
import br.com.fiap_hackaton_usuarios.services.interfaces.IUsuarioService;
import br.com.fiap_hackaton_usuarios.utils.MensagensUtil;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILoginService {

    private final ILoginRepository loginRepository;
    private final IUsuarioService usuarioService;

    public LoginService(ILoginRepository loginRepository, IUsuarioService usuarioService) {
        this.loginRepository = loginRepository;
        this.usuarioService = usuarioService;
    }

    @Override
    public String validar(LoginDtoRequest dados) {
        try {
            LoginDb login = loginRepository.buscarPorMatriculaSenha(dados.matricula(), dados.senha());
            usuarioService.buscarUsuarioPorIdLogin(login.getId()); // Serve para validar se usuario esta ativo

            return "Acesso liberado";
        } catch (UsuarioNaoEncontradoException e) {
            throw new LoginSemAcessoException(MensagensUtil.recuperarMensagem(MensagensUtil.ERRO_LOGIN_SEM_PERMISSAO));
        }
    }

    @Override
    public void trocarSenha(String matricula, String senha) {
        LoginDb login = loginRepository.buscarPorMatricula(matricula);
        usuarioService.buscarUsuarioPorIdLogin(login.getId()); // Serve para validar se usuario esta ativo

        login.atualizarSenha(senha);

        loginRepository.salvar(login);
    }

    @Override
    public boolean matriculaJaCadastrada(String matricula) {
        return loginRepository.matriculaJaCadastrada(matricula);
    }
}