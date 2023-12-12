package com.serviceConf.wooba.turVendasAereas;

import com.serviceConf.wooba.turVendasAereas.dto.FindByLocalizadorDto;
import com.serviceConf.wooba.turVendasAereas.dto.FindVendaByDataEmissaoDto;
import com.serviceConf.wooba.turVendasAereas.dto.PassageirosTurVendasAereasDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TurVendasAereasRepository extends JpaRepository<TurVendasAereas, Integer> {
    @Transactional
    @Query(" SELECT NEW com.serviceConf.wooba.turVendasAereas.dto.FindVendaByDataEmissaoDto " +
            " (v.id, v.localizador, v.origem, v.destino, v.tarifa, " +
            " v.taxa, v.ccRequisicao, v.emitidoEm, v.dataDeEmbarque, v.companhia) " +
            " FROM TurVendasAereas v " +
            " WHERE v.emitidoEm BETWEEN :dataInicial AND :dataFinal   " +
            "and v.cliente=227  and v.status=1")
    List<FindVendaByDataEmissaoDto> fingByDataEmissao(@PathVariable Date dataInicial, @PathVariable Date dataFinal);

    @Transactional
    @Query(" SELECT NEW com.serviceConf.wooba.turVendasAereas.dto.PassageirosTurVendasAereasDto " +
            " (passageiro, tipoDePassageiro, numeroDoBilhete, tarifa, taxa, taxaRepasseDeTerceiros, passageiroSexo, requisicao  )" +
            " FROM TurVendasAereas " +
            " WHERE id=:id")
    List<PassageirosTurVendasAereasDto> findByVenda(@PathVariable Integer id);

    @Transactional
    @Query(" SELECT NEW com.serviceConf.wooba.turVendasAereas.dto.FindByLocalizadorDto " +
            " ( v.localizador, v.numeroDoBilhete, v.passageiro) " +
            " FROM TurVendasAereas v " +
            " WHERE v.numeroDoBilhete =:numero AND v.passageiro=:pax")
    Optional<FindByLocalizadorDto> findByLocalizadorNulo(@PathVariable String numero, @PathVariable String pax);


}
