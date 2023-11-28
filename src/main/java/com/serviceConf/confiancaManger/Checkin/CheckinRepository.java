package com.serviceConf.confiancaManger.Checkin;

import com.serviceConf.confiancaManger.Trecho.TrechoCheckin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CheckinRepository extends JpaRepository<Checkin, Integer> {
    Optional<Checkin> findByLocalizadorCompanhiaAndNumeroDoBilhete(String localizador, String numeroBilehte);

    @Query("SELECT c FROM Checkin c WHERE LENGTH(c.localizadorCompanhia) = 0 ")
    List<Checkin> findByLocalizadorIsNull();
}
