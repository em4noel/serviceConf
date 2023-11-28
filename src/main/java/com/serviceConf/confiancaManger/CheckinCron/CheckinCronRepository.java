package com.serviceConf.confiancaManger.CheckinCron;

import com.serviceConf.confiancaManger.Trecho.TrechoCheckin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CheckinCronRepository extends JpaRepository<CheckinCron, Integer> {
    Optional<CheckinCron> findByUltimaDataAndProximaDataAndStatusEnvio(Date dataIncial, Date dataFinal, Integer statusEnvio);

    Optional<CheckinCron> findByUltimaDataAndStatusEnvio(Date dataIncial, Integer statusEnvio);

    Optional<CheckinCron> findFirstByOrderByProximaDataDesc();


}
