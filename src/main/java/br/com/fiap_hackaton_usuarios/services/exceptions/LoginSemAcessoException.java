package br.com.fiap_hackaton_usuarios.services.exceptions;

public class LoginSemAcessoException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public LoginSemAcessoException(String mensagem) {
        super(mensagem);
    }
}