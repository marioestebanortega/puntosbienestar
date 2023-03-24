package com.bienestarapi.bienestarapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "usuariorol_vigencia")
public class UsuarioRolVigencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuariorol_vigencia")
    private Integer id;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuariorol", referencedColumnName = "idusuariorol")
    private Usuariorol usuarioRol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vigencia", referencedColumnName = "idvigencia")
    private Vigencia vigencia;

    @Column(name = "puntos")
    private Double puntos;

    public Double getPuntos() {
        return puntos;
    }

    public void setPuntos(Double puntos) {
        this.puntos = puntos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuariorol getUsuarioRol() {
        return usuarioRol;
    }

    public void setUsuarioRol(Usuariorol usuarioRol) {
        this.usuarioRol = usuarioRol;
    }

    public Vigencia getVigencia() {
        return vigencia;
    }

    public void setVigencia(Vigencia vigencia) {
        this.vigencia = vigencia;
    }
}