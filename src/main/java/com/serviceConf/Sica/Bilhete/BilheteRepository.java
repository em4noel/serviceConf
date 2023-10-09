package com.serviceConf.Sica.Bilhete;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BilheteRepository extends JpaRepository<Bilhete, Integer> {
    Optional<Bilhete> findByLoc(String loc);
}
