package com.serviceConf.Sica.Venda;

import com.serviceConf.Sica.Bilhete.Bilhete;
import com.serviceConf.Sica.Bilhete.BilheteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VendaService {
    @Autowired
    private BilheteService bilheteService;
    @Autowired
    private VendaRepository vendaRepository;

    public Optional<Venda> findByVenda(String loc){
        Optional<Bilhete> bilhete =bilheteService.findByloc(loc);
        if(bilhete.isPresent()){
            Optional<Venda> venda = vendaRepository.findByNumvend(bilhete.get().getNumvend());
            if(venda.isPresent()){
                return venda;
            }
        }
        return null;
    }
}
