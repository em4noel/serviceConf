package com.serviceConf.Sica.Venda;

import com.serviceConf.Sica.Bilhete.BilheteService;
import com.serviceConf.Sica.Venda.dto.VendaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/venda")
public class VendaController {
    @Autowired
    private VendaService vendaService;
    @PostMapping("/findByCodemp")
    public Optional<Venda> findByVenda(@RequestBody VendaDto vendaDto){
        return vendaService.findByVenda(vendaDto.getLoc());
    }
}
