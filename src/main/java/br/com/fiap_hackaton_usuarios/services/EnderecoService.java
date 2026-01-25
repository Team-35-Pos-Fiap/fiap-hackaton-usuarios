package br.com.fiap_hackaton_usuarios.services;

import br.com.fiap_hackaton_usuarios.entities.db.EnderecoDb;
import br.com.fiap_hackaton_usuarios.entities.dto.request.EnderecoDtoRequest;
import br.com.fiap_hackaton_usuarios.repositories.interfaces.IEnderecoRepository;
import br.com.fiap_hackaton_usuarios.services.interfaces.IEnderecoService;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService implements IEnderecoService {

    private final IEnderecoRepository enderecoRepository;

    public EnderecoService(IEnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public void atualizarEndereco(EnderecoDb enderecoAtual, EnderecoDtoRequest dados) {
        enderecoRepository.salvar(trataDadosEndereco(enderecoAtual, dados));
    }

    private EnderecoDb trataDadosEndereco(EnderecoDb endereco, EnderecoDtoRequest enderecoRecord) {
        endereco.atualizarDados(enderecoRecord.endereco(),
                enderecoRecord.cidade(),
                enderecoRecord.bairro(),
                enderecoRecord.estado(),
                enderecoRecord.numero(),
                enderecoRecord.cep(),
                enderecoRecord.complemento(),
                enderecoRecord.semNumero());

        return endereco;
    }
}