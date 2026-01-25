package br.com.fiap_hackaton_usuarios.services;

import br.com.fiap_hackaton_usuarios.entities.db.PerfilDb;
import br.com.fiap_hackaton_usuarios.entities.dto.response.PerfilDtoResponse;
import br.com.fiap_hackaton_usuarios.mappers.PerfilMapper;
import br.com.fiap_hackaton_usuarios.repositories.interfaces.IPerfilRepository;
import br.com.fiap_hackaton_usuarios.services.interfaces.IPerfilService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService implements IPerfilService {

    private final IPerfilRepository perfilRepository;

    public PerfilService(IPerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    @Override
    public PerfilDb buscarPorId(Integer id) {
        return perfilRepository.buscarPorId(id);
    }

    @Override
    public List<PerfilDtoResponse> buscarTodos() {
        return PerfilMapper.toListaPerfilDto(perfilRepository.buscarTodos());
    }
}