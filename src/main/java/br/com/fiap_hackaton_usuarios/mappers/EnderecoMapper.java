package br.com.fiap_hackaton_usuarios.mappers;

import br.com.fiap_hackaton_usuarios.entities.db.EnderecoDb;
import br.com.fiap_hackaton_usuarios.entities.domain.Endereco;
import br.com.fiap_hackaton_usuarios.entities.dto.request.EnderecoDtoRequest;
import org.springframework.stereotype.Component;

@Component
public abstract class EnderecoMapper {

    // record -> domain -> entity

    // 1 - dto -> domain
    public static Endereco toDadosEndereco(EnderecoDtoRequest dadosEnderecoDto) {
        return new Endereco(null,
                dadosEnderecoDto.cidade(),
                dadosEnderecoDto.cep(),
                dadosEnderecoDto.bairro(),
                dadosEnderecoDto.endereco(),
                dadosEnderecoDto.estado(),
                dadosEnderecoDto.numero(),
                dadosEnderecoDto.complemento(),
                dadosEnderecoDto.semNumero());
    }

    // 2 - domain -> db
    public static EnderecoDb toDadosEndereco(Endereco dadosEndereco) {
        return new EnderecoDb(dadosEndereco.getId(),
                dadosEndereco.getCidade(),
                dadosEndereco.getCep(),
                dadosEndereco.getBairro(),
                dadosEndereco.getEndereco(),
                dadosEndereco.getEstado(),
                dadosEndereco.getNumero(),
                dadosEndereco.getComplemento(),
                dadosEndereco.getSemNumero());
    }

    // db -> domain -> dto

    // 3 - db -> domain
    public static Endereco toDadosEndereco(EnderecoDb dadosEnderecoDb) {
        return new Endereco(dadosEnderecoDb.getId(),
                dadosEnderecoDb.getCidade(),
                dadosEnderecoDb.getCep(),
                dadosEnderecoDb.getBairro(),
                dadosEnderecoDb.getEndereco(),
                dadosEnderecoDb.getEstado(),
                dadosEnderecoDb.getNumero(),
                dadosEnderecoDb.getComplemento(),
                dadosEnderecoDb.getSemNumero());
    }

    // 4 - domain -> dto
    public static EnderecoDtoRequest toDadosEnderecoDto(Endereco dadosEndereco) {
        return new EnderecoDtoRequest(dadosEndereco.getCidade(),
                dadosEndereco.getCep(),
                dadosEndereco.getBairro(),
                dadosEndereco.getEndereco(),
                dadosEndereco.getEstado(),
                dadosEndereco.getNumero(),
                dadosEndereco.getComplemento(),
                dadosEndereco.getSemNumero());
    }
}