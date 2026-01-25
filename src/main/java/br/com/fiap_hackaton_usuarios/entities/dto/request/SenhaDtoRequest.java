package br.com.fiap_hackaton_usuarios.entities.dto.request;

import jakarta.validation.constraints.NotBlank;


public record SenhaDtoRequest(@NotBlank(message = "O campo senha precisa estar preenchido.")
                              String senha) { }
