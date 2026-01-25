package br.com.fiap_hackaton_usuarios.mappers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap_hackaton_usuarios.entities.db.UsuarioDb;
import br.com.fiap_hackaton_usuarios.entities.domain.Usuario;
import br.com.fiap_hackaton_usuarios.entities.dto.request.UsuarioDtoRequest;
import br.com.fiap_hackaton_usuarios.entities.dto.response.PaginacaoDtoResponse;
import br.com.fiap_hackaton_usuarios.entities.dto.response.UsuarioDtoResponse;
import br.com.fiap_hackaton_usuarios.entities.dto.response.UsuarioPaginacaoDtoResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public abstract class UsuarioMapper {

    // dto -> domain -> db

    // 1 - dto -> domain

    public static Usuario toUsuario(UsuarioDtoRequest usuario) {
        return new Usuario(null,
                usuario.nome(),
                usuario.email(),
                true,
                usuario.cpf(),
                LocalDateTime.now(),
                null,
                PerfilMapper.toPerfil(usuario.perfil()),
                EnderecoMapper.toDadosEndereco(usuario.dadosEndereco()),
                LoginMapper.toLogin(usuario.dadosLogin()));
    }

    // 2 - domain -> db

    public static UsuarioDb toUsuarioDb(Usuario usuario) {
        return new UsuarioDb(usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getAtivo(),
                usuario.getCpf(),
                usuario.getDataCriacao(),
                usuario.getDataAtualizacao(),
                PerfilMapper.toPerfil(usuario.getPerfil()),
                EnderecoMapper.toDadosEndereco(usuario.getDadosEndereco()),
                LoginMapper.toLogin(usuario.getDadosLogin()));
    }

    // db -> domain -> dto

    // 3 - db -> domain

    public static Usuario toUsuario(UsuarioDb usuario) {
        return new Usuario(usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getAtivo(),
                usuario.getCpf(),
                usuario.getDataCriacao(),
                usuario.getDataAtualizacao(),
                PerfilMapper.toPerfil(usuario.getPerfil()),
                EnderecoMapper.toDadosEndereco(usuario.getDadosEndereco()),
                LoginMapper.toLogin(usuario.getDadosLogin()));
    }

    // 4 - domain -> dto

    public static UsuarioDtoResponse toUsuarioDtoResponse(Usuario usuario) {
        return new UsuarioDtoResponse(usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getDadosLogin().getMatricula(),
                usuario.getAtivo(),
                usuario.getCpf(),
                EnderecoMapper.toDadosEnderecoDto(usuario.getDadosEndereco()),
                PerfilMapper.toPerfilDto(usuario.getPerfil()));
    }

    public static UsuarioPaginacaoDtoResponse toUsuarioPaginacaoDtoResponse(Page<UsuarioDb> dados) {
        List<UsuarioDtoResponse> usuarios = dados.toList()
                .stream()
                .map(u -> UsuarioMapper.toUsuario(u))
                .map(u -> UsuarioMapper.toUsuarioDtoResponse(u))
                .collect(Collectors.toList());

        PaginacaoDtoResponse dadosPaginacao = new PaginacaoDtoResponse(dados.getNumber() + 1, dados.getTotalPages(), Long.valueOf(dados.getTotalElements()).intValue());

        return new UsuarioPaginacaoDtoResponse(usuarios, dadosPaginacao);
    }
}
