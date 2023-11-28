package com.serviceConf.confiancaManger.Trecho;

import com.serviceConf.confiancaManger.Checkin.CheckinService;
import com.serviceConf.confiancaManger.Trecho.dto.CheckinTrechosDto;
import com.serviceConf.confiancaManger.Trecho.dto.TrechoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trecho")
public class TrechoCheckinController {
    @Autowired
    private TrechoCheckinService trechoCheckinService;
    @Autowired
    private CheckinService checkinSevice;

    @PostMapping("/intervalo")
    public List<CheckinTrechosDto> findByIntervaloData(@RequestBody TrechoDto trechoDto) {
        return trechoCheckinService.findAll(trechoDto.getStatus(), trechoDto.getDateFrom(), trechoDto.getDateTo());
    }

    @PostMapping
    public TrechoCheckin save(@RequestBody TrechoCheckin trecho) {
        return trechoCheckinService.save(trecho);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Integer id, @RequestBody TrechoCheckin trecho) {
        trechoCheckinService.update(id, trecho);
    }

    @PostMapping("/atualizaCampoNulos")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> atualizacaoCampoNulos() {
        trechoCheckinService.atualizarCamposVazios();
        checkinSevice.atualizarLocalizador();
        return ResponseEntity.ok().build();
    }
}
