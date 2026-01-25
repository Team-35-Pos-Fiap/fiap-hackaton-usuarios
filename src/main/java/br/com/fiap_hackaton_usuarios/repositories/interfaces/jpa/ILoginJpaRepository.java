package br.com.fiap_hackaton_usuarios.repositories.interfaces.jpa;

import br.com.fiap_hackaton_usuarios.entities.db.LoginDb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ILoginJpaRepository extends JpaRepository<LoginDb, UUID> {
    Optional<LoginDb> findByMatriculaAndSenha(String matricula, String senha);
    Optional<LoginDb> findByMatricula(String matricula);
    boolean existsByMatricula(String matricula);
}
