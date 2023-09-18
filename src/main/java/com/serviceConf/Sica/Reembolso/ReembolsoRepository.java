package com.serviceConf.Sica.Reembolso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReembolsoRepository extends JpaRepository<Reembolso, Integer> {
    Reembolso findByTipodocAndNumtktAndCodcia(String tipodoc, String numTkt, String codCia);

    Reembolso findByNumtktAndTipodoc(String tipodoc, String numTkt);

    Reembolso findByLocAndTipodoc(String loc, String tipodoc);
}
