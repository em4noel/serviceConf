package com.serviceConf.Sica.Reembolso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReembolsoService {
    @Autowired
    private ReembolsoRepository reembolsoRepository;

    public Reembolso findAll(Reembolso filter) {

        Reembolso reembolsoSica = reembolsoRepository.findByTipodocAndNumtktAndCodcia(filter.getTipodoc(), filter.getNumtkt(), filter.getCodcia());
        if (reembolsoSica != null && reembolsoSica.getNumvend() != null) {
            return reembolsoSica;
        }
        return null;
    }

    public Reembolso findByAzul(Reembolso filter) {
        Reembolso reembolsoSica = reembolsoRepository.findByNumtktAndTipodoc(filter.getNumtkt(), filter.getTipodoc());
        if (reembolsoSica != null && reembolsoSica.getNumvend() != null) {
            return reembolsoSica;
        }
        return null;
    }
    public Reembolso findByLoc(Reembolso filter) {
        Reembolso reembolsoSica = reembolsoRepository.findByLocAndTipodoc(filter.getLoc(), filter.getTipodoc());
        if (reembolsoSica != null && reembolsoSica.getNumvend() != null) {
            return reembolsoSica;
        }
        return null;
    }
}
