package com.serviceConf.Sica.Venda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {

    Optional<Venda> findByNumvend(Integer numVend);
}
