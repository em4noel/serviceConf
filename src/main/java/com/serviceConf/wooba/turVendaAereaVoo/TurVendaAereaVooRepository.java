package com.serviceConf.wooba.turVendaAereaVoo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurVendaAereaVooRepository extends JpaRepository<TurVendaAereaVoo, Integer> {

  /*  @Transactional(readOnly = true)
    @Query("SELECT com.serviceConf.wooba.Checkin.dto.CheckinVooDto " +
            " () " +
            " FROM " +
            " WHERE ")
    List<CheckinVooDto> findaByParam(Date dataInicial, Date dataFinal);*/
}
