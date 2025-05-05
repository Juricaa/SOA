package com.app.emploi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employe")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employe {
@Id
@JsonProperty("numEmp")
private String numEmp;
@Column(name = "nom")
private String nom;
@Column(name = "adresse")
private String adresse;
@Column(name = "email")
private String email;
@ManyToOne
    @JoinColumn(name="idComp", referencedColumnName = "idComp")  // Faire correspondre la colonne idComp de Compagnie
    private Compagnie compagnie;
}
