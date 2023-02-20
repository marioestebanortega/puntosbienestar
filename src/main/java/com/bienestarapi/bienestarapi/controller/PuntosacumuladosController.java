package com.bienestarapi.bienestarapi.controller;
import com.bienestarapi.bienestarapi.dto.PuntosacumuladosDto;
import com.bienestarapi.bienestarapi.entity.Puntosacumulados;
import com.bienestarapi.bienestarapi.service.PuntosacumuladosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/puntosacumulados")
//@CrossOrigin(origins = {"http://localhost:8080", "http://localhost", "http://localhost:4200", "https://soporte.serviciocivil.gov.co", "http://20.172.240.181"})
@CrossOrigin(origins = "*")
public class PuntosacumuladosController {

    @Autowired
    PuntosacumuladosService puntosacumuladosService;

    @GetMapping("/lista")
    public ResponseEntity<List<Puntosacumulados>> list(){

        try {
            List<Puntosacumulados> list = puntosacumuladosService.list();
            return new ResponseEntity(list, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PuntosacumuladosDto puntosacumuladosdto){

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            Puntosacumulados Puntosacumulados = new Puntosacumulados(puntosacumuladosdto.getIdentificacion(), puntosacumuladosdto.getIdvigencia(), puntosacumuladosdto.getIdmotivacion(),
                    puntosacumuladosdto.getMotivacion(),puntosacumuladosdto.getPuntos(), puntosacumuladosdto.getFecharadica(),
                    dtf.format(LocalDateTime.now()),puntosacumuladosdto.getUsucrea(), null, null);
            puntosacumuladosService.save(Puntosacumulados);
            return new ResponseEntity("Creado con éxito.", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Puntosacumulados> getByIdpuntosacumuladosDetail(@PathVariable("id") Long idpuntosacumulados){

        try {
            Optional<Puntosacumulados> puntosacumulados = puntosacumuladosService.getOne(idpuntosacumulados);
            return new ResponseEntity(puntosacumulados, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }
}