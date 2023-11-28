package com.serviceConf.confiancaManger.AeroportoWooba;

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
@Table(name = "aeroportoWooba")
public class AeroportoWooba {
    @Id
    @Column(name = "Id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "codigo_iata")
    private String codigoIata;
}
