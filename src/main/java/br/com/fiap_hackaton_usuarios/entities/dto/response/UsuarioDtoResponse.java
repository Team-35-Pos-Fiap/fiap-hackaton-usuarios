package br.com.fiap_hackaton_usuarios.entities.dto.response;

import br.com.fiap_hackaton_usuarios.entities.dto.request.EnderecoDtoRequest;

import java.util.UUID;

public record UsuarioDtoResponse(UUID id,
                                 String nome,
                                 String email,
                                 String matricula,
                                 Boolean ativo,
                                 String cpf,
                                 EnderecoDtoRequest dadosEndereco,
                                 PerfilDtoResponse perfil) { }