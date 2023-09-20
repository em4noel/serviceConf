package com.serviceConf.Sica.Reembolso;

import com.serviceConf.Sica.Reembolso.dto.ReembolsoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface ReembolsoRepository extends JpaRepository<Reembolso, Integer> {
    Reembolso findByTipodocAndNumtktAndCodcia(String tipodoc, String numTkt, String codCia);

    Reembolso findByNumtktAndTipodoc(String tipodoc, String numTkt);

    Reembolso findByLocAndTipodoc(String loc, String tipodoc);

    List<Reembolso> findByDataemiBetweenAndCodemp(Date to, Date from, Integer codemp);

    @Transactional(readOnly = true)
    @Query("SELECT NEW com.serviceConf.Sica.Reembolso.dto.ReembolsoDTO " +
            "(p.numreemb , p.dataped ,p.numtkt, p.cartao, p.pax, p.usuario, p.datareg, " +
            "p.codemp, p.codcia, p.dataemi, p.datalibe, p.dataree, p.liberado, p.numvend, " +
            "p.reembolsado, p.rvalcmcl, p.rvalrpcl, p.rvalrpfn, p.texto, p.valclie, p.valtxadm, " +
            "p.vlcartao, p.cancelado, p.loc, p.recnsica, p.multclie, p.tarifbrl, p.taxbrl, p.trfAdic, " +
            "p.trfadbrl, p.valpaxcl, p.multforn, p.tipodoc, p.processado, p.obs, p.importado, p.solicitado) " +
            "from Reembolso p " +
            " where " +
            "p.dataree BETWEEN :dataI and :dataF " +
            "AND p.codemp= :codemp AND p.tipodoc='REE' order by p.numreemb desc")
    List<ReembolsoDTO> consultaDataReembolso(Date dataI,Date dataF,Integer codemp);

    @Transactional(readOnly = true)
    @Query("SELECT NEW com.serviceConf.Sica.Reembolso.dto.ReembolsoDTO " +
            "(p.numreemb , p.dataped ,p.numtkt, p.cartao, p.pax, p.usuario, p.datareg, " +
            "p.codemp, p.codcia, p.dataemi, p.datalibe, p.dataree, p.liberado, p.numvend, " +
            "p.reembolsado, p.rvalcmcl, p.rvalrpcl, p.rvalrpfn, p.texto, p.valclie, p.valtxadm, " +
            "p.vlcartao, p.cancelado, p.loc, p.recnsica, p.multclie, p.tarifbrl, p.taxbrl, p.trfAdic, " +
            "p.trfadbrl, p.valpaxcl, p.multforn, p.tipodoc, p.processado, p.obs, p.importado, p.solicitado) " +
            "from Reembolso p " +
            " where " +
            "p.dataped BETWEEN :dataI and :dataF " +
            "AND p.codemp= :codemp AND p.tipodoc='REE' order by p.numreemb desc")
    List<ReembolsoDTO> consultaDataSolicitacao(Date dataI,Date dataF,Integer codemp);

    @Transactional(readOnly = true)
    @Query("SELECT NEW com.serviceConf.Sica.Reembolso.dto.ReembolsoDTO " +
            "(p.numreemb , p.dataped ,p.numtkt, p.cartao, p.pax, p.usuario, p.datareg, " +
            "p.codemp, p.codcia, p.dataemi, p.datalibe, p.dataree, p.liberado, p.numvend, " +
            "p.reembolsado, p.rvalcmcl, p.rvalrpcl, p.rvalrpfn, p.texto, p.valclie, p.valtxadm, " +
            "p.vlcartao, p.cancelado, p.loc, p.recnsica, p.multclie, p.tarifbrl, p.taxbrl, p.trfAdic, " +
            "p.trfadbrl, p.valpaxcl, p.multforn, p.tipodoc, p.processado, p.obs, p.importado, p.solicitado) " +
            "from Reembolso p " +
            " where " +
            "p.dataemi BETWEEN :dataI and :dataF " +
            "AND p.codemp= :codemp AND p.tipodoc='REE' order by p.numreemb desc")
    List<ReembolsoDTO> consultaDataEmissao(Date dataI,Date dataF,Integer codemp);
}
