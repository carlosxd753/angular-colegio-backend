package com.institucion.colegio.service;

import com.institucion.colegio.dto.CursoDTO;
import com.institucion.colegio.dto.CursoRequestDTO;

import java.util.List;

public interface CursoService {
    List<CursoDTO> listarTodos();
    CursoDTO obtenerPorId(Long id);
    CursoDTO crear(CursoRequestDTO dto);
    CursoDTO editar(Long id, CursoRequestDTO dto);
    void borrarPorId(Long id);
}
