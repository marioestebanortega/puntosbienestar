package com.bienestarapi.bienestarapi.dto;

public class Mensaje {

    private long id;
    private String mensaje;

    public Mensaje(String mensaje, long id) {

        this.id = id;
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}