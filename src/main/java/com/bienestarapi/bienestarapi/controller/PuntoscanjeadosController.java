package com.bienestarapi.bienestarapi.controller;
import com.bienestarapi.bienestarapi.dto.PuntoscanjeadosDto;
import com.bienestarapi.bienestarapi.entity.Puntoscanjeados;
import com.bienestarapi.bienestarapi.service.PuntoscanjeadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/puntoscanjeados")
//@CrossOrigin(origins = {"http://localhost:8080", "http://localhost", "http://localhost:4200", "https://soporte.serviciocivil.gov.co", "http://20.172.240.181"})
@CrossOrigin(origins = "*")
public class PuntoscanjeadosController {

    @Autowired
    PuntoscanjeadosService puntoscanjeadosService;

    @GetMapping("/lista")
    public ResponseEntity<List<Puntoscanjeados>> list(){

        try {
            List<Puntoscanjeados> list = puntoscanjeadosService.list();
            return new ResponseEntity(list, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PuntoscanjeadosDto puntoscanjeadosdto){

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            Puntoscanjeados Puntoscanjeados = new Puntoscanjeados(puntoscanjeadosdto.getIdentificacion(), puntoscanjeadosdto.getIdvigencia(), puntoscanjeadosdto.getTipopermiso(),
                    puntoscanjeadosdto.getPuntos(), puntoscanjeadosdto.getFecharadica(), puntoscanjeadosdto.getIdpermiso(),dtf.format(LocalDateTime.now()),puntoscanjeadosdto.getUsucrea(), null, null);
            puntoscanjeadosService.save(Puntoscanjeados);
            return new ResponseEntity("Creado con éxito.", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Puntoscanjeados> getByIdpuntoscanjeadosDetail(@PathVariable("id") Long idpuntoscanjeados){

        try {
            Optional<Puntoscanjeados> puntoscanjeados = puntoscanjeadosService.getOne(idpuntoscanjeados);
            return new ResponseEntity(puntoscanjeados, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Puntoscanjeados> getByIdentificacion(@PathVariable("id") String identificacion){

        try {
            Optional<Puntoscanjeados> puntoscanjeados = puntoscanjeadosService.getByIdentificacion(identificacion);
            return new ResponseEntity(puntoscanjeados, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }
}