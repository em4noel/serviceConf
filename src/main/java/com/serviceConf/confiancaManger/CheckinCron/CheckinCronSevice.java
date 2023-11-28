package com.serviceConf.confiancaManger.CheckinCron;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serviceConf.confiancaManger.Checkin.Checkin;
import com.serviceConf.confiancaManger.Trecho.TrechoCheckin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CheckinCronSevice {
    @Autowired
    private CheckinCronRepository checkinCronRepository;

    @Transactional
    public void save(CheckinCron checkinCron) {

        Optional<CheckinCron> isCheckinCron = checkinCronRepository.findByUltimaDataAndProximaDataAndStatusEnvio(checkinCron.getUltimaData(), checkinCron.getProximaData(), checkinCron.getStatusEnvio());
        if (isCheckinCron.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Data já  already exists");
        }
        checkinCronRepository.save(checkinCron);
    }

    @Transactional
    public void update(Integer id, CheckinCron checkinCron) {
        checkinCronRepository.findById(id).map(isCron -> {
            isCron.setProximaData(checkinCron.getProximaData());
            isCron.setProximaData(checkinCron.getProximaData());
            isCron.setStatusEnvio(checkinCron.getStatusEnvio());
            checkinCronRepository.save(isCron);
            return isCron;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Checkin not found"));
    }

    public List<CheckinCron> findAll(CheckinCron filter) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filter, matcher);
        return checkinCronRepository.findAll(example);
    }

    public Optional<CheckinCron> consultarPorDataEStatus(Date dataFrom, Integer status) {
        // Implemente a lógica para consultar o banco de dados com base na data e no status
        Optional<CheckinCron> isCheckinCron = checkinCronRepository.findByUltimaDataAndStatusEnvio(dataFrom, status);
        return isCheckinCron;
    }

    public ResponseEntity<?> findByProximaData() {
        return ResponseEntity.ok(checkinCronRepository.findFirstByOrderByProximaDataDesc());
    }
}
