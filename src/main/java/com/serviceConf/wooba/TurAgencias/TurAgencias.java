package com.serviceConf.wooba.TurAgencias;

import com.serviceConf.wooba.TurUnidadesOperacionais.TurUnidadesOperacionais;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "turAgencias")
public class TurAgencias {
    @Id
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Nome")
    private String nome;
    @Column(name = "Logomarca")
    private String logomarca;
    @ManyToOne
    @JoinColumn(name = "Unidade")
    private TurUnidadesOperacionais turUnidadesOperacionais;
    @Column(name = "IdErp")
    private String idErp;
}
