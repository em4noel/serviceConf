package com.serviceConf.wooba.turVendaAereaPassageiro;

import com.serviceConf.wooba.turVendaAereaPassageiro.dto.PassageiroVendaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/VendaAereaPassageiro")
public class TurVendaAereaPassageiroController {
    @Autowired
    private TurVendaAereaPassageiroRepository turVendaAereaPassageiroRepository;

    @PostMapping("/findPassageirosVenda")
    public List<TurVendaAereaPassageiro> findByPassageiroVenda(@RequestBody PassageiroVendaDto passageiroVendaDto){
        return turVendaAereaPassageiroRepository.findByVenda(passageiroVendaDto.getIdReserva());
    }
}
