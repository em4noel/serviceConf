package com.serviceConf.appConf.Usuario;

import com.serviceConf.appConf.TokenDTO.CredenciaisDto;
import com.serviceConf.appConf.TokenDTO.TokenDto;
import com.serviceConf.security.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/user")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private JwtService jwtService;
    @PostMapping("/auth")
    public TokenDto autenticar(@RequestBody CredenciaisDto credencial) {
        System.out.println("Entrou aqui  ");
        try {
            Usuario usuario = new Usuario();
            usuario.setLogin(credencial.getLogin());
            usuario.setSenha(credencial.getSenha());
            usuario = usuarioRepository.findByLoginAndSenha(credencial.getLogin(), credencial.getSenha());
            String token = jwtService.gerarToken(usuario);

            TokenDto tokenDTO = new TokenDto();
            tokenDTO.setLogin(usuario.getLogin());
            tokenDTO.setToken(token);

            return tokenDTO;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Não Autorizado, login ou senha invalidos.");
        }
    }
}
