package com.gateway.gateway.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employe{
    private String numEmp;
    private String nom;
    private String email;
    private String adresse;
    
}