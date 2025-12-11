package com.institucion.colegio.repository;

import com.institucion.colegio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreo(String correo);
    List<Usuario> findByRol_Nombre(String nombre);
}
