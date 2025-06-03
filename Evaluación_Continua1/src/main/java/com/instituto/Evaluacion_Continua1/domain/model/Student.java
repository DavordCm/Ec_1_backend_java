package com.instituto.Evaluacion_Continua1.domain.model;

import lombok.Builder;

@Builder(toBuilder = true)
public record Student(
        String uid,
        String documentNumber,
        String name,
        String lastName,
        String phone,
        String email,
        String photo,
        int active
) {
}
