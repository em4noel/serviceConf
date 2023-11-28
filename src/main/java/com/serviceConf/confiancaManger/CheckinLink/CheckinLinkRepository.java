package com.serviceConf.confiancaManger.CheckinLink;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckinLinkRepository extends JpaRepository<CheckinLink,Integer> {
}
