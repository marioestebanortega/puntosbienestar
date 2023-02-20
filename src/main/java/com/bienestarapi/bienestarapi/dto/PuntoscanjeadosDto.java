package com.bienestarapi.bienestarapi.dto;

public class PuntoscanjeadosDto {

  private long idpuntoscanjeados;
  private String identificacion;
  private long idvigencia;
  private String tipopermiso;
  private double puntos;
  private String fecharadica;
  private long idpermiso;
  private String fechacrea;
  private String usucrea;
  private String fechamodifica;
  private String usumodifica;

  public PuntoscanjeadosDto() {
  }

  public PuntoscanjeadosDto(String identificacion, long idvigencia, String tipopermiso, double puntos, String fecharadica, long idpermiso, String fechacrea, String usucrea, String fechamodifica, String usumodifica) {
    this.identificacion = identificacion;
    this.idvigencia = idvigencia;
    this.tipopermiso = tipopermiso;
    this.puntos = puntos;
    this.fecharadica = fecharadica;
    this.idpermiso = idpermiso;
    this.fechacrea = fechacrea;
    this.usucrea = usucrea;
    this.fechamodifica = fechamodifica;
    this.usumodifica = usumodifica;
  }

  public long getIdpuntoscanjeados() {
    return idpuntoscanjeados;
  }

  public void setIdpuntoscanjeados(long idpuntoscanjeados) {
    this.idpuntoscanjeados = idpuntoscanjeados;
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


  public String getTipopermiso() {
    return tipopermiso;
  }

  public void setTipopermiso(String tipopermiso) {
    this.tipopermiso = tipopermiso;
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


  public long getIdpermiso() {
    return idpermiso;
  }

  public void setIdpermiso(long idpermiso) {
    this.idpermiso = idpermiso;
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
