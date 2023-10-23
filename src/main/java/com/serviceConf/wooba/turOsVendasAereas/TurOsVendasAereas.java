package com.serviceConf.wooba.turOsVendasAereas;

import com.serviceConf.wooba.turOS.TurOS;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "turOsVendasAereas")
public class TurOsVendasAereas {
    @Id
    @Column(name = "Id")
    private Integer id;
    @Column(name = "turOsId")
    private Integer turOsId;
    @Column(name = "turOsVendasAereasId")
    private Integer turOsVendasAereasId;
}
