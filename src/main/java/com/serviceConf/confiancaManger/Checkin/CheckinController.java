package com.serviceConf.confiancaManger.Checkin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checkin")
public class CheckinController {
    @Autowired
    private CheckinService checkinService;

    @GetMapping
    public List<Checkin> findAll(Checkin checkin){
        return checkinService.findAll(checkin);
    }

    @PostMapping
    public Checkin save(@RequestBody Checkin checkin){
        return checkinService.save(checkin);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Checkin update(@PathVariable Integer id, @RequestBody Checkin checkin){
        return checkinService.update(id, checkin);
    }
}
