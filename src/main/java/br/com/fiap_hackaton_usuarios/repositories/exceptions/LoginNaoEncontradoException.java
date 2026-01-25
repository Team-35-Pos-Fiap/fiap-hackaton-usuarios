package br.com.fiap_hackaton_usuarios.repositories.exceptions;

public class LoginNaoEncontradoException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public LoginNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}