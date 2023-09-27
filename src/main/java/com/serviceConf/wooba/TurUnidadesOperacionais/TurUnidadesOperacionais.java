package com.serviceConf.wooba.TurUnidadesOperacionais;

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
@Table(name = "turUnidadesOperacionais")
public class TurUnidadesOperacionais {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "Nome")
    private String nomeUnidade;
}
