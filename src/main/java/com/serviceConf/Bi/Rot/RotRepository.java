package com.serviceConf.Bi.Rot;

import com.serviceConf.Bi.Rot.dto.RotDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RotRepository extends JpaRepository<Rot, Integer> {
/*
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value ="insert into Rot (fatura)" +
            " values" +
            " (:#{#rotDTO.fatura})", nativeQuery = true)
    public void cadastro(@Param("rotDTO") RotDTO rotDTO);*/

/*
    @Modifying
    @Query(
            value =
                    "insert into Rot (fatura) values (:teste)",
            nativeQuery = true)
    public void insertUser(@Param("teste") String teste);*/
}
