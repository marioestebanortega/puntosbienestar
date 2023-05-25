package com.bienestarapi.bienestarapi.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Puntosacumulados {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idpuntosacumulados;
  private String identificacion;
  private long idvigencia;
  private Double puntos;
  private Date fechacrea;
  private String usucrea;
  private Date fechamodifica;
  private String usumodifica;

  public Puntosacumulados() {
  }

  public Puntosacumulados(String identificacion, long idvigencia, long idmotivacion, String motivacion, double puntos, String fecharadica, Date fechacrea, String usucrea, Date fechamodifica, String usumodifica) {
    this.identificacion = identificacion;
    this.idvigencia = idvigencia;
    this.puntos = puntos;
    this.fechacrea = fechacrea;
    this.usucrea = usucrea;
    this.fechamodifica = fechamodifica;
    this.usumodifica = usumodifica;
  }

  public long getIdpuntosacumulados() {
    return idpuntosacumulados;
  }

  public void setIdpuntosacumulados(long idpuntosacumulados) {
    this.idpuntosacumulados = idpuntosacumulados;
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



  public Double getPuntos() {
    return puntos;
  }

  public void setPuntos(Double puntos) {
    this.puntos = puntos;
  }




  public Date getFechacrea() {
    return fechacrea;
  }

  public void setFechacrea(Date fechacrea) {
    this.fechacrea = fechacrea;
  }


  public String getUsucrea() {
    return usucrea;
  }

  public void setUsucrea(String usucrea) {
    this.usucrea = usucrea;
  }


  public Date getFechamodifica() {
    return fechamodifica;
  }

  public void setFechamodifica(Date fechamodifica) {
    this.fechamodifica = fechamodifica;
  }


  public String getUsumodifica() {
    return usumodifica;
  }

  public void setUsumodifica(String usumodifica) {
    this.usumodifica = usumodifica;
  }

}
