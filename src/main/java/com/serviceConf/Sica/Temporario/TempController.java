package com.serviceConf.Sica.Temporario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/temporario")
public class TempController {
    @Autowired
    private TempService tempService;
    @GetMapping
    public List<Temp> findAll(Temp temp) {
        return tempService.findAll(temp);
    }
}
