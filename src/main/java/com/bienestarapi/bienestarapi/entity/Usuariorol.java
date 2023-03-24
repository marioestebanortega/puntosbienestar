package com.bienestarapi.bienestarapi.entity;
import javax.persistence.*;

@Entity
public class Usuariorol {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idusuariorol;
  private Integer idrol;
  private String identificacion;
  private String nombre;
  private String usucrea;
  private String fechacrea;
  private String usumodifica;
  private String fechamodifica;
  private String cargo;
  private String dependencia;

  public Usuariorol() {
  }



  public String getCargo() {
    return cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  public String getDependencia() {
    return dependencia;
  }

  public void setDependencia(String dependencia) {
    this.dependencia = dependencia;
  }

  public Integer getIdusuariorol() {
    return idusuariorol;
  }

  public void setIdusuariorol(Integer idusuariorol) {
    this.idusuariorol = idusuariorol;
  }

  public Integer getIdrol() {
    return idrol;
  }

  public void setIdrol(Integer idrol) {
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
