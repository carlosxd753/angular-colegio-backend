package com.institucion.colegio.service;

import java.util.List;

public interface UsuarioService {
    List<UsuarioDTO> listarTodos();
    UsuarioDTO obtenerPorId(Long id);
    UsuarioDTO crear(UsuarioCreateDTO dto);
    UsuarioDTO editar(Long id, RolUpdateDTO dto);
    void borrarPorId(Long id);
}
