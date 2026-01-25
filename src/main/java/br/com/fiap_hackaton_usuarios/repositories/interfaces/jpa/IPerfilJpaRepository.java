package br.com.fiap_hackaton_usuarios.repositories.interfaces.jpa;

import br.com.fiap_hackaton_usuarios.entities.db.PerfilDb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPerfilJpaRepository extends JpaRepository<PerfilDb, Integer> { }
