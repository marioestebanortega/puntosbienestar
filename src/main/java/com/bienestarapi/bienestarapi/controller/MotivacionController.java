package com.bienestarapi.bienestarapi.controller;
import com.bienestarapi.bienestarapi.dto.*;
import com.bienestarapi.bienestarapi.entity.Motivacion;
import com.bienestarapi.bienestarapi.entity.SolicitudMotivacion;
import com.bienestarapi.bienestarapi.service.MotivacionService;
import com.bienestarapi.bienestarapi.service.MotivacionVigenciaService;
import com.bienestarapi.bienestarapi.service.SolicitudMotivacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/motivacion")
//@CrossOrigin(origins = {"http://localhost:8080", "http://localhost", "http://localhost:4200", "https://soporte.serviciocivil.gov.co", "http://20.172.240.181"})
@CrossOrigin(origins = "*")
public class MotivacionController {

    @Autowired
    MotivacionService motivacionService;

    @Autowired
    private MotivacionVigenciaService motivacionVigenciaService;


    @Autowired
    private SolicitudMotivacionService solicitudMotivacionService;


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


    @PostMapping("/guardarSolicitudMotivacion")
    public ResponseEntity<SolicitudMotivacionDTO> guardarSolicitudMotivacion(@RequestBody SolicitudMotivacionDTO solicitudMotivacionDTO) {
        try {
            SolicitudMotivacionDTO smDto= solicitudMotivacionService.guardarSolicitudMotivacion(solicitudMotivacionDTO);
            return new ResponseEntity(smDto, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }

    }



    @PostMapping("/actualizarEstado")
    public ResponseEntity<SolicitudesMotivacionesCustomDto> actualizarEstado(@RequestBody PuntosIn puntosIn) {
        try {
            SolicitudesMotivacionesCustomDto smOut=solicitudMotivacionService.actualizarEstado(puntosIn.getId(),puntosIn.getIdEstado());
            return new ResponseEntity(smOut, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }

    }

    @PostMapping("/guardarConfiguracionesMotivacionesPorVigencia")
    public ResponseEntity<List<MotivacionVigenciaDto>> guardarConfiguracionesMotivacionesPorVigencia(@RequestBody Map<String,List<MotivacionVigenciaDto>> in) {
        try {
            List<MotivacionVigenciaDto> conf= (List<MotivacionVigenciaDto>)in.get("motivations");
            List<MotivacionVigenciaDto> smDto= motivacionVigenciaService.guardarConfiguracionesMotivacionesPorVigencia(conf);
            return new ResponseEntity(smDto, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }

    }

    @GetMapping("/obtenerTodasSolicitudes/{user}/{rol}")
    public ResponseEntity<List<SolicitudesMotivacionesCustomDto>> getAll(@PathVariable("user") String user,@PathVariable("rol") String rol) {
        try {
            return new ResponseEntity(solicitudMotivacionService.obtenerTodasLasSolicitudesMotivacion(user,rol),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/obtenerAcumulado/{idvigencia}/{idUser}")
    public ResponseEntity<Double> obtenerAcumulado(@PathVariable("idvigencia") Integer idvigencia,@PathVariable("idUser") String idUser) {
        try {
            return new ResponseEntity(solicitudMotivacionService.obtenerAcumulado(idvigencia,idUser),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }
    }



    @GetMapping("/motivacionesConValor/{idVigencia}")
    public ResponseEntity<List<MotivacionVigenciaDto>> getMotivacionesConValorPorVigencia(@PathVariable Integer idVigencia) {
        List<MotivacionVigenciaDto> motivaciones = motivacionVigenciaService.getMotivacionesConValorPorVigencia(idVigencia);
        if (motivaciones.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(motivaciones);
    }

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        return ResponseEntity.notFound().build();
    }

}
