package com.serviceConf.confiancaManger.Trecho.dto;

import com.serviceConf.confiancaManger.Checkin.Checkin;
import com.serviceConf.confiancaManger.Trecho.TrechoCheckin;
import lombok.Data;

import java.util.List;

@Data
public class TrechoRsDto {
    private Checkin checkin;
    private List<TrechoCheckin> trechoCheckins;
}
