package com.bienestarapi.bienestarapi.entity;

import javax.persistence.*;

@Entity
public class Permisoacademico {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idpermisoacademico;
  private long idpermiso;
  private String institucion;
  private long idperiodicidad;
  private long dias;
  private long horas;
  private String fechaini;
  private String fechafin;
  private String horaini;
  private String horafin;
  private String usucrea;
  private String fechacrea;
  private String usumodifica;
  private String fechamodifica;

  public Permisoacademico() {
  }

  public Permisoacademico(long idpermiso, String institucion, long idperiodicidad, long dias, long horas, String fechaini, String fechafin, String horaini, String horafin, String usucrea, String fechacrea, String usumodifica, String fechamodifica) {
    this.idpermiso = idpermiso;
    this.institucion = institucion;
    this.idperiodicidad = idperiodicidad;
    this.dias = dias;
    this.horas = horas;
    this.fechaini = fechaini;
    this.fechafin = fechafin;
    this.horaini = horaini;
    this.horafin = horafin;
    this.usucrea = usucrea;
    this.fechacrea = fechacrea;
    this.usumodifica = usumodifica;
    this.fechamodifica = fechamodifica;
  }

  public long getIdpermisoacademico() {
    return idpermisoacademico;
  }

  public void setIdpermisoacademico(long idpermisoacademico) {
    this.idpermisoacademico = idpermisoacademico;
  }


  public long getIdpermiso() {
    return idpermiso;
  }

  public void setIdpermiso(long idpermiso) {
    this.idpermiso = idpermiso;
  }


  public String getInstitucion() {
    return institucion;
  }

  public void setInstitucion(String institucion) {
    this.institucion = institucion;
  }


  public long getIdperiodicidad() {
    return idperiodicidad;
  }

  public void setIdperiodicidad(long idperiodicidad) {
    this.idperiodicidad = idperiodicidad;
  }


  public long getDias() {
    return dias;
  }

  public void setDias(long dias) {
    this.dias = dias;
  }


  public long getHoras() {
    return horas;
  }

  public void setHoras(long horas) {
    this.horas = horas;
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

}
