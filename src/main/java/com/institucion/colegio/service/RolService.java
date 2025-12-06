package com.institucion.colegio.service;

import java.util.List;

public interface RolService {
    List<RolDTO> listarTodos();
    RolDTO obtenerPorId(Long id);
    RolDTO crear(RolCreateDTO dto);
    RolDTO editar(Long id, RolUpdateDTO dto);
    void borrarPorId(Long id);
}
