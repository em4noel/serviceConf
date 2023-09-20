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

    public List<ReembolsoDTO> consultaSica(PostReembolsoSicaModel postReembolsoSicaModel){
        System.out.println(postReembolsoSicaModel.getDataI());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      //  Date dataInicial = formatter.(postReembolsoSicaModel.getDataI());
      //  Date dataFinal = formatter.parse(dataF);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dataFormatadaI = dateFormat.format(postReembolsoSicaModel.getDataI());
        String dataFormatadaF = dateFormat.format(postReembolsoSicaModel.getDataF());

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
