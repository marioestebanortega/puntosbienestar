package com.bienestarapi.bienestarapi.dto;

public class RolDto {

  private long idrol;
  private String nombre;
  private String descripcion;
  private String usucrea;
  private String fechacrea;
  private String usumodifica;
  private String fechamodifica;

  public RolDto() {
  }

  public RolDto(String nombre, String descripcion, String usucrea, String fechacrea, String usumodifica, String fechamodifica) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.usucrea = usucrea;
    this.fechacrea = fechacrea;
    this.usumodifica = usumodifica;
    this.fechamodifica = fechamodifica;
  }

  public long getIdrol() {
    return idrol;
  }

  public void setIdrol(long idrol) {
    this.idrol = idrol;
  }


  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }


  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
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
