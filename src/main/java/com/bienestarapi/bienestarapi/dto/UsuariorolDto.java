package com.bienestarapi.bienestarapi.dto;

public class UsuariorolDto {

  private long idusuariorol;
  private long idrol;
  private String identificacion;
  private String nombre;
  private String usucrea;
  private String fechacrea;
  private String usumodifica;
  private String fechamodifica;

  public UsuariorolDto() {
  }

  public UsuariorolDto(long idrol, String identificacion, String nombre, String usucrea, String fechacrea, String usumodifica, String fechamodifica) {
    this.idrol = idrol;
    this.identificacion = identificacion;
    this.nombre = nombre;
    this.usucrea = usucrea;
    this.fechacrea = fechacrea;
    this.usumodifica = usumodifica;
    this.fechamodifica = fechamodifica;
  }

  public long getIdusuariorol() {
    return idusuariorol;
  }

  public void setIdusuariorol(long idusuariorol) {
    this.idusuariorol = idusuariorol;
  }


  public long getIdrol() {
    return idrol;
  }

  public void setIdrol(long idrol) {
    this.idrol = idrol;
  }


  public String getIdentificacion() {
    return identificacion;
  }

  public void setIdentificacion(String identificacion) {
    this.identificacion = identificacion;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
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
