package com.serviceConf.Auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auth implements Serializable {
    private String loginUsuario;
    private String senha;
}
