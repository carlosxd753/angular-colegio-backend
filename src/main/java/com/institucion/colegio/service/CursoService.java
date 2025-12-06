package com.institucion.colegio.service;

import java.util.List;

public interface CursoService {
    List<CursoDTO> listarTodos();
    CursoDTO obtenerPorId(Long id);
    CursoDTO crear(CursoCreateDTO dto);
    CursoDTO editar(Long id, CursoUpdateDTO dto);
    void borrarPorId(Long id);
}
