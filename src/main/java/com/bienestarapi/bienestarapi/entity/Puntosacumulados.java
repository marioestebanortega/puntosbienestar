package com.bienestarapi.bienestarapi.entity;

import javax.persistence.*;

@Entity
public class Puntosacumulados {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idpuntosacumulados;
  private String identificacion;
  private long idvigencia;
  private long idmotivacion;
  private String motivacion;
  private double puntos;
  private String fecharadica;
  private String fechacrea;
  private String usucrea;
  private String fechamodifica;
  private String usumodifica;

  public Puntosacumulados() {
  }

  public Puntosacumulados(String identificacion, long idvigencia, long idmotivacion, String motivacion, double puntos, String fecharadica, String fechacrea, String usucrea, String fechamodifica, String usumodifica) {
    this.identificacion = identificacion;
    this.idvigencia = idvigencia;
    this.idmotivacion = idmotivacion;
    this.motivacion = motivacion;
    this.puntos = puntos;
    this.fecharadica = fecharadica;
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


  public long getIdmotivacion() {
    return idmotivacion;
  }

  public void setIdmotivacion(long idmotivacion) {
    this.idmotivacion = idmotivacion;
  }


  public String getMotivacion() {
    return motivacion;
  }

  public void setMotivacion(String motivacion) {
    this.motivacion = motivacion;
  }


  public double getPuntos() {
    return puntos;
  }

  public void setPuntos(double puntos) {
    this.puntos = puntos;
  }


  public String getFecharadica() {
    return fecharadica;
  }

  public void setFecharadica(String fecharadica) {
    this.fecharadica = fecharadica;
  }


  public String getFechacrea() {
    return fechacrea;
  }

  public void setFechacrea(String fechacrea) {
    this.fechacrea = fechacrea;
  }


  public String getUsucrea() {
    return usucrea;
  }

  public void setUsucrea(String usucrea) {
    this.usucrea = usucrea;
  }


  public String getFechamodifica() {
    return fechamodifica;
  }

  public void setFechamodifica(String fechamodifica) {
    this.fechamodifica = fechamodifica;
  }


  public String getUsumodifica() {
    return usumodifica;
  }

  public void setUsumodifica(String usumodifica) {
    this.usumodifica = usumodifica;
  }

}
