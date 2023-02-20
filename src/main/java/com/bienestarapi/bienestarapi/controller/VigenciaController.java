package com.bienestarapi.bienestarapi.controller;
import com.bienestarapi.bienestarapi.dto.VigenciaDto;
import com.bienestarapi.bienestarapi.entity.Vigencia;
import com.bienestarapi.bienestarapi.service.VigenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vigencia")
//@CrossOrigin(origins = {"http://localhost:8080", "http://localhost", "http://localhost:4200", "https://soporte.serviciocivil.gov.co", "http://20.172.240.181"})
@CrossOrigin(origins = "*")
public class VigenciaController {

    @Autowired
    VigenciaService vigenciaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Vigencia>> list(){

        try {
            List<Vigencia> list = vigenciaService.list();
            return new ResponseEntity(list, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody VigenciaDto vigenciadto){

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            Vigencia Vigencia = new Vigencia(vigenciadto.getVigencia(), vigenciadto.getFechaini(), vigenciadto.getFechafin(),
                    dtf.format(LocalDateTime.now()), vigenciadto.getUsucrea(), null, null);
            vigenciaService.save(Vigencia);
            return new ResponseEntity("Creado con éxito.", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Vigencia> getByIdvigenciaDetail(@PathVariable("id") Long idvigencia){

        try {
            Optional<Vigencia> vigencia = vigenciaService.getOne(idvigencia);
            return new ResponseEntity(vigencia, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }
}
