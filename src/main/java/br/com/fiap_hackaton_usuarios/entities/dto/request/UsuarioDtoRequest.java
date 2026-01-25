package br.com.fiap_hackaton_usuarios.entities.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record UsuarioDtoRequest(@NotBlank(message = "O campo nome precisa estar preenchido.")
                                @Size(min = 3, max = 150, message = "O campo nome precisa ter entre 3 e 150 caracteres.")
                                String nome,

                                @NotBlank(message = "O campo email precisa estar preenchido.")
                                @Email(message = "O e-mail precisa ser válido")
                                @Size(min = 3, max = 50, message = "O campo email precisa ter entre 3 e 50 caracteres.")
                                String email,

                                @NotBlank(message = "O campo cpf precisa estar preenchido.")
                                @Size(min = 11, max = 11, message = "O campo cpf precisa ter 11 caracteres.")
                                String cpf,

                                @NotNull(message = "É necessário informar o perfil de acesso para o usuário.")
                                @Positive(message = "O id do perfil precisa ser maior do que 0.")
                                Integer perfil,

                                @NotNull(message = "É necessário informar os dados de endereço.")
                                @Valid
                                EnderecoDtoRequest dadosEndereco,

                                @NotNull(message = "É necessário informar os dados de login para o usuário.")
                                @Valid
                                LoginDtoRequest dadosLogin) { }