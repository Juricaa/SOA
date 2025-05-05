package com.gateway.gateway.controller;

import com.gateway.gateway.DTO.Employe;
import com.gateway.gateway.service.MailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/employe")
public class EmployeGatewayController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MailService emailService;

    private final String EMPLOYE_API_URL = "http://localhost:8081/employes";

    @PutMapping("/{id}")
    public ResponseEntity<Employe> updateEmployeViaGateway(@PathVariable String id,
                                                            @RequestBody Employe employe) {
        // Forward PUT request to internal API
        ResponseEntity<Employe> response = restTemplate.exchange(
                EMPLOYE_API_URL + "/" + id,
                HttpMethod.PUT,
                new HttpEntity<>(employe),
                Employe.class
        );

        // Si l'employé a bien été modifié
        if (response.getStatusCode().is2xxSuccessful()) {
            Employe updatedEmploye = response.getBody();
            if (updatedEmploye != null && updatedEmploye.getEmail() != null) {
                emailService.envoyerEmail(
                    updatedEmploye.getEmail(),
                    "Mise à jour de vos informations",
                    "Bonjour " + updatedEmploye.getNom() + ", vos informations ont été modifiées avec succès."
                );
            }
        }

        return response;
    }
}
