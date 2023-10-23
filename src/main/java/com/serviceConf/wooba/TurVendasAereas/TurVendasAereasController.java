package com.serviceConf.wooba.TurVendasAereas;

import com.serviceConf.wooba.TurVendasAereas.dto.DataEmissaoRQ;
import com.serviceConf.wooba.TurVendasAereas.dto.FindVendaByDataEmissaoDto;
import com.serviceConf.wooba.TurVendasAereas.dto.IdReserva;
import com.serviceConf.wooba.TurVendasAereas.dto.PassageirosTurVendasAereasDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/VendasAereas")
public class TurVendasAereasController {

    @Autowired
    private TurVendasAereasRepository turVendasAereasRepository;

    @PostMapping("/findVendaByDataEmissao")
    public List<FindVendaByDataEmissaoDto> findByDataEmissao(@RequestBody DataEmissaoRQ dataEmissaoRQ){
        return turVendasAereasRepository.fingByDataEmissao(dataEmissaoRQ.getDataInicial(), dataEmissaoRQ.getDataFinal());
    }
    @PostMapping("/findPassageirosByTurVendasAereas")
    public List<PassageirosTurVendasAereasDto> PassageirosByTurVendasAereas(@RequestBody IdReserva reserva){
        return turVendasAereasRepository.findByVenda(reserva.getIdReserva());
    }

}
