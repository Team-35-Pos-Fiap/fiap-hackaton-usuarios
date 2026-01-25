package br.com.fiap_hackaton_usuarios.repositories.interfaces.jpa;

import br.com.fiap_hackaton_usuarios.entities.db.UsuarioDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface IUsuarioJpaRepository extends JpaRepository<UsuarioDb, UUID> {
    Optional<UsuarioDb> findByIdAndAtivoTrue(UUID id);
    Optional<UsuarioDb> findByIdAndAtivoFalse(UUID id);

    @Query("SELECT u FROM UsuarioDb u INNER JOIN u.dadosLogin dl WHERE dl.id = :id AND u.ativo = true")
    Optional<UsuarioDb> findByIdLogin(@Param("id") UUID loginId);

    boolean existsByEmail(String email);
}
