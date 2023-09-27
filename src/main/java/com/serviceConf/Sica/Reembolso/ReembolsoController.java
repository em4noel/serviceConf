package com.serviceConf.Sica.Reembolso;

import com.serviceConf.Sica.Reembolso.dto.ReembolsoDTO;
import com.serviceConf.appConf.TokenDTO.CredenciaisDto;
import com.serviceConf.appConf.TokenDTO.TokenDto;
import com.serviceConf.appConf.Usuario.Usuario;
import com.serviceConf.appConf.Usuario.UsuarioRepository;
import com.serviceConf.security.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reembolso")
public class ReembolsoController {
    @Autowired
    private ReembolsoService reembolsoService;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private JwtService jwtService;
    @PostMapping("/FindAll")
    public Optional<Reembolso> findAll(@RequestBody Reembolso reembolsoSica){
        return reembolsoService.findAll(reembolsoSica);
    }
    @PostMapping("/FindByAzul")
    public Reembolso findByAzul(@RequestBody Reembolso reembolsoSica){
        return  reembolsoService.findByAzul(reembolsoSica);
    }
    @PostMapping("/FindByLoc")
    public Reembolso findByLoc(@RequestBody Reembolso reembolsoSica){
        return  reembolsoService.findByLoc(reembolsoSica);
    }
    @PostMapping("/FindBySica")
    public List<ReembolsoDTO> findAllSica(@RequestBody PostReembolsoSicaModel postReembolsoSicaModel) {
       // System.out.println(postReembolsoSicaModel.getDataI().getTime());
       return reembolsoService.consultaSica(postReembolsoSicaModel);
    }

}
