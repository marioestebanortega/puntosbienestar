package com.bienestarapi.bienestarapi.dto;

import java.util.List;

public class MotivacionVigenciaRequest {

    private List<MotivacionVigenciaDto> motivations;

    public List<MotivacionVigenciaDto> getMotivations() {
        return motivations;
    }

    public void setMotivations(List<MotivacionVigenciaDto> motivations) {
        this.motivations = motivations;
    }
}
