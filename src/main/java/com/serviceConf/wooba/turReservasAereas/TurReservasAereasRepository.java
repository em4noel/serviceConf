package com.serviceConf.wooba.turReservasAereas;

import com.serviceConf.wooba.turReservasAereas.dto.TrechoVendaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface TurReservasAereasRepository extends JpaRepository<TurReservasAereas, Integer> {
    @Transactional
    @Query(" SELECT NEW com.serviceConf.wooba.turReservasAereas.dto.TrechoVendaDto " +
            " (t.companhia, t.data, t.dataRetorno, t.dsDestino, t.dsOrigem, t.familia, " +
            " r.trecho) " +
            " FROM TurReservasAereas r, TurReservasAereasTrecho t " +
            " WHERE r.localizador= :localizador " +
            " AND t.reservaId=r.id " +
            " AND r.companhia= :cia " +
            " AND r.cliente=227 ")
    List<TrechoVendaDto> findByTrechoVenda(@PathVariable String localizador, @PathVariable String cia);
}
