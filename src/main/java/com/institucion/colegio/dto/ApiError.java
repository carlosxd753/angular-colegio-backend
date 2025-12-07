package com.institucion.colegio.dto;

public record ApiError(
        int responseCode,
        String responseMessage
) {
}
