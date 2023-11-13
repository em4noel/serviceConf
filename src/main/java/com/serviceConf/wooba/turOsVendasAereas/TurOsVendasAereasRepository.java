package com.serviceConf.wooba.turOsVendasAereas;

import com.serviceConf.wooba.turOsVendasAereas.dto.FindOsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface TurOsVendasAereasRepository extends JpaRepository<TurOsVendasAereas, Integer> {
    @Transactional
    @Query("SELECT NEW  com.serviceConf.wooba.turOsVendasAereas.dto.FindOsDto " +
            " (os.numero, os.dataAbertura, os.dataViagem, os.passageiro, os.descricao, os.solicitanteNome, " +
            " os.solicitanteEmail, os.campoExtra1Descricao,  os.campoExtra2Valor, os.campoExtra3Descricao,  " +
            " os.campoExtra4Descricao, os.campoExtra5Valor, os.id) " +
            " FROM TurOsVendasAereas osv, TurOS os " +
            " WHERE osv.turOsId=os.id " +
            " and osv.turOsVendasAereasId=:idReserva")
    List<FindOsDto> findByOs(@PathVariable Integer idReserva);

}
