package com.bienestarapi.bienestarapi.controller;

import com.bienestarapi.bienestarapi.dto.*;
import com.bienestarapi.bienestarapi.entity.*;
import com.bienestarapi.bienestarapi.service.*;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/permiso")
//@CrossOrigin(origins = {"http://localhost:8080", "http://localhost", "http://localhost:4200", "https://soporte.serviciocivil.gov.co", "http://20.172.240.181"})
@CrossOrigin(origins = "*")
public class PermisoController {

    @Autowired
    PermisoService permisoService;

    @Autowired
    PuntosacumuladosService puntosacumuladosService;

    @Autowired
    TipopermisoService tipopermisoService;

    @Autowired
    AlternativaVigenciaService alternativaVigenciaService;

    @Autowired


    @GetMapping("/lista")
    public ResponseEntity<List<Permiso>> list() {

        try {
            List<Permiso> list = permisoService.list();
            return new ResponseEntity(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Ha ocurrido un problema.", 0), HttpStatus.NOT_MODIFIED);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PermisoDto permisodto) {

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            Permiso permiso = new Permiso(permisodto.getIdentificacion(), permisodto.getIdvigencia(), permisodto.getIdtipopermiso(), permisodto.getFecharadicacion(),
                    permisodto.getFechaini(), permisodto.getFechafin(), permisodto.getHoraini(), permisodto.getHorafin(), permisodto.getObservacion(),
                    permisodto.getAcedemico(), permisodto.getJefe(), permisodto.getDirector(), permisodto.getUsucrea(), dtf.format(LocalDateTime.now()),
                    null, null, permisodto.getIdestadopermiso());
            long idpermiso = permisoService.save(permiso);
            return new ResponseEntity(new Mensaje("Creado con éxito.", idpermiso), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new Mensaje("Ha ocurrido un problema.", 0), HttpStatus.NOT_MODIFIED);
        }
    }

    @PutMapping("/actualizarEstado")
    public ResponseEntity<Permiso> create(@RequestBody LinkedHashMap<String,Integer> list){

        try {
            Integer id=list.get("id");
            Integer estado=list.get("estado");
            Integer idVigencia=list.get("idVigencia");
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
