package com.serviceConf.wooba.TurVendasAereas;

import com.serviceConf.wooba.TurVendasAereas.dto.FindVendaByDataEmissaoDto;
import com.serviceConf.wooba.TurVendasAereas.dto.PassageirosTurVendasAereasDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

public interface TurVendasAereasRepository extends JpaRepository<TurVendasAereas, Integer> {
    @Transactional
    @Query(" SELECT NEW com.serviceConf.wooba.TurVendasAereas.dto.FindVendaByDataEmissaoDto " +
            " (v.id, v.localizador, v.origem, v.destino, v.tarifa, " +
            " v.taxa, v.ccRequisicao, v.emitidoEm, v.dataDeEmbarque, v.companhia) " +
            " FROM TurVendasAereas v " +
            " WHERE v.emitidoEm BETWEEN :dataInicial AND :dataFinal   " +
            "and v.cliente=227  and v.status=1")
     List<FindVendaByDataEmissaoDto> fingByDataEmissao(@PathVariable Date dataInicial, @PathVariable Date dataFinal);

    @Transactional
    @Query(" SELECT NEW com.serviceConf.wooba.TurVendasAereas.dto.PassageirosTurVendasAereasDto " +
            " (passageiro, tipoDePassageiro, numeroDoBilhete, tarifa, taxa, taxaRepasseDeTerceiros, passageiroSexo, requisicao  )" +
            " FROM TurVendasAereas " +
            " WHERE id=:id")
    List<PassageirosTurVendasAereasDto> findByVenda(@PathVariable Integer id);



}
