package com.hbk.showservice.dto;

import java.util.List;

public class DTOUnwrapper<DTO> {
    private DTO content;
    private List<Error> errors;

    public DTOUnwrapper() {
    }

    public DTO getContent() {
        return content;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setContent(DTO content) {
        this.content = content;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
}
