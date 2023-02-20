package com.bienestarapi.bienestarapi.controller;
import com.bienestarapi.bienestarapi.dto.RolDto;
import com.bienestarapi.bienestarapi.entity.Rol;
import com.bienestarapi.bienestarapi.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rol")
//@CrossOrigin(origins = {"http://localhost:8080", "http://localhost", "http://localhost:4200", "https://soporte.serviciocivil.gov.co", "http://20.172.240.181"})
@CrossOrigin(origins = "*")
public class RolController {

    @Autowired
    RolService rolService;

    @GetMapping("/lista")
    public ResponseEntity<List<Rol>> list(){

        try {
            List<Rol> list = rolService.list();
            return new ResponseEntity(list, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody RolDto roldto){

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            Rol Rol = new Rol(roldto.getNombre(), roldto.getDescripcion(), roldto.getUsucrea(),
                    dtf.format(LocalDateTime.now()), null, null);
            rolService.save(Rol);
            return new ResponseEntity("Creado con éxito.", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Rol> getByIdrolDetail(@PathVariable("id") Long idrol){

        try {
            Optional<Rol> rol = rolService.getOne(idrol);
            return new ResponseEntity(rol, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }
}
