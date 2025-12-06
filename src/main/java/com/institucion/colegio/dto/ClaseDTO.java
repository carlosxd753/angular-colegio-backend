package com.institucion.colegio.dto;

import java.time.LocalDateTime;

public record ClaseDTO(
        Long id,
        String periodo,
        LocalDateTime fechaCreacion) {
}
