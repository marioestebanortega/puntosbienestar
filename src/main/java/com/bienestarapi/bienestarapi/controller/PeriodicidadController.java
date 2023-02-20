package com.bienestarapi.bienestarapi.controller;
import com.bienestarapi.bienestarapi.dto.PeriodicidadDto;
import com.bienestarapi.bienestarapi.entity.Periodicidad;
import com.bienestarapi.bienestarapi.service.PeriodicidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/periodicidad")
//@CrossOrigin(origins = {"http://localhost:8080", "http://localhost", "http://localhost:4200", "https://soporte.serviciocivil.gov.co", "http://20.172.240.181"})
@CrossOrigin(origins = "*")
public class PeriodicidadController {

    @Autowired
    PeriodicidadService periodicidadService;

    @GetMapping("/lista")
    public ResponseEntity<List<Periodicidad>> list(){

        try {
            List<Periodicidad> list = periodicidadService.list();
            return new ResponseEntity(list, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PeriodicidadDto Periodicidaddto){

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            Periodicidad Periodicidad = new Periodicidad(Periodicidaddto.getNombre(), Periodicidaddto.getDescripcion(), Periodicidaddto.getUsucrea(),
                    dtf.format(LocalDateTime.now()), null, null);
            periodicidadService.save(Periodicidad);
            return new ResponseEntity("Creado con éxito.", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Periodicidad> getByIdperiodicidadDetail(@PathVariable("id") Long idperiodicidad){

        try {
            Optional<Periodicidad> periodicidad = periodicidadService.getOne(idperiodicidad);
            return new ResponseEntity(periodicidad, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }
}
