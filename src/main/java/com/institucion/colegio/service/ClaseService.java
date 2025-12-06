package com.institucion.colegio.service;

import java.util.List;

public interface ClaseService {
    List<ClaseDTO> listarTodos();
    ClaseDTO obtenerPorId(Long id);
    ClaseDTO crear(ClaseCreateDTO dto);
    ClaseDTO editar(Long id, ClaseUpdateDTO dto);
    void borrarPorId(Long id);
}
