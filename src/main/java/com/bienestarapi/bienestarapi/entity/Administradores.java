package com.bienestarapi.bienestarapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "administradores", schema = "bienestar")
public class Administradores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "documento")
    private String documento;

// Constructor, getters y setters

    public Administradores() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }


}
