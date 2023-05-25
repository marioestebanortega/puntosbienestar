package com.bienestarapi.bienestarapi.dto;

public class DatosPermisoPdf {

    private String nombre;
    private String dependencia;
    private String consecutivoPermiso;
    private String documento;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getConsecutivoPermiso() {
        return consecutivoPermiso;
    }

    public void setConsecutivoPermiso(String consecutivoPermiso) {
        this.consecutivoPermiso = consecutivoPermiso;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
