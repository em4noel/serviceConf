package com.serviceConf.confiancaManger.CheckinCron;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "checkin_cron")
public class CheckinCron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codg_checkin_cron")
    private Integer codgCheckinCron;
    @Column(name = "ultima_data")
    private Date ultimaData;
    @Column(name = "proxima_data")
    private Date proximaData;
    @Column(name = "status_envio")
    private Integer statusEnvio;
}
