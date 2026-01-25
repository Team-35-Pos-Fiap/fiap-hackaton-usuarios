package br.com.fiap_hackaton_usuarios.entities.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Login {
    private UUID id;
    private String matricula;
    private String senha;
}
