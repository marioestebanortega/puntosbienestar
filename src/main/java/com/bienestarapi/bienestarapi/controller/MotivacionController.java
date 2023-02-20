package com.bienestarapi.bienestarapi.controller;
import com.bienestarapi.bienestarapi.dto.MotivacionDto;
import com.bienestarapi.bienestarapi.entity.Motivacion;
import com.bienestarapi.bienestarapi.service.MotivacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/motivacion")
//@CrossOrigin(origins = {"http://localhost:8080", "http://localhost", "http://localhost:4200", "https://soporte.serviciocivil.gov.co", "http://20.172.240.181"})
@CrossOrigin(origins = "*")
public class MotivacionController {

    @Autowired
    MotivacionService motivacionService;

    @GetMapping("/lista")
    public ResponseEntity<List<Motivacion>> list(){

        try {
            List<Motivacion> list = motivacionService.list();
            return new ResponseEntity(list, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody MotivacionDto motivaciondto){

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            Motivacion motivacion = new Motivacion(motivaciondto.getNombre(), motivaciondto.getDescripcion(), motivaciondto.getPuntos(), dtf.format(LocalDateTime.now()),
                    motivaciondto.getUsucrea(), null, null);
            motivacionService.save(motivacion);
            return new ResponseEntity("Creado con éxito.", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Motivacion> getByIdmotivacionDetail(@PathVariable("id") Long idmotivacion){

        try {
            Optional<Motivacion> motivacion = motivacionService.getOne(idmotivacion);
            return new ResponseEntity(motivacion, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }
}
