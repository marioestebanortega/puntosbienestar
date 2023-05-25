package com.bienestarapi.bienestarapi.controller;

import com.bienestarapi.bienestarapi.dto.AlternativaVigenciaDto;
import com.bienestarapi.bienestarapi.service.AdministradoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administradores")
//@CrossOrigin(origins = {"http://localhost:8080", "http://localhost", "http://localhost:4200", "https://soporte.serviciocivil.gov.co", "http://20.172.240.181"})
@CrossOrigin(origins = "*")
public class AdministradoresController {

    @Autowired
    private AdministradoresService administradoresService;


    @GetMapping("/esAdministrador/{documento}")
    public ResponseEntity<Boolean> esAdministrador(@PathVariable String documento) {
       Boolean esAdministrador =administradoresService.esAdministrador(documento);
       return new ResponseEntity<Boolean>(esAdministrador,HttpStatus.OK);
    }
}
