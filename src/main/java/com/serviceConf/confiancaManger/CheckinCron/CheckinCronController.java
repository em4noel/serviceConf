package com.serviceConf.confiancaManger.CheckinCron;

import com.serviceConf.message.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cron")
public class CheckinCronController {

    @Autowired
    private CheckinCronSevice checkinCronSevice;

    @GetMapping
    public List<CheckinCron> findAll(CheckinCron checkin) {
        return checkinCronSevice.findAll(checkin);
    }

    @PostMapping("/consulta")
    public ResponseEntity<CheckinCron> consultarTrechosPorDataEStatus(@RequestBody CheckinCron request) {
        Optional<CheckinCron> checkinCron = checkinCronSevice.consultarPorDataEStatus(request.getUltimaData(), request.getStatusEnvio());
        if (checkinCron.isPresent()) {
            CheckinCron checkinCron1 = checkinCron.get();
            return ResponseEntity.ok(checkinCron1);
        }
        return null;
    }

    @GetMapping("/fristProximaData")
    public ResponseEntity<?> findByProximaData() {
        return checkinCronSevice.findByProximaData();
    }

    @PostMapping("/save")
    public void save(@RequestBody CheckinCron checkin) {
        checkinCronSevice.save(checkin);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Integer id, @RequestBody CheckinCron checkin) {
        checkinCronSevice.update(id, checkin);
    }
}
