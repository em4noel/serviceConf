package com.serviceConf.Sica.Reembolso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reembolso")
public class ReembolsoController {
    @Autowired
    private ReembolsoService reembolsoService;

    @PostMapping("/FindAll")
    public Reembolso findAll(@RequestBody Reembolso reembolsoSica){
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
}
