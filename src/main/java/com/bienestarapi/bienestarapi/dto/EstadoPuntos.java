package com.bienestarapi.bienestarapi.dto;

public enum EstadoPuntos {
    EN_PROCESO(1),
    APROBADO_JEFE(2),
    RECHAZADO_JEFE(3),
    APROBADO_RRHH(4),
    RECHAZADO_JRHH(5);

    private final int valor;

    EstadoPuntos(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static EstadoPuntos fromValor(int valor) {
        for (EstadoPuntos estado : EstadoPuntos.values()) {
            if (estado.valor == valor) {
                return estado;
            }
        }
        throw new IllegalArgumentException("Valor no válido: " + valor);
    }
}
