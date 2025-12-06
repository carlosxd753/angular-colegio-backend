package com.institucion.colegio.dto;

import java.time.LocalDateTime;

public record CursoDTO(
        Long id,
        String nombre,
        LocalDateTime fechaCreacion) {
}
