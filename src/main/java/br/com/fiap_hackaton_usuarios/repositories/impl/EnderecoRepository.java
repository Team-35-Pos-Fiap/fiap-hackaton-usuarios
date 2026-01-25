package br.com.fiap_hackaton_usuarios.repositories.impl;

import br.com.fiap_hackaton_usuarios.entities.db.EnderecoDb;
import br.com.fiap_hackaton_usuarios.repositories.interfaces.IEnderecoRepository;
import br.com.fiap_hackaton_usuarios.repositories.interfaces.jpa.IEnderecoJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class EnderecoRepository implements IEnderecoRepository {

    private final IEnderecoJpaRepository enderecoRepository;

    public EnderecoRepository(IEnderecoJpaRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public Optional<EnderecoDb> buscarPorId(UUID id) {
        return enderecoRepository.findById(id);
    }

    @Override
    public void salvar(EnderecoDb endereco) {
        enderecoRepository.save(endereco);
    }
}