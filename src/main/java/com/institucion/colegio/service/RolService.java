package com.institucion.colegio.service;

import com.institucion.colegio.dto.RolDTO;
import com.institucion.colegio.dto.RolRequestDTO;

import java.util.List;

public interface RolService {
    List<RolDTO> listarTodos();
    RolDTO obtenerPorId(Long id);
    RolDTO crear(RolRequestDTO dto);
    RolDTO editar(Long id, RolRequestDTO dto);
    void borrarPorId(Long id);
}
