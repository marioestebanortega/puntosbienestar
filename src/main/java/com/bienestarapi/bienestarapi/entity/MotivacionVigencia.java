package com.bienestarapi.bienestarapi.entity;

import javax.persistence.*;
@Entity
@Table(name = "motivacion_vigencia")
public class MotivacionVigencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idmotivacion", nullable = false)
    private Motivacion motivacion;

    @ManyToOne
    @JoinColumn(name = "idvigencia", nullable = false)
    private Vigencia vigencia;


    @Column(name = "valor")
    private Double valor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Motivacion getMotivacion() {
        return motivacion;
    }

    public void setMotivacion(Motivacion motivacion) {
        this.motivacion = motivacion;
    }

    public Vigencia getVigencia() {
        return vigencia;
    }

    public void setVigencia(Vigencia vigencia) {
        this.vigencia = vigencia;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
