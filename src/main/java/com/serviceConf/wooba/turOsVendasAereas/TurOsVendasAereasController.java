package com.serviceConf.wooba.turOsVendasAereas;

import com.serviceConf.wooba.turOsVendasAereas.dto.FindOsDto;
import com.serviceConf.wooba.turOsVendasAereas.dto.FindOsRQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/findOS")
public class TurOsVendasAereasController {

    @Autowired
    private TurOsVendasAereasRepository turOsVendasAereasRepository;

    @PostMapping
    public List<FindOsDto> findOs(@RequestBody FindOsRQ findOsRQ){
        return turOsVendasAereasRepository.findByOs(findOsRQ.getIdReserva());
    }

}
