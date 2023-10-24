package com.serviceConf.wooba.ccrPassageiros;

import com.serviceConf.wooba.ccrPassageiros.dto.CcrPassageiroDto;
import com.serviceConf.wooba.ccrPassageiros.dto.IdOsDtoRQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/passageirosCCr")
public class CcrPassageirosController {
    @Autowired
    private CcrPassageirosRepository ccrPassageirosRepository;

    @PostMapping("/findPassageirosCCr")
    public List<CcrPassageiroDto> findByCcrPassageiros(@RequestBody IdOsDtoRQ idOsDtoRQ){
        return ccrPassageirosRepository.findByCcrPassageiros(idOsDtoRQ.getTurOsId());
    }
}
