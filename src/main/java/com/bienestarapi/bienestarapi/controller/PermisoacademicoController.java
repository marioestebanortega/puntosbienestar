package com.bienestarapi.bienestarapi.controller;

import com.bienestarapi.bienestarapi.dto.Mensaje;
import com.bienestarapi.bienestarapi.dto.PermisoacademicoDto;
import com.bienestarapi.bienestarapi.entity.Permisoacademico;
import com.bienestarapi.bienestarapi.service.PermisoacademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/permisoacademico")
//@CrossOrigin(origins = {"http://localhost:8080", "http://localhost", "http://localhost:4200", "https://soporte.serviciocivil.gov.co", "http://20.172.240.181"})
@CrossOrigin(origins = "*")
public class PermisoacademicoController {

    @Autowired
    PermisoacademicoService permisoacademicoService;

    @GetMapping("/lista")
    public ResponseEntity<List<Permisoacademico>> list() {

        try {
            List<Permisoacademico> list = permisoacademicoService.list();
            return new ResponseEntity(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PermisoacademicoDto permisoacademicodto) {

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            Permisoacademico permisoacademico = new Permisoacademico(permisoacademicodto.getIdpermiso(), permisoacademicodto.getInstitucion(), permisoacademicodto.getIdperiodicidad(), permisoacademicodto.getDias(),
                    permisoacademicodto.getHoras(), permisoacademicodto.getFechaini(), permisoacademicodto.getFechafin(), permisoacademicodto.getHoraini(), permisoacademicodto.getHorafin(),
                    permisoacademicodto.getUsucrea(), dtf.format(LocalDateTime.now()), null, null);
            long idpermisoacademico = permisoacademicoService.save(permisoacademico);
            return new ResponseEntity(new Mensaje("Creado con éxito.", idpermisoacademico), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Ha ocurrido un problema.", 0), HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Permisoacademico> getByIdpermisoacademicoDetail(@PathVariable("id") Long idpermisoacademico) {

        try {
            Optional<Permisoacademico> permisoacademico = permisoacademicoService.getOne(idpermisoacademico);
            return new ResponseEntity(permisoacademico, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Ha ocurrido un problema.", 0), HttpStatus.NOT_MODIFIED);
        }
    }
}
