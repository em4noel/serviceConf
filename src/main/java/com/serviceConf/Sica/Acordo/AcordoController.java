package com.serviceConf.Sica.Acordo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/acordo")
public class AcordoController {
    @Autowired
    private AcordoService acordoService;

    @GetMapping
    public List<Acordo> findAcordos(Acordo acordo){
        return acordoService.findAll(acordo);
    }
}
