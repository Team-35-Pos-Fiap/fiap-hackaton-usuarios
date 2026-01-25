package br.com.fiap_hackaton_usuarios.controllers;

import br.com.fiap_hackaton_usuarios.controllers.response.MensagemResponse;
import br.com.fiap_hackaton_usuarios.controllers.response.SucessoResponse;
import br.com.fiap_hackaton_usuarios.entities.dto.request.LoginDtoRequest;
import br.com.fiap_hackaton_usuarios.entities.dto.request.SenhaDtoRequest;
import br.com.fiap_hackaton_usuarios.services.interfaces.ILoginService;
import br.com.fiap_hackaton_usuarios.utils.MensagensUtil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {

    protected ILoginService loginService;

    public LoginController(ILoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<MensagemResponse> validar(@RequestBody @Valid @NotNull LoginDtoRequest dados) {
        log.info("realizaLogin():dados do login {}", dados);
        MensagemResponse sucessoResponse = new SucessoResponse(loginService.validar(dados));

        return ResponseEntity.ok().body(sucessoResponse);
    }

    @PatchMapping("/{matricula}/senha")
    public ResponseEntity<MensagemResponse> atualizarSenha(@PathVariable @Valid @NotNull String matricula, @Valid @RequestBody @NotNull SenhaDtoRequest dados) {
        log.info("trocar senha():id {} - senha {}", matricula, dados.senha());

        loginService.trocarSenha(matricula, dados.senha());

        MensagemResponse sucessoResponse = new SucessoResponse(MensagensUtil.recuperarMensagem(MensagensUtil.SUCESSO_TROCA_SENHA_USUARIO));
        return ResponseEntity.ok(sucessoResponse);
    }
}