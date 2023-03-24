package com.bienestarapi.bienestarapi.controller;

import com.bienestarapi.bienestarapi.dto.AlternativaDto;
import com.bienestarapi.bienestarapi.dto.AlternativaVigenciaDto;
import com.bienestarapi.bienestarapi.entity.Alternativa;
import com.bienestarapi.bienestarapi.service.AlternativaService;
import com.bienestarapi.bienestarapi.service.AlternativaVigenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/alternativa")
//@CrossOrigin(origins = {"http://localhost:8080", "http://localhost", "http://localhost:4200", "https://soporte.serviciocivil.gov.co", "http://20.172.240.181"})
@CrossOrigin(origins = "*")
public class AlternativaController {

    @Autowired
    AlternativaService alternativaService;

    @Autowired
    private AlternativaVigenciaService alternativaVigenciaService;



    @PostMapping("/guardarConfiguracionesAlternativasPorVigencia")
    public ResponseEntity<List<AlternativaVigenciaDto>> guardarConfiguracionesAlternativaesPorVigencia(@RequestBody Map<String,List<AlternativaVigenciaDto>> in) {
        try {
            List<AlternativaVigenciaDto> conf= (List<AlternativaVigenciaDto>)in.get("alternativas");
            List<AlternativaVigenciaDto> smDto= alternativaVigenciaService.guardarConfiguracionesAlternativaesPorVigencia(conf);
            return new ResponseEntity(smDto, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity("Ha ocurrido un problema.", HttpStatus.NOT_MODIFIED);
        }

    }

    @GetMapping("/alternativasConValor/{idVigencia}")
    public ResponseEntity<List<AlternativaVigenciaDto>> getAlternativaesConValorPorVigencia(@PathVariable Integer idVigencia) {
        List<AlternativaVigenciaDto> alternativas = alternativaVigenciaService.getAlternativaesConValorPorVigencia(idVigencia);
        if (alternativas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(alternativas);
    }

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        return ResponseEntity.notFound().build();
    }

}
