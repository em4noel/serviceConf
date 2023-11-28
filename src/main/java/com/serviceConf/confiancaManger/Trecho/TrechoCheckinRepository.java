package com.serviceConf.confiancaManger.Trecho;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TrechoCheckinRepository extends JpaRepository<TrechoCheckin, Integer> {
    @Query("SELECT t FROM TrechoCheckin t WHERE LENGTH(t.dsOrigem) = 0 OR LENGTH(t.dsDestino) = 0")
    List<TrechoCheckin> findTrechosComCamposVazios();

    List<TrechoCheckin>findByStatusAndDataBetween(Integer status, Date dataInicial, Date dataFinal);

}
