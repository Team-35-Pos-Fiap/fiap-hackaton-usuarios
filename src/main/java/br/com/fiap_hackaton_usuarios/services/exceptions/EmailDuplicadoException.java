package br.com.fiap_hackaton_usuarios.services.exceptions;

public class EmailDuplicadoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public EmailDuplicadoException(String mensagem) {
        super(mensagem);
    }
}