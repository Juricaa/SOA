package com.app.emploi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.emploi.model.ConseillerRH;

import com.app.emploi.service.ConseillerService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("conseiller")
@Tag(name = "Conseiller" , description = "Service conseiller")
public class ConseillerController {
     private final ConseillerService conseillerServ;
    public ConseillerController(ConseillerService conseillerServ){
        this.conseillerServ= conseillerServ;
    }
    @GetMapping
    @Operation( summary = "list conseiller", description="")
    public List<ConseillerRH> getAllConseiller() {
        return conseillerServ.getAllConseiller();
    }
    @PostMapping
    @Operation(summary = "Ajout Conseiller", description = "Ajoute un employe avec numEmp, nom, nb jours et taux jour")
    public ResponseEntity<ConseillerRH> createConseiller(@Valid @RequestBody ConseillerRH conseil) {   
        return new ResponseEntity<>(conseillerServ.createConseiller(conseil), HttpStatus.CREATED);  
        }

    @PutMapping("/{id}")
    @Operation(summary = "modifier conseiller", description = "modifier un conseiller ")
    public ResponseEntity<ConseillerRH> updateEmpl(@PathVariable String id, @Valid @RequestBody ConseillerRH conseiller ){
            return ResponseEntity.ok(conseillerServ.updateConseiller(id, conseiller));
        }
    @DeleteMapping("/{id}")
    @Operation(summary = "supprimer conseiller", description = "supprimer un conseiller")
    public ResponseEntity<Void>  deleteEmpl(  @PathVariable String id){
            conseillerServ.deleteConseiller(id);
            return ResponseEntity.noContent().build();
        }
}
