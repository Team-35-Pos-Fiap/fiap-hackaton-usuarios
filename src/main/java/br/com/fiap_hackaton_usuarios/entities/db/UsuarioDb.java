package br.com.fiap_hackaton_usuarios.entities.db;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
@Getter
@Setter
public class UsuarioDb {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    @Column(unique = true)
    private String email;

    private Boolean ativo;

    @Column(unique = true, length = 11)
    private String cpf;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "id_perfil", columnDefinition = "int")
    private PerfilDb perfil;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_endereco")
    private EnderecoDb dadosEndereco;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_login")
    private LoginDb dadosLogin;

    public void inativar() {
        this.ativo = false;
        this.dataAtualizacao = getDataAtual();
    }

    public void reativar() {
        this.ativo = true;
        this.dataAtualizacao = getDataAtual();
    }

    public void atualizarNome(String nome) {
        this.nome = nome;
        this.dataAtualizacao = getDataAtual();
    }

    public void atualizarEmail(String email) {
        this.email = email;
        this.dataAtualizacao = getDataAtual();
    }

    public void atualizarLogin(String matricula, String senha) {
        this.dadosLogin.atualizarMatricula(matricula);
        this.dadosLogin.atualizarSenha(senha);
        this.dataAtualizacao = getDataAtual();
    }

    public void atualizarCpf(String cpf) {
        this.cpf = cpf;
        this.dataAtualizacao = getDataAtual();
    }

    public void atualizarEndereco(String endereco, String cidade, String bairro,
                                  String estado, Integer numero, String cep, String complemento, Boolean semNumero) {
        this.dadosEndereco.atualizarDados(endereco, cidade, bairro, estado, numero, cep, complemento, semNumero);
        this.dataAtualizacao = getDataAtual();
    }

    public void atualizarPerfil(PerfilDb perfil) {
		this.perfil = perfil;
        this.dataAtualizacao = getDataAtual();
	}

    private LocalDateTime getDataAtual() {
        return LocalDateTime.now();
    }
}
