package com.serviceConf.Sica.Reembolso;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostReembolsoSicaModel implements Serializable {

    private Date dataI;
    private Date dataF;
    private Integer codemp;
    private String tipoData;
}
