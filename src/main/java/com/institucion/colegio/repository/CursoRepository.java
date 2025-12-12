package com.institucion.colegio.repository;

import com.institucion.colegio.dto.CursoDTO;
import com.institucion.colegio.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
