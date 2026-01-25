package br.com.fiap_hackaton_usuarios.services;

import br.com.fiap_hackaton_usuarios.entities.db.PerfilDb;
import br.com.fiap_hackaton_usuarios.entities.db.UsuarioDb;
import br.com.fiap_hackaton_usuarios.entities.domain.Usuario;
import br.com.fiap_hackaton_usuarios.entities.dto.request.EnderecoDtoRequest;
import br.com.fiap_hackaton_usuarios.entities.dto.request.UsuarioDtoRequest;
import br.com.fiap_hackaton_usuarios.entities.dto.response.UsuarioDtoResponse;
import br.com.fiap_hackaton_usuarios.entities.dto.response.UsuarioPaginacaoDtoResponse;
import br.com.fiap_hackaton_usuarios.mappers.UsuarioMapper;
import br.com.fiap_hackaton_usuarios.repositories.interfaces.IUsuarioRepository;
import br.com.fiap_hackaton_usuarios.services.exceptions.EmailDuplicadoException;
import br.com.fiap_hackaton_usuarios.services.interfaces.IEnderecoService;
import br.com.fiap_hackaton_usuarios.services.interfaces.IPerfilService;
import br.com.fiap_hackaton_usuarios.services.interfaces.IUsuarioService;
import br.com.fiap_hackaton_usuarios.utils.MensagensUtil;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioService implements IUsuarioService {

    private final IUsuarioRepository usuarioRepository;
    private final IPerfilService perfilService;
    private final IEnderecoService enderecoService;

    public UsuarioService(IUsuarioRepository usuarioRepository, IPerfilService perfilService, IEnderecoService enderecoService) {
        this.usuarioRepository = usuarioRepository;
        this.perfilService = perfilService;
        this.enderecoService = enderecoService;
    }

    @Override
    public UsuarioDtoResponse buscarPorId(UUID id) {
        UsuarioDb usuarioDb = usuarioRepository.recuperaDadosUsuarioPorId(id);
        Usuario usuario = UsuarioMapper.toUsuario(usuarioDb);

        return UsuarioMapper.toUsuarioDtoResponse(usuario);
    }

    @Override
    public UsuarioPaginacaoDtoResponse buscarUsuarios(final Integer pagina) {
        return UsuarioMapper.toUsuarioPaginacaoDtoResponse(usuarioRepository.recuperaDadosUsuarios(pagina));
    }

    @Override
    public void cadastrar(UsuarioDtoRequest usuarioDtoRequest) {
        if(usuarioRepository.emailJaCadastrado(usuarioDtoRequest.email())){
            throw new EmailDuplicadoException(MensagensUtil.recuperarMensagem(MensagensUtil.ERRO_EMAIL_DUPLICADO));
        }

        Usuario usuario = UsuarioMapper.toUsuario(usuarioDtoRequest);
        UsuarioDb usuarioDb = UsuarioMapper.toUsuarioDb(usuario);

        salvar(usuarioDb);
    }

    @Override
    public void atualizarStatus(UUID id, boolean isAtivo) {
        UsuarioDb usuario;

        if(isAtivo) {
            usuario = usuarioRepository.recuperaDadosUsuarioInativoPorId(id);

            usuario.reativar();
        } else {
            usuario = usuarioRepository.recuperaDadosUsuarioAtivoPorId(id);

            usuario.inativar();
        }

        salvar(usuario);
    }

    @Override
    public void salvar(UsuarioDb usuario) {
        usuarioRepository.salvar(usuario);
    }

    @Override
    public void atualizarPerfil(UUID id, Integer idPerfil) {
        UsuarioDb usuario = usuarioRepository.recuperaDadosUsuarioAtivoPorId(id);

        if(!idPerfil.equals(usuario.getPerfil().getId())) {
            PerfilDb perfil = perfilService.buscarPorId(idPerfil);

            usuario.atualizarPerfil(perfil);

            salvar(usuario);
        }
    }

    @Override
    public void atualizarNome(UUID id, String nome) {
        UsuarioDb usuario = usuarioRepository.recuperaDadosUsuarioAtivoPorId(id);

        usuario.atualizarNome(nome);

        salvar(usuario);
    }

    @Override
    public void atualizarEmail(UUID id, String email) {
        UsuarioDb usuario = usuarioRepository.recuperaDadosUsuarioAtivoPorId(id);

        if(usuarioRepository.emailJaCadastrado(email)){
            throw new EmailDuplicadoException(MensagensUtil.recuperarMensagem(MensagensUtil.ERRO_EMAIL_DUPLICADO));
        }

        usuario.atualizarEmail(email);

        salvar(usuario);
    }

    @Override
    public UsuarioDb buscarUsuarioPorIdLogin(UUID loginId){
        return usuarioRepository.recuperarDadosUsuarioPorIdLogin(loginId);
    }

    @Override
    public void atualizarDadosEndereco(UUID id, EnderecoDtoRequest dadosEndereco) {
        UsuarioDb usuario = usuarioRepository.recuperaDadosUsuarioPorId(id);

        enderecoService.atualizarEndereco(usuario.getDadosEndereco(), dadosEndereco);
    }
}
