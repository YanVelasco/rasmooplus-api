package com.yanvelasco.rasmooplus.exceptions;

import lombok.Getter;

import java.util.UUID;


@Getter
public class ResourceNotFoundException extends RuntimeException {
    private String resourcename;
    private String fieldname;
    private String field;
    private Long fieldId;

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String resourcename, String fieldname, String field) {
        super(String.format("%s not found with %s : %s", resourcename, fieldname, field));
        this.resourcename = resourcename;
        this.field = field;
        this.fieldname = fieldname;
    }

    public ResourceNotFoundException(String resourcename, String field, Long fieldId) {
        super(String.format("%s not found with %s : %s", resourcename, field, fieldId));
        this.resourcename = resourcename;
        this.field = field;
        this.fieldId = fieldId;
    }
}