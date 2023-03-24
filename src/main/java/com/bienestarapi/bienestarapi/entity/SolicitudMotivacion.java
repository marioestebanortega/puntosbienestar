package com.bienestarapi.bienestarapi.entity;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "solicitud_motivacion")
public class SolicitudMotivacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "documento")
    private String documento;

    @Column(name = "fecha_solicitud")
    private Date fechaSolicitud;

    @Column(name = "observaciones")
    private String observaciones;


    @ManyToOne
    @JoinColumn(name = "motivacion_vigencia_id", nullable = false)
    private MotivacionVigencia motivacionVigencia;

    @ManyToOne
    @JoinColumn(name = "vigencia_id", nullable = false)
    private Vigencia vigencia;

    @Column(name = "nombre_funcionario")
    private String nombreFuncionario;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "dependencia")
    private String dependencia;

    @Column(name = "valor")
    private Double valor;


    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public String getNombreFuncionario() {
        return nombreFuncionario;
    }

    public void setNombreFuncionario(String nombreFuncionario) {
        this.nombreFuncionario = nombreFuncionario;
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

    public MotivacionVigencia getMotivacionVigencia() {
        return motivacionVigencia;
    }

    public void setMotivacionVigencia(MotivacionVigencia motivacionVigencia) {
        this.motivacionVigencia = motivacionVigencia;
    }

    public Vigencia getVigencia() {
        return vigencia;
    }

    public void setVigencia(Vigencia vigencia) {
        this.vigencia = vigencia;
    }
}