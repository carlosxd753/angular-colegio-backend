package com.institucion.colegio.dto;

public record UsuarioCreateDTO(
        String nombre,
        String apellidos,
        String dni,
        String correo,
        String password,
        Long idRol,
        Long idClase
) {
}
