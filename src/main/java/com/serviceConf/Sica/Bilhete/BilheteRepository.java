package com.serviceConf.Sica.Bilhete;

import com.serviceConf.Sica.Bilhete.dto.FindByBilheteDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BilheteRepository extends JpaRepository<Bilhete, Integer> {
    Optional<Bilhete> findFirstByLoc(String loc);

    @Query("SELECT NEW com.serviceConf.Sica.Bilhete.dto.FindByBilheteDto " +
            "(v.numvend, v.totrpfn, v.codest, v.totaltrf) " +
            "FROM Venda v, Bilhete b " +
            "WHERE v.numvend= b.numvend " +
            "and b.numtkt =:numeroBilhete ")
    List<FindByBilheteDto>findByBilhete(String numeroBilhete);

}
