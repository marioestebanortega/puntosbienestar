package com.bienestarapi.bienestarapi.controller;
import com.bienestarapi.bienestarapi.dto.TipopermisoDto;
import com.bienestarapi.bienestarapi.entity.Tipopermiso;
import com.bienestarapi.bienestarapi.service.TipopermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipopermiso")
//@CrossOrigin(origins = {"http://localhost:8080", "http://localhost", "http://localhost:4200", "https://soporte.serviciocivil.gov.co", "http://20.172.240.181"})
@CrossOrigin(origins = "*")
public class TipopermisoController {

    @Autowired
    TipopermisoService tipopermisoService;

    @GetMapping("/lista")
    public ResponseEntity<List<Tipopermiso>> list(){

        try {
            List<Tipopermiso> list = tipopermisoService.list();
            return new ResponseEntity(list, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody TipopermisoDto tipopermisodto){

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            Tipopermiso Tipopermiso = new Tipopermiso(tipopermisodto.getNombre(), tipopermisodto.getDescripcion(), tipopermisodto.getPuntos(),
                    tipopermisodto.getUsucrea(), dtf.format(LocalDateTime.now()), null, null);
            tipopermisoService.save(Tipopermiso);
            return new ResponseEntity("Creado con éxito.", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Tipopermiso> getByIdtipopermisoDetail(@PathVariable("id") Long idtipopermiso){

        try {
            Optional<Tipopermiso> tipopermiso = tipopermisoService.getOne(idtipopermiso);
            return new ResponseEntity(tipopermiso, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }
}
