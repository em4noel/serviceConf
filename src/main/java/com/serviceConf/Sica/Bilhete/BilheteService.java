package com.serviceConf.Sica.Bilhete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class BilheteService {
    @Autowired
    private BilheteRepository bilheteRepository;

    public Optional<Bilhete> findByloc(String loc){
        Optional<Bilhete> bilhete = bilheteRepository.findByLoc(loc);
        if (bilhete.isPresent()) {
            return bilhete;
        }
        return null;
    }
}
