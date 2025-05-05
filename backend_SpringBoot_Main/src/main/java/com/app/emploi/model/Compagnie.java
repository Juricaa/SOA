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
@Table(name = "compagnie")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compagnie {
    @Id
    @JsonProperty("idComp")
    private Long idComp;

   @Column(name="nomComp")
   @JsonProperty("nomComp")
   private String nomComp ;
   @Column(name="mailComp")
   @JsonProperty("mailComp")
   private String mailComp ;
   
}
