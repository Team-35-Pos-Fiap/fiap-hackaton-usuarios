package br.com.fiap_hackaton_usuarios.entities.dto.response;

import java.util.List;

public record UsuarioPaginacaoDtoResponse(List<UsuarioDtoResponse> usuarios, PaginacaoDtoResponse dadosPaginacao) { }
