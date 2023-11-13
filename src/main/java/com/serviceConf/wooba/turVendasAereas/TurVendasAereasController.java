package com.serviceConf.wooba.turVendasAereas;

import com.serviceConf.wooba.turVendasAereas.dto.DataEmissaoRQ;
import com.serviceConf.wooba.turVendasAereas.dto.FindVendaByDataEmissaoDto;
import com.serviceConf.wooba.turVendasAereas.dto.IdReserva;
import com.serviceConf.wooba.turVendasAereas.dto.PassageirosTurVendasAereasDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/vendasAereas")
public class TurVendasAereasController {

    @Autowired
    private TurVendasAereasRepository turVendasAereasRepository;

    @PostMapping("/findVendaByDataEmissao")
    public List<FindVendaByDataEmissaoDto> findByDataEmissao(@RequestBody DataEmissaoRQ dataEmissaoRQ) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataInicial = null;
        Date dataFinal = null;
        try {
            dataInicial = dateFormat.parse(dataEmissaoRQ.getDataInicial());
            dataFinal = dateFormat.parse(dataEmissaoRQ.getDataFinal());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return turVendasAereasRepository.fingByDataEmissao(dataInicial, dataFinal);
    }

    @PostMapping("/findPassageirosByTurVendasAereas")
    public List<PassageirosTurVendasAereasDto> PassageirosByTurVendasAereas(@RequestBody IdReserva reserva) {
        return turVendasAereasRepository.findByVenda(reserva.getIdReserva());
    }

}
