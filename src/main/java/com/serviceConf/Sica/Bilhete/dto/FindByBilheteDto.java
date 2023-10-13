package com.serviceConf.Sica.Bilhete.dto;

import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;

@Data
public class FindByBilheteDto {
    private Integer numvend;
    private Double totrpfn;
    private String codest;
    private Double totaltrf;

    public FindByBilheteDto(Integer numvend, Double totrpfn, String codest, Double totaltrf) {
        this.numvend = numvend;
        this.totrpfn = totrpfn;
        this.codest = codest;
        this.totaltrf = totaltrf;
    }
}
