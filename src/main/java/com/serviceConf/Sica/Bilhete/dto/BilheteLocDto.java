package com.serviceConf.Sica.Bilhete.dto;

import lombok.Data;

@Data
public class BilheteLocDto {
    private Integer numvend;
    private String codest;
    private String pax;
    private String numtkt;

    public BilheteLocDto(Integer numvend, String codest, String pax, String numtkt) {
        this.numvend = numvend;
        this.codest = codest;
        this.pax = pax;
        this.numtkt = numtkt;
    }
}
