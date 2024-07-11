package com.voll.api.infra.errors;

public class ValidationDeIntegridad extends RuntimeException{
    public ValidationDeIntegridad(String s) {
        super(s);
    }
}
