package com.serviceConf.Sica.Reembolso;

import com.serviceConf.Sica.Reembolso.dto.ReembolsoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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

    @PostMapping("/FindBySica")
    public List<ReembolsoDTO> findAllSica(@RequestBody PostReembolsoSicaModel postReembolsoSicaModel) {
       // System.out.println(postReembolsoSicaModel.getDataI().getTime());
       return reembolsoService.consultaSica(postReembolsoSicaModel);
    }

}
