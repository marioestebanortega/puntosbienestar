package com.bienestarapi.bienestarapi.dto;

import java.util.List;

public class AlternativaVigenciaRequest {

    private List<AlternativaVigenciaDto> motivations;

    public List<AlternativaVigenciaDto> getMotivations() {
        return motivations;
    }

    public void setMotivations(List<AlternativaVigenciaDto> motivations) {
        this.motivations = motivations;
    }
}
