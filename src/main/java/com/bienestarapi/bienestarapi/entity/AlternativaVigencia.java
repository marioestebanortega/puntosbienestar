package com.bienestarapi.bienestarapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "alternativa_vigencia")
public class AlternativaVigencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idalternativa", nullable = false)
    private Alternativa alternativa;

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

    public Alternativa getAlternativa() {
        return alternativa;
    }

    public void setAlternativa(Alternativa alternativa) {
        this.alternativa = alternativa;
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
