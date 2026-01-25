package br.com.fiap_hackaton_usuarios.services.interfaces;

import br.com.fiap_hackaton_usuarios.entities.db.EnderecoDb;
import br.com.fiap_hackaton_usuarios.entities.dto.request.EnderecoDtoRequest;

public interface IEnderecoService {
    void atualizarEndereco(EnderecoDb enderecoAtual, EnderecoDtoRequest dados);
}
