package com.serviceConf.confiancaManger.Trecho;

import com.serviceConf.confiancaManger.AeroportoWooba.AeroportoWooba;
import com.serviceConf.confiancaManger.AeroportoWooba.AeroportoWoobaService;
import com.serviceConf.confiancaManger.Checkin.Checkin;
import com.serviceConf.confiancaManger.Trecho.dto.CheckinTrechosDto;
import com.serviceConf.confiancaManger.Trecho.dto.TrechoCheckinDto;
import com.serviceConf.confiancaManger.Trecho.dto.TrechoDto;
import com.serviceConf.confiancaManger.Trecho.dto.TrechoRsDto;
import com.serviceConf.wooba.turVendasAereas.TurVendasAereasRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class TrechoCheckinService {
    @Autowired
    private TrechoCheckinRepository trechoCheckinRepository;

    @Autowired
    private AeroportoWoobaService turAeroportoWoobaService;

    @Transactional
    public TrechoCheckin save(TrechoCheckin trecho) {
        try {
            TrechoCheckin tr = trechoCheckinRepository.save(trecho);
            return tr;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao cadastrar trecho, favor verificar novamente.");
        }
    }

    @Transactional
    public void update(Integer id, TrechoCheckin trecho) {
        trechoCheckinRepository.findById(id).map(isTrecho -> {
            isTrecho.setCheckin(trecho.getCheckin());
            isTrecho.setStatus(trecho.getStatus());
            trechoCheckinRepository.save(isTrecho);
            return isTrecho;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Trecho not found"));
    }

    public List<CheckinTrechosDto> findAll(Integer status, Date data, Date dataTo) {

        List<TrechoCheckin> allTrechos = trechoCheckinRepository.findByStatusAndDataBetween(status, data, dataTo);

        // Agrupar os trechos pelo id reserva do check-in
        Map<Checkin, List<TrechoCheckin>> trechosAgrupados = new HashMap<>();
        for (TrechoCheckin trecho : allTrechos) {
            Checkin checkin = trecho.getCheckin();
            trechosAgrupados.computeIfAbsent(checkin, k -> new ArrayList<>()).add(trecho);
        }

        // Criar uma lista de CheckinTrechosDto com os trechos agrupados
        List<CheckinTrechosDto> checkinTrechosDtoList = new ArrayList<>();
        for (Checkin checkin : trechosAgrupados.keySet()) {
            List<TrechoCheckin> trechos = trechosAgrupados.get(checkin);

            // Criar a lista de TrechoDto a partir da lista de Trecho, excluindo o atributo codgCheckin
            List<TrechoCheckinDto> trechoDtoList = new ArrayList<>();
            for (TrechoCheckin trecho : trechos) {
                TrechoCheckinDto trechoDto = new TrechoCheckinDto();
                BeanUtils.copyProperties(trecho, trechoDto, "codgCheckin");
                trechoDtoList.add(trechoDto);
            }

            CheckinTrechosDto checkinTrechosDto = new CheckinTrechosDto();
            checkinTrechosDto.setCheckin(checkin);
            checkinTrechosDto.setTrechos(trechoDtoList);
            checkinTrechosDtoList.add(checkinTrechosDto);
        }

        return checkinTrechosDtoList;
    }

    @Transactional
    public void atualizarCamposVazios() {
        List<TrechoCheckin> trechos = trechoCheckinRepository.findTrechosComCamposVazios();
        if (trechos.size() > 0) {
            atualizarOrigemAndDestino(trechos);
            trechoCheckinRepository.saveAll(trechos);
        }
    }


    private void atualizarOrigemAndDestino(List<TrechoCheckin> trechos) {
        for (TrechoCheckin trecho : trechos) {
            if (trecho.getDsOrigem() != null) {
                System.out.println(trecho.getDe());
                Optional<AeroportoWooba> origem = getAeroportoWooba(trecho.getDe());
                if (origem != null) {

                    trecho.setDsOrigem(origem.get().getNome());
                }
            }

            if (trecho.getDsDestino() != null) {
                System.out.println(trecho.getPara());
                Optional<AeroportoWooba> destino = getAeroportoWooba(trecho.getPara());
                if (destino != null) {

                    trecho.setDsDestino(destino.get().getNome());
                }
            }
        }
    }

    private Optional<AeroportoWooba> getAeroportoWooba(String trecho) {
        Optional<AeroportoWooba> origem = turAeroportoWoobaService.findBySigla(trecho);
        return origem;
    }
}
