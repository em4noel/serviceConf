package com.serviceConf.wooba.TurVendaAereaVoo;

import com.serviceConf.wooba.Checkin.dto.CheckinVooDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface TurVendaAereaVooRepository extends JpaRepository<TurVendaAereaVoo, Integer> {

  /*  @Transactional(readOnly = true)
    @Query("SELECT com.serviceConf.wooba.Checkin.dto.CheckinVooDto " +
            " () " +
            " FROM " +
            " WHERE ")
    List<CheckinVooDto> findaByParam(Date dataInicial, Date dataFinal);*/
}
