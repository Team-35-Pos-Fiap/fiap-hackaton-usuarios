package br.com.fiap_hackaton_usuarios.repositories.impl;

import br.com.fiap_hackaton_usuarios.entities.db.PerfilDb;
import br.com.fiap_hackaton_usuarios.repositories.exceptions.PerfilNaoEncontradoException;
import br.com.fiap_hackaton_usuarios.repositories.interfaces.IPerfilRepository;
import br.com.fiap_hackaton_usuarios.repositories.interfaces.jpa.IPerfilJpaRepository;
import br.com.fiap_hackaton_usuarios.utils.MensagensUtil;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PerfilRepository implements IPerfilRepository {

    private final IPerfilJpaRepository perfilRepository;

    public PerfilRepository(IPerfilJpaRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    @Override
    public PerfilDb buscarPorId(Integer id) {
        return getPerfil(perfilRepository.findById(id));
    }

    @Override
    public List<PerfilDb> buscarTodos() {
        return perfilRepository.findAll();
    }

    private PerfilDb getPerfil(Optional<PerfilDb> dados) {
        if(dados.isPresent()) {
            return dados.get();
        } else {
            throw new PerfilNaoEncontradoException(MensagensUtil.recuperarMensagem(MensagensUtil.ERRO_PERFIL_NAO_ENCONTRADO));
        }
    }
}