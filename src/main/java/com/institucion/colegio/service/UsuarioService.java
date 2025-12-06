package com.institucion.colegio.service;

import com.institucion.colegio.dto.UsuarioCreateDTO;
import com.institucion.colegio.dto.UsuarioDTO;
import com.institucion.colegio.dto.UsuarioUpdateDTO;

import java.util.List;

public interface UsuarioService {
    List<UsuarioDTO> listarTodos();
    UsuarioDTO obtenerPorId(Long id);
    UsuarioDTO crear(UsuarioCreateDTO dto);
    UsuarioDTO editar(Long id, UsuarioUpdateDTO dto);
    void borrarPorId(Long id);
}
