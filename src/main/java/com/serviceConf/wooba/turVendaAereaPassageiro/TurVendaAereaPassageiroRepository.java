package com.serviceConf.wooba.turVendaAereaPassageiro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurVendaAereaPassageiroRepository extends JpaRepository<TurVendaAereaPassageiro, Integer> {
    List<TurVendaAereaPassageiro> findByVenda(Integer venda);
}
