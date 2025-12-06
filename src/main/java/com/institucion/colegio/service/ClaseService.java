package com.institucion.colegio.service;

import com.institucion.colegio.dto.ClaseRequestDTO;
import com.institucion.colegio.dto.ClaseDTO;

import java.util.List;

public interface ClaseService {
    List<ClaseDTO> listarTodos();
    ClaseDTO obtenerPorId(Long id);
    ClaseDTO crear(ClaseRequestDTO dto);
    ClaseDTO editar(Long id, ClaseRequestDTO dto);
    void borrarPorId(Long id);
}
