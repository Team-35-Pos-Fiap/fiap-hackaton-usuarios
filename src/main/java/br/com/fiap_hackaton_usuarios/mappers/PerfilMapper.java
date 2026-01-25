package br.com.fiap_hackaton_usuarios.mappers;

import br.com.fiap_hackaton_usuarios.entities.db.PerfilDb;
import br.com.fiap_hackaton_usuarios.entities.domain.Perfil;
import br.com.fiap_hackaton_usuarios.entities.dto.response.PerfilDtoResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class PerfilMapper {

    // dto -> domain -> db

    // 1 - dto -> domain
    public static Perfil toPerfil(Integer idPerfilAcesso) {
        return new Perfil(idPerfilAcesso, null);
    }

    // 2 - domain -> db

    public static PerfilDb toPerfil(Perfil perfil) {
        return new PerfilDb(perfil.getId(), perfil.getNome());
    }

    // db -> domain -> dto

    // 3 - db -> domain

    public static Perfil toPerfil(PerfilDb perfil) {
        return new Perfil(perfil.getId(), perfil.getNome());
    }

    // 4 - domain -> dto

    public static PerfilDtoResponse toPerfilDto(Perfil perfil) {
        return new PerfilDtoResponse(perfil.getId(), perfil.getNome());
    }

    // 5 - list db -> list dto
    public static List<PerfilDtoResponse> toListaPerfilDto(List<PerfilDb> dados) {
        List<PerfilDtoResponse> perfis = dados.stream()
                .map(PerfilMapper::toPerfil)
                .map(PerfilMapper::toPerfilDto)
                .toList();

        return perfis;
    }
}
