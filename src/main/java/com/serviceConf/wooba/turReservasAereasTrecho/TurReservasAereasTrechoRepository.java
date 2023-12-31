package com.serviceConf.wooba.turReservasAereasTrecho;

import com.serviceConf.wooba.turReservasAereasTrecho.dto.CheckinVooDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface TurReservasAereasTrechoRepository extends JpaRepository<TurReservasAereasTrecho, Integer> {

    @Transactional(readOnly = true)
    @Query(value = " SELECT NEW com.serviceConf.wooba.turReservasAereasTrecho.dto.CheckinVooDto " +
            "( tre.id, v.trecho, ag.nomeAgencia, u.nomeUnidade, ag.logomarca, us.nomeCompleto, us.email, rs.reservaId, v.numeroDaCompanhia, " +
            " v.numeroDoBilhete, v.numeroBilheteOriginal, v.tktBilhete, v.localizador, " +
            " tre.localizadorCompanhia, tre.segmento, tre.conexao, tre.de, tre.dsOrigem, tre.para, tre.dsDestino, tre.companhia, tre.duracaoVoo, " +
            " tre.data, v.dataDaInclusao, v.dataDeAlteracao, tre.hora, tre.voo, tre.horaRetorno, v.status, v.passageiro, v.reemissao, v.reemissaoTipo ) " +
            " FROM TurReservasAereasTrecho tre, TurVendasAereas v, TurReservasAereas rs, TurAgencias ag, TurUnidadesOperacionais u, TurUsuarios us " +
            " WHERE tre.reserva = rs.reservaId " +
            " AND rs.agencia = ag.id " +
            " AND v.agencia = ag.id " +
            " AND rs.usuario = us.id " +
            " AND v.unidade = u.id " +
            " AND u.nomeUnidade <> 'CWB' " +
            " AND u.nomeUnidade <> 'CWB - GR'" +
            " AND v.localizador = rs.localizador " +
            " AND v.status = 1 " +
            " AND rs.status <> 3 " +
            " AND ag.nomeAgencia <> 'ART VIAGENS' " +
            " AND ag.nomeAgencia <> 'MAXMILHAS' " +
            //" AND tre.localizadorCompanhia IN ('4PB65Q', 'MGJAYR','OIVNOM','EARALQ')" +
            " AND v.dataDeEmbarque BETWEEN :dataInicial and :dataFinal  " +
            //" AND tre.data BETWEEN '2023-11-26 00:00:00' AND '2023-11-29 23:59:59' " +
            " ORDER BY tre.id ASC ")
    List<CheckinVooDto> findByCheckin(Date dataInicial, Date dataFinal);
}
