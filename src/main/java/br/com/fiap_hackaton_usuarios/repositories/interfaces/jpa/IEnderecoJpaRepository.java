package br.com.fiap_hackaton_usuarios.repositories.interfaces.jpa;

import br.com.fiap_hackaton_usuarios.entities.db.EnderecoDb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IEnderecoJpaRepository extends JpaRepository<EnderecoDb, UUID> {
}
