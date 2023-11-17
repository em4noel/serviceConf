package com.serviceConf.Sica.Acordo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcordoRepository extends JpaRepository<Acordo, Integer> {
}
