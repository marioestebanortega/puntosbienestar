package com.bienestarapi.bienestarapi.entity;
import javax.persistence.*;
import java.sql.Date;

@Entity
public class Vigencia {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idvigencia;
  private String vigencia;
  private String fechaini;
  private String fechafin;
  private String fechacrea;
  private String usucrea;
  private String fechamodifica;
  private String usumodifica;

  public Vigencia() {
  }

  public Vigencia(String vigencia, String fechaini, String fechafin, String fechacrea, String usucrea, String fechamodifica, String usumodifica) {
    this.vigencia = vigencia;
    this.fechaini = fechaini;
    this.fechafin = fechafin;
    this.fechacrea = fechacrea;
    this.usucrea = usucrea;
    this.fechamodifica = fechamodifica;
    this.usumodifica = usumodifica;
  }

  public long getIdvigencia() {
    return idvigencia;
  }

  public void setIdvigencia(long idvigencia) {
    this.idvigencia = idvigencia;
  }


  public String getVigencia() {
    return vigencia;
  }

  public void setVigencia(String vigencia) {
    this.vigencia = vigencia;
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
