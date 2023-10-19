package com.serviceConf.Sica.Bilhete;

import com.serviceConf.Sica.Bilhete.dto.BilheteLocDto;
import com.serviceConf.Sica.Bilhete.dto.BilheteNumtktDto;
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
    public List<FindByBilheteDto> findByBilheteVenda(@RequestBody BilheteVendaRQ bilhete) {
        return bilheteService.findByBilhete(bilhete.getNumtkt());
    }
    @PostMapping("/BilheteLoc")
    public List<BilheteLocDto> findByBilheteLoc(@RequestBody BilheteVendaRQ bilhete) {
        return bilheteService.findByBilheteLoc(bilhete.getLoc());
    }
    @PostMapping("/BilheteNumtkt")
    public List<BilheteNumtktDto> findByBilheteNumtkt(@RequestBody BilheteVendaRQ bilhete) {
        return bilheteService.findByBilheteNumtkt(bilhete.getNumtkt());
    }
}
