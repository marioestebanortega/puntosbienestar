package com.bienestarapi.bienestarapi.controller;
import com.bienestarapi.bienestarapi.dto.UsuariorolDto;
import com.bienestarapi.bienestarapi.entity.Usuariorol;
import com.bienestarapi.bienestarapi.service.UsuariorolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuariorol")
//@CrossOrigin(origins = {"http://localhost:8080", "http://localhost", "http://localhost:4200", "https://soporte.serviciocivil.gov.co", "http://20.172.240.181"})
@CrossOrigin(origins = "*")
public class UsuariorolController {

    @Autowired
    UsuariorolService usuariorolService;

    @GetMapping("/lista")
    public ResponseEntity<List<Usuariorol>> list(){

        try {
            List<Usuariorol> list = usuariorolService.list();
            return new ResponseEntity(list, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody UsuariorolDto usuarioroldto){

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            Usuariorol Usuariorol = new Usuariorol(usuarioroldto.getIdrol(), usuarioroldto.getIdentificacion(), usuarioroldto.getNombre(),
                    usuarioroldto.getUsucrea(), dtf.format(LocalDateTime.now()), null, null);
            usuariorolService.save(Usuariorol);
            return new ResponseEntity("Creado con éxito.", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Usuariorol> getByIdusuariorolDetail(@PathVariable("id") Long idusuariorol){

        try {
            Optional<Usuariorol> usuariorol = usuariorolService.getOne(idusuariorol);
            return new ResponseEntity(usuariorol, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }
}
