package com.institucion.colegio.repository;

import com.institucion.colegio.model.CursoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoUsuarioRepository extends JpaRepository<CursoUsuario, Long> {
    List<CursoUsuario> findByUsuario_Id(Long idUsuario);
}
