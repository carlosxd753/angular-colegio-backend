package com.institucion.colegio.repository;

import com.institucion.colegio.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
