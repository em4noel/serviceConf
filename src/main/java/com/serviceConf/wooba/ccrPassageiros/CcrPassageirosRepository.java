package com.serviceConf.wooba.ccrPassageiros;

import com.serviceConf.wooba.ccrPassageiros.CcrPassageiros;
import com.serviceConf.wooba.ccrPassageiros.dto.CcrPassageiroDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface CcrPassageirosRepository extends JpaRepository<CcrPassageiros, Integer> {
    @Transactional(readOnly = true)
    @Query(" SELECT NEW com.serviceConf.wooba.ccrPassageiros.dto.CcrPassageiroDto " +
            " (cp.nome, cp.sobrenome,  cp.nomeDoMeio, cp.cpf, cp.nascimento, cp.rua, " +
            "cp.bairro, cp.cidadeNome, cp.celular, cp.cargo, cp.matricula, cp.notas, cp.apelido ) " +
            " FROM TurOsPassageiros op, CcrPassageiros cp " +
            " WHERE op.ccrPassageirosId=cp.id " +
            " AND op.turOsId= :id")
    List<CcrPassageiroDto> findByCcrPassageiros(@PathVariable Integer id);
}
