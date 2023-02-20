package com.bienestarapi.bienestarapi.entity;

import javax.persistence.*;

@Entity
public class Permiso {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idpermiso;
  private String identificacion;
  private long idvigencia;
  private long idtipopermiso;
  private String fecharadicacion;
  private String fechaini;
  private String fechafin;
  private String horaini;
  private String horafin;
  private String observacion;
  private String acedemico;
  private String jefe;
  private String director;
  private String usucrea;
  private String fechacrea;
  private String usumodifica;
  private String fechamodifica;

  private long idestadopermiso;

  public Permiso() {
  }

  public Permiso(String identificacion, long idvigencia, long idtipopermiso, String fecharadicacion, String fechaini, String fechafin, String horaini, String horafin, String observacion, String acedemico, String jefe, String director, String usucrea, String fechacrea, String usumodifica, String fechamodifica, long idestadopermiso) {
    this.identificacion = identificacion;
    this.idvigencia = idvigencia;
    this.idtipopermiso = idtipopermiso;
    this.fecharadicacion = fecharadicacion;
    this.fechaini = fechaini;
    this.fechafin = fechafin;
    this.horaini = horaini;
    this.horafin = horafin;
    this.observacion = observacion;
    this.acedemico = acedemico;
    this.jefe = jefe;
    this.director = director;
    this.usucrea = usucrea;
    this.fechacrea = fechacrea;
    this.usumodifica = usumodifica;
    this.fechamodifica = fechamodifica;
    this.idestadopermiso = idestadopermiso;
  }

  public long getIdpermiso() {
    return idpermiso;
  }

  public void setIdpermiso(long idpermiso) {
    this.idpermiso = idpermiso;
  }


  public String getIdentificacion() {
    return identificacion;
  }

  public void setIdentificacion(String identificacion) {
    this.identificacion = identificacion;
  }


  public long getIdvigencia() {
    return idvigencia;
  }

  public void setIdvigencia(long idvigencia) {
    this.idvigencia = idvigencia;
  }


  public long getIdtipopermiso() {
    return idtipopermiso;
  }

  public void setIdtipopermiso(long idtipopermiso) {
    this.idtipopermiso = idtipopermiso;
  }


  public String getFecharadicacion() {
    return fecharadicacion;
  }

  public void setFecharadicacion(String fecharadicacion) {
    this.fecharadicacion = fecharadicacion;
  }


  public String getFechaini() {
    return fechaini;
  }

  public void setFechaini(String fechaini) {
    this.fechaini = fechaini;
  }


  public String getFechafin() {
    return fechafin;
  }

  public void setFechafin(String fechafin) {
    this.fechafin = fechafin;
  }


  public String getHoraini() {
    return horaini;
  }

  public void setHoraini(String horaini) {
    this.horaini = horaini;
  }


  public String getHorafin() {
    return horafin;
  }

  public void setHorafin(String horafin) {
    this.horafin = horafin;
  }


  public String getObservacion() {
    return observacion;
  }

  public void setObservacion(String observacion) {
    this.observacion = observacion;
  }


  public String getAcedemico() {
    return acedemico;
  }

  public void setAcedemico(String acedemico) {
    this.acedemico = acedemico;
  }


  public String getJefe() {
    return jefe;
  }

  public void setJefe(String jefe) {
    this.jefe = jefe;
  }


  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }


  public String getUsucrea() {
    return usucrea;
  }

  public void setUsucrea(String usucrea) {
    this.usucrea = usucrea;
  }


  public String getFechacrea() {
    return fechacrea;
  }

  public void setFechacrea(String fechacrea) {
    this.fechacrea = fechacrea;
  }


  public String getUsumodifica() {
    return usumodifica;
  }

  public void setUsumodifica(String usumodifica) {
    this.usumodifica = usumodifica;
  }


  public String getFechamodifica() {
    return fechamodifica;
  }

  public void setFechamodifica(String fechamodifica) {
    this.fechamodifica = fechamodifica;
  }

  public Long getIdestadopermiso() {
    return idestadopermiso;
  }

  public void setIdestadopermiso(long idestadopermiso) {
    this.idestadopermiso = idestadopermiso;
  }
}
