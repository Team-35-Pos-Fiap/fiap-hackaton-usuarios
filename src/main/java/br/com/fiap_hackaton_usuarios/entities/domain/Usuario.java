package br.com.fiap_hackaton_usuarios.entities.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Usuario {
    private UUID id;
    private String nome;
    private String email;
    private Boolean ativo;
    private String cpf;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private Perfil perfil;
    private Endereco dadosEndereco;
    private Login dadosLogin;
}
