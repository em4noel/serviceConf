package com.serviceConf.confiancaManger.AeroportoWooba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AeroportoWoobaService {
    @Autowired
    private AeroportoWoobaRepository turAeroportoWoobaRepository;

    public Optional<AeroportoWooba> findBySigla(String sigla){
        return turAeroportoWoobaRepository.findByCodigoIata(sigla);
    }
}
