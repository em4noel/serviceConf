package com.serviceConf.wooba.turReservasAereasTrecho;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serviceConf.wooba.turReservasAereasTrecho.dto.CheckinRsVooDto;
import com.serviceConf.wooba.turReservasAereasTrecho.dto.CheckinVooDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reservasAereasTrecho")
public class TurReservasAereasTrechoController {
    @Autowired
    private TurReservasAereasTrechoRepository turReservasAereasRepository;
    @Autowired
    private TurReservasAereasTrechoService turReservasAereasTrechoService;

    @PostMapping("/checkinTrecho")
    private List<CheckinRsVooDto> findByCheckinTrecho(@RequestParam("dataFrom") @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataForm, @RequestParam("dataTo") @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataTo) {
        List<CheckinVooDto> checkinVooDtoList = turReservasAereasRepository.findByCheckin(dataForm, dataTo);
        List<CheckinRsVooDto> checkinRsVooDtos = turReservasAereasTrechoService.transformToResponseDto(checkinVooDtoList);
        return checkinRsVooDtos;
    }
}
