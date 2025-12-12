package com.institucion.colegio.controller;

import com.institucion.colegio.dto.CursoDTO;
import com.institucion.colegio.dto.CursoRequestDTO;
import com.institucion.colegio.service.CursoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@RequiredArgsConstructor
public class CursoController {
    private final CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<CursoDTO>> listarCursos(){
        return new ResponseEntity<>(cursoService.listarTodos(), HttpStatus.OK);
    }

    @GetMapping("/me")
    public ResponseEntity<List<CursoDTO>> obtenerMisCursos(@AuthenticationPrincipal UserDetails user){
        return new ResponseEntity<>(cursoService.obtenerCursosDelUsuario(user.getUsername()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> obtenerCursoPorId(@PathVariable Long id){
        return new ResponseEntity<>(cursoService.obtenerPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CursoDTO> crearCurso(@Valid @RequestBody CursoRequestDTO dto){
        return new ResponseEntity<>(cursoService.crear(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> editarCurso(@PathVariable Long id,
                                                @Valid @RequestBody CursoRequestDTO dto){
        return new ResponseEntity<>(cursoService.editar(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id){
        cursoService.borrarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
