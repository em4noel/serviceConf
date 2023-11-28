package com.serviceConf.confiancaManger.AeroportoWooba;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AeroportoWoobaRepository extends JpaRepository<AeroportoWooba, Integer> {
    Optional<AeroportoWooba> findByCodigoIata(String codigoIata);
}
