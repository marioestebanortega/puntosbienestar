package com.bienestarapi.bienestarapi.service;

import com.bienestarapi.bienestarapi.dto.DatosPermisoPdf;
import com.bienestarapi.bienestarapi.dto.PermisoResponseDto;
import com.bienestarapi.bienestarapi.entity.*;
import com.bienestarapi.bienestarapi.repository.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.io.ByteArrayOutputStream;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class PermisoService {

    @Value("${url.servicio.web}")
    private String urlServicioWeb;

    @Autowired
    PermisoRepository PermisoRepository;

    @Autowired
    ConfiguracionesInicialesRepository configuracionesInicialesRepository;

    @Autowired
    PuntosacumuladosRepository puntosacumuladosRepository;

    @Autowired
    AlternativaVigenciaRepository alternativaVigenciaRepository;

    @Autowired
    UsuariorolVigenciaRepository usuariorolVigenciaRepository;

    @Autowired
    UsuariorolRepository usuariorolRepository;




    public List<Permiso> list(){

        return PermisoRepository.findAll();
    }

    public Optional<Permiso> getOne(Long idpermiso){

        return PermisoRepository.findByIdpermiso(idpermiso);
    }

    public Optional<Permiso> getByFecharadicacion(String fecharadicacion){

        return PermisoRepository.findByFecharadicacion(fecharadicacion);
    }

    public Optional<Permiso> getByIdentificacion(String identificacion){

        return PermisoRepository.findByIdentificacion(identificacion);
    }

    public Optional<Permiso> getByIdvigencia(Long idvigencia){

        return PermisoRepository.findByIdvigencia(idvigencia);
    }

    public long save(Permiso permiso){

        return PermisoRepository.save(permiso).getIdpermiso();
    }

    public List<PermisoResponseDto> permisosPorVigenciaYUsuario(Integer idvigencia, String idUser,String rol) {
        List<Permiso> permisos=null;
        if(!rol.equals("user")){
            permisos=PermisoRepository.findAll();
        }
        else{
            permisos=PermisoRepository.permisosPorVigenciaYUsuario(idvigencia,idUser);
        }
       List<PermisoResponseDto> out= permisos.stream().map(permiso->{
         PermisoResponseDto permisoResponseDto = new PermisoResponseDto();
         permisoResponseDto.setIdPermiso(permiso.getIdpermiso());
         permisoResponseDto.setDocumento(permiso.getIdentificacion());
         Usuariorol usuariorol= usuariorolRepository.findByIdentificacion(permiso.getIdentificacion()).get();
         permisoResponseDto.setNombrePersona(usuariorol.getNombre());
         permisoResponseDto.setCargo(usuariorol.getCargo());
         permisoResponseDto.setDependencia(usuariorol.getDependencia());
         permisoResponseDto.setPermisoDesc(alternativaVigenciaRepository.findById(permiso.getIdtipopermiso()).get().getAlternativa().getNombre());
         permisoResponseDto.setPuntos(usuariorolVigenciaRepository.obtenerPuntosPorUsuarioYVigencia(idvigencia,usuariorol.getIdusuariorol()));

         if(permiso.getIdestadopermiso()==1L){
               permisoResponseDto.setEstado("EN TRAMITE");
         }
         else if(permiso.getIdestadopermiso()==2L){
             permisoResponseDto.setEstado("VALIDADO_JEFE");
         }
         else if(permiso.getIdestadopermiso()==3L){
             permisoResponseDto.setEstado("VALIDADO_RRHH");
         }
         else if(permiso.getIdestadopermiso()==6L){
             permisoResponseDto.setEstado("RECHAZADO_JEFE");
         }
         else if(permiso.getIdestadopermiso()==7L){
             permisoResponseDto.setEstado("RECHAZADO_RRHH");
         }
         permisoResponseDto.setIdEstado(permiso.getIdestadopermiso());
         return  permisoResponseDto;
        }).collect(Collectors.toList());
       return out;
    }

    public Double puntosIniciales(Integer idVigencia){
     Optional<ConfiguracionesVigencia> conf= configuracionesInicialesRepository.findByCodigoAndIdVigencia("PINI",idVigencia);
     return conf.get().getPuntosIniciales();
    };

    public Permiso actualizarEstado(Integer id, Integer estado) throws Exception {
        Permiso per= PermisoRepository.findById(id).get();
        per.setIdestadopermiso(estado);
        Permiso permiso= PermisoRepository.save(per);
        if(estado.equals(2)) {
            Optional<Puntosacumulados> pac = puntosacumuladosRepository.findByIdentificacionAndIdvigencia(per.getIdentificacion(), Long.valueOf(per.getIdvigencia()));
            if (!pac.isPresent()) {
                Puntosacumulados pacu = new Puntosacumulados();
                pacu.setPuntos(puntosIniciales(per.getIdvigencia()));
                pacu.setFechacrea(new Date());
                pacu.setFechamodifica(new Date());
                pacu.setUsumodifica("admin");
                pacu.setIdentificacion(per.getIdentificacion());
                pacu.setUsucrea("admin");
                pacu.setIdvigencia(Long.valueOf(per.getIdvigencia()));
                puntosacumuladosRepository.save(pacu);
                pac = Optional.of(pacu);

            }
            AlternativaVigencia alternativaVigencia = alternativaVigenciaRepository.findById(per.getIdtipopermiso()).get();
            if (pac.get().getPuntos() - alternativaVigencia.getValor() < 0) {
                throw new Exception("No se puede efectuar la aprobacion por falta de puntos acumulados necesarios");
            }
            pac.get().setPuntos((pac.get().getPuntos() == null ? puntosIniciales(per.getIdvigencia()) : pac.get().getPuntos()) - alternativaVigencia.getValor());
            puntosacumuladosRepository.save(pac.get());
        }
        //TODO: llamar al servicio para radicar
      //  enviarSolicitud(per);
        return permiso;

    }

    public  ResponseEntity<String>  enviarSolicitud(Permiso per){

        // Crear el objeto RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Crear los headers de la solicitud HTTP
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Crear el cuerpo de la solicitud
        MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("idEntidad", "125");//no se donde sacarlo
        requestBody.add("idPersona", per.getIdentificacion()); //supongo el numero de documento de la persona
        requestBody.add("fechaInicio", "2022-05-07T00:00:00"); //supongo la fecha de inicio del permiso
        requestBody.add("fechaFin", "2022-05-12T00:00:00"); //supongo la fecha fin del permiso
        requestBody.add("cantidadHoras", 16); //supongo la cantidad horas del permiso
        requestBody.add("idTipoNovedad", 22); //No se donde sacarlo
        requestBody.add("idTipoActoAdministrativo", 14); //No se donde sacarlo
        requestBody.add("nombreActoAdministrativo", "archivoPermiso.pdf"); //supongo que puedo colocar cualquier nombre de archivo
        requestBody.add("fechaExpedicionActoAdministrativo", "2022-05-07T00:00:00"); //No se donde sacarlo
        requestBody.add("numeroActoAdministrativo", 123); //no se donde sacarlo
        requestBody.add("fechaInicioActoAdministrativo", "2022-05-07T00:00:00"); //No se donde sacarlo
        requestBody.add("descripcionActoAdministrativo", "Descripcion acto administrativo"); //No se donde sacarlo

// Causales
        List<Map<String, Object>> causales = new ArrayList<>();
        Map<String, Object> causal1 = new HashMap<>();
        causal1.put("id", 48); //No se donde sacarlo
        causal1.put("nombre", "Asunto Personal"); //Supongo que este puede ser cualquier nombre
        Map<String, Object> causal2 = new HashMap<>();
        causal2.put("id", 32); //No se a que se refiere con otra causal
        causal2.put("nombre", "Permiso por calamidad");
        causales.add(causal1);
        causales.add(causal2);
        requestBody.add("causales", causales);

// Dias semana
        List<Map<String, Object>> diasSemana = new ArrayList<>(); //no entiendo lo de los dias de la semana
        Map<String, Object> diaSemana1 = new HashMap<>();
        diaSemana1.put("id", 2);
        diaSemana1.put("nombre", "Martes");
        Map<String, Object> diaSemana2 = new HashMap<>();
        diaSemana2.put("id", 4);
        diaSemana2.put("nombre", "Jueves");
        diasSemana.add(diaSemana1);
        diasSemana.add(diaSemana2);
        requestBody.add("diasSemana", diasSemana);
        DatosPermisoPdf datosPdf=new DatosPermisoPdf();
        datosPdf.setConsecutivoPermiso(String.valueOf(per.getIdpermiso()));
        datosPdf.setDependencia("");
        datosPdf.setNombre("");
        datosPdf.setDocumento(per.getIdentificacion());

        requestBody.add("contenidoActoAdministrativo", generatePDF(datosPdf));

        // Crear la entidad HttpEntity con los headers y el cuerpo
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        // Realizar la llamada POST al servicio web
        String url = urlServicioWeb;
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        return response;

        // Obtener la respuesta del servicio web
        /*if (response.getStatusCode().is2xxSuccessful()) {
            String respuesta = response.getBody();
            // Manejar la respuesta según sea necesario
            System.out.println("Respuesta del servicio: " + respuesta);
        } else {
            System.out.println("Error en la llamada al servicio web");
        }*/
    }

    public static String generatePDF(DatosPermisoPdf permisoPdf) {
        Document document = new Document();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, outputStream);
            document.open();
            document.add(new Paragraph("Numero permiso: " + permisoPdf.getNombre()));
            document.add(new Paragraph("Nombre: " +permisoPdf.getNombre()));
            document.add(new Paragraph("Dependencia: " + permisoPdf.getDependencia()));
            document.add(new Paragraph("Documento: " + permisoPdf.getDocumento()));
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        byte[] pdfBytes = outputStream.toByteArray();
        byte[] base64Bytes = org.apache.commons.codec.binary.Base64.encodeBase64(pdfBytes);
        String base64String = new String(base64Bytes);
        return base64String;
    }
}
