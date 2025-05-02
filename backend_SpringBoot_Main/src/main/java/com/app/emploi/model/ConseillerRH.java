package com.app.emploi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "conseillerRH")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConseillerRH {
    
@Id
@JsonProperty("idConseiller")
private String numEmp;
@Column(name = "nom")
private String nom;
@Column(name = "prenom")
private String adresse;


}
