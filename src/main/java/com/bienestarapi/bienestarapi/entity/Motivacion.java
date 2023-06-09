package com.bienestarapi.bienestarapi.entity;

import javax.persistence.*;

@Entity
public class Motivacion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idmotivacion;
    private String nombre;
  private String descripcion;
  private String fechacrea;
  private String usucrea;
  private String fechamodifica;
  private String usumodifica;

  public Motivacion() {
  }

  public Motivacion(String nombre, String descripcion, double puntos, String fechacrea, String usucrea, String fechamodifica, String usumodifica) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.fechacrea = fechacrea;
    this.usucrea = usucrea;
    this.fechamodifica = fechamodifica;
    this.usumodifica = usumodifica;
  }

  public Integer getIdmotivacion() {
    return idmotivacion;
  }

  public void setIdmotivacion(Integer idmotivacion) {
    this.idmotivacion = idmotivacion;
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
