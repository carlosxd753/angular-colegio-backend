package com.institucion.colegio.dto;

public record UsuarioUpdateDTO(
        String nombre,
        String apellidos,
        Long idClase
) {
}
