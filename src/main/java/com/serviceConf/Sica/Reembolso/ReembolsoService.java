package com.serviceConf.Sica.Reembolso;

import com.serviceConf.Sica.Reembolso.dto.ReembolsoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReembolsoService {
    @Autowired
    private ReembolsoRepository reembolsoRepository;

    public Optional<Reembolso> findAll(Reembolso filter) {

        //Optional<Reembolso> reembolsoSica = reembolsoRepository.findFirstByTipodocAndNumtktAndCodciaAndDatapedOrderByNumreembDesc(filter.getTipodoc(), filter.getNumtkt(), filter.getCodcia(), filter.getDataped());
        Optional<Reembolso> reembolsoSica = reembolsoRepository.findFirstByTipodocAndNumtktAndCodciaOrderByNumreembDesc(filter.getTipodoc(), filter.getNumtkt(), filter.getCodcia());
        if (reembolsoSica.isPresent()) {
            return reembolsoSica;
        }
        return null;
    }

    public Reembolso findByAzul(Reembolso filter) {
        Reembolso reembolsoSica = reembolsoRepository.findByNumtktAndTipodocAndDataped(filter.getNumtkt(), filter.getTipodoc(), filter.getDataped());
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

    public List<ReembolsoDTO> consultaSica(PostReembolsoSicaModel postReembolsoSicaModel){

        List<ReembolsoDTO> reembolsos = null;
        if(postReembolsoSicaModel.getTipoData().equalsIgnoreCase("dtR")) {
            reembolsos = reembolsoRepository.consultaDataReembolso(postReembolsoSicaModel.getDataI(),postReembolsoSicaModel.getDataF(),postReembolsoSicaModel.getCodemp());
        } else if(postReembolsoSicaModel.getTipoData().equalsIgnoreCase("dtS")) {
            reembolsos = reembolsoRepository.consultaDataSolicitacao(postReembolsoSicaModel.getDataI(), postReembolsoSicaModel.getDataF(), postReembolsoSicaModel.getCodemp());
        } else if(postReembolsoSicaModel.getTipoData().equalsIgnoreCase("dtE")) {
            reembolsos = reembolsoRepository.consultaDataEmissao(postReembolsoSicaModel.getDataI(), postReembolsoSicaModel.getDataF(), postReembolsoSicaModel.getCodemp());
        }
        System.out.println("quantidade "+reembolsos.size());
        return reembolsos;
    }
}
