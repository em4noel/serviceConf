package com.serviceConf.Sica.Bilhete;

import com.serviceConf.Sica.Bilhete.dto.BilheteVendaRQ;
import com.serviceConf.Sica.Bilhete.dto.FindByBilheteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bilhete")
public class BilheteController {

    @Autowired
    private BilheteService bilheteService;

    @PostMapping
    public List<FindByBilheteDto> findByBilheteVenda(@RequestBody BilheteVendaRQ bilhete ){
        return bilheteService.findByBilhete(bilhete.getNumtkt());
    }
}
