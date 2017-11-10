package com.podliva.web.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.podliva.web.models.CodeInformationDto;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CodesContainerDto {
    private List<CodeInformationDto> codes;

    public List<CodeInformationDto> getCodes() {
        return codes;
    }

    public void setCodes(List<CodeInformationDto> codes) {
        this.codes = codes;
    }
}
