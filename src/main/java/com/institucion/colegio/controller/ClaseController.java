package com.institucion.colegio.controller;

import com.institucion.colegio.dto.ClaseDTO;
import com.institucion.colegio.dto.ClaseRequestDTO;
import com.institucion.colegio.service.ClaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clases")
@RequiredArgsConstructor
public class ClaseController {
    private final ClaseService claseService;

    @GetMapping
    public ResponseEntity<List<ClaseDTO>> listarClases() {
        return new ResponseEntity<>(claseService.listarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClaseDTO> obtenerClase(@PathVariable Long id) {
        return new ResponseEntity<>(claseService.obtenerPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClaseDTO> crearClase(@Valid @RequestBody ClaseRequestDTO dto){
        return new ResponseEntity<>(claseService.crear(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClaseDTO> editarClase(@PathVariable Long id,
                                                @Valid @RequestBody ClaseRequestDTO dto){
        return new  ResponseEntity<>(claseService.editar(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarClase(@PathVariable Long id){
        claseService.borrarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
