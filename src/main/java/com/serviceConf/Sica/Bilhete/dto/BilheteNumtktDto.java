package com.serviceConf.Sica.Bilhete.dto;

import lombok.Data;

@Data
public class BilheteNumtktDto {
    private String codest;
    private Integer iata;
    private String loc;

    public BilheteNumtktDto(String codest, Integer iata, String loc) {
        this.codest = codest;
        this.iata = iata;
        this.loc = loc;
    }
}
