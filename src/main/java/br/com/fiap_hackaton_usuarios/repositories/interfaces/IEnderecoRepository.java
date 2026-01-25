package br.com.fiap_hackaton_usuarios.repositories.interfaces;

import br.com.fiap_hackaton_usuarios.entities.db.EnderecoDb;

import java.util.Optional;
import java.util.UUID;

public interface IEnderecoRepository {
    Optional<EnderecoDb> buscarPorId(UUID id);
    void salvar(EnderecoDb endereco);
}