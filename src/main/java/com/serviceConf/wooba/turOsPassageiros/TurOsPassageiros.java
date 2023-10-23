package com.serviceConf.wooba.turOsPassageiros;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "turOsPassageiros")
public class TurOsPassageiros {
    @Id
    @Column(name = "Id")
    private Integer id;
    @Column(name = "ccrPassageirosId")
    private Integer ccrPassageirosId;
    @Column(name = "turOsId")
    private Integer turOsId;
}
