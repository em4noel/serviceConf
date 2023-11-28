package com.serviceConf.confiancaManger.CheckinLink;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "checkin_link")
public class CheckinLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codg_checkin_link")
    private Integer codgCheckinLink;
    @Column(name = "sigla")
    private String sigla;
    @Column(name = "nome_companhia")
    private String nomeCompanhia;
    @Column(name = "link")
    private String link;
}
