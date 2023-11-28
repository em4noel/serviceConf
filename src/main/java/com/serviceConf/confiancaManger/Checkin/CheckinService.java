package com.serviceConf.confiancaManger.Checkin;

import com.serviceConf.wooba.turVendasAereas.TurVendasAereasRepository;
import com.serviceConf.wooba.turVendasAereas.dto.FindByLocalizadorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CheckinService {
    @Autowired
    private CheckinRepository checkinRepository;
    @Autowired
    private TurVendasAereasRepository turVendasAereasRepository;

    @Transactional
    public Checkin save(Checkin checkin) {
        Optional<Checkin> isCheckin = checkinRepository.findByLocalizadorCompanhiaAndNumeroDoBilhete(checkin.getLocalizadorCompanhia(), checkin.getNumeroDoBilhete());
        if (isCheckin.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Localizador já  already exists");
        }
        return checkinRepository.save(checkin);
    }

    @Transactional
    public Checkin update(Integer id, Checkin checkin) {
        checkinRepository.findById(id).map(isCheckin -> {
            isCheckin.setLocalizadorCompanhia(checkin.getLocalizadorCompanhia());
            isCheckin.setData(checkin.getData());
            isCheckin.setNomeAgencia(checkin.getNomeAgencia());
            isCheckin.setLogomarca(checkin.getLogomarca());
            isCheckin.setNomeCompleto(checkin.getNomeCompleto());
            isCheckin.setEmail(checkin.getEmail());
            isCheckin.setIsEnvio(checkin.getIsEnvio());
            checkinRepository.save(isCheckin);
            return isCheckin;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Checkin not found"));
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Checkin not found");
    }

    public List<Checkin> findAll(Checkin filter) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filter, matcher);
        return checkinRepository.findAll(example);
    }

    public void atualizarLocalizador() {
        List<Checkin> checkinList = checkinRepository.findByLocalizadorIsNull();
        if (checkinList.size() > 0) {
            createLoc(checkinList);
            checkinRepository.saveAll(checkinList);
        }
    }

    private void createLoc(List<Checkin> checkinList) {
        for (Checkin checkin : checkinList) {
            String numero = checkin.getNumeroDoBilhete().substring(3);
            System.out.println(numero);
            Optional<FindByLocalizadorDto> isLocalizador = turVendasAereasRepository.findByLocalizadorNulo(numero);
            if (isLocalizador != null) {
                checkin.setLocalizadorCompanhia(isLocalizador.get().getLocalizador());
            }
        }
    }

}
