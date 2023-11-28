package com.serviceConf.confiancaManger.Trecho.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TrechoDto {
    private Integer status;
    private Date dateFrom;
    private Date dateTo;
}
