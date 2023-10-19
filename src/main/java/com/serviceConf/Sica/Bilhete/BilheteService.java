package com.serviceConf.Sica.Bilhete;

import com.serviceConf.Sica.Bilhete.dto.BilheteLocDto;
import com.serviceConf.Sica.Bilhete.dto.BilheteNumtktDto;
import com.serviceConf.Sica.Bilhete.dto.FindByBilheteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BilheteService {
    @Autowired
    private BilheteRepository bilheteRepository;

    public Optional<Bilhete> findByloc(String loc){
        Optional<Bilhete> bilhete = bilheteRepository.findFirstByLoc(loc);
        if (bilhete.isPresent()) {
            return bilhete;
        }
        return null;
    }

    public List<FindByBilheteDto> findByBilhete(String numTkt){
        return bilheteRepository.findByBilhete(numTkt);
    }
    public List<BilheteNumtktDto> findByBilheteNumtkt(String numTkt){
        return bilheteRepository.findByBilheteNumTkt(numTkt);
    }
    public List<BilheteLocDto> findByBilheteLoc(String loc){
        return bilheteRepository.findByBilheteLoc(loc);
    }
}
