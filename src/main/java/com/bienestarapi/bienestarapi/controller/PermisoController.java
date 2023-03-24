package com.bienestarapi.bienestarapi.controller;

import com.bienestarapi.bienestarapi.dto.*;
import com.bienestarapi.bienestarapi.entity.Permiso;
import com.bienestarapi.bienestarapi.entity.Puntosacumulados;
import com.bienestarapi.bienestarapi.service.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/permiso")
//@CrossOrigin(origins = {"http://localhost:8080", "http://localhost", "http://localhost:4200", "https://soporte.serviciocivil.gov.co", "http://20.172.240.181"})
@CrossOrigin(origins = "*")
public class PermisoController {

    @Autowired
    PermisoService permisoService;

    @GetMapping("/lista")
    public ResponseEntity<List<Permiso>> list() {

        try {
            List<Permiso> list = permisoService.list();
            return new ResponseEntity(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Ha ocurrido un problema.", 0), HttpStatus.NOT_MODIFIED);
        }
    }

    @PutMapping("/actualizarEstado")
    public ResponseEntity<Permiso> create(@RequestBody LinkedHashMap<String,Integer> list){

        try {
            Integer id=list.get("id");
            Integer estado=list.get("estado");
            Permiso permisoActualizado=permisoService.actualizarEstado(id,estado);
            return new ResponseEntity(permisoActualizado, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/permisosPorVigenciaYUsuario/{idVigencia}/{idUser}/{rol}")
    public ResponseEntity<List<PermisoResponseDto>> permisosPorVigenciaYUsuario(@PathVariable("idVigencia") Integer idvigencia, @PathVariable("idUser") String idUser, @PathVariable("rol") String rol) {

        try {
            List<PermisoResponseDto> list = permisoService.permisosPorVigenciaYUsuario(idvigencia,idUser,rol);
            return new ResponseEntity(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new Mensaje("Ha ocurrido un problema.", 0), HttpStatus.NOT_MODIFIED);
        }
    }



    @GetMapping("/detail/{id}")
    public ResponseEntity<Permiso> getByIdpermisoDetail(@PathVariable("id") Long idpermiso) {

        try {
            Optional<Permiso> permiso = permisoService.getOne(idpermiso);
            return new ResponseEntity(permiso, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Ha ocurrido un problema.", 0), HttpStatus.NOT_MODIFIED);
        }
    }
}
