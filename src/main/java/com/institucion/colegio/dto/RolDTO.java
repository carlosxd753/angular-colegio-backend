package com.institucion.colegio.dto;

import java.time.LocalDateTime;

public record RolDTO(
        Long id,
        String nombre,
        LocalDateTime fechaCreacion) {
}
