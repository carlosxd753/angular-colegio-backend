package com.institucion.colegio.dto;

public record UsuarioDTO(
        Long id,
        String nombre,
        String apellidos,
        String dni,
        String correo,
        RolDTO rol,
        ClaseDTO clase) {
}
