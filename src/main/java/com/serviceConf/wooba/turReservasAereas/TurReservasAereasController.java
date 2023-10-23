package com.serviceConf.wooba.turReservasAereas;

import com.serviceConf.wooba.turReservasAereas.dto.TrechoVendaDto;
import com.serviceConf.wooba.turReservasAereas.dto.TrechoVendaRQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ReservasAereas")
public class TurReservasAereasController {
    @Autowired
    private TurReservasAereasRepository turReservasAereasRepository;

    @PostMapping("/findTrechosVenda")
    public List<TrechoVendaDto>findByTrechoVenda(@RequestBody TrechoVendaRQ trechoVendaRQ){
        return turReservasAereasRepository.findByTrechoVenda(trechoVendaRQ.getLocalizador(), trechoVendaRQ.getCia());
    }

}
