package com.institucion.colegio.controller;

import com.institucion.colegio.dto.RolDTO;
import com.institucion.colegio.dto.RolRequestDTO;
import com.institucion.colegio.service.RolService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RolController {
    private final RolService rolService;

    @GetMapping
    public ResponseEntity<List<RolDTO>> listarRoles(){
        return new ResponseEntity<>(rolService.listarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> obtenerRolPorId(@PathVariable Long id){
        return new ResponseEntity<>(rolService.obtenerPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RolDTO> crearRol(@Valid @RequestBody RolRequestDTO dto){
        return new ResponseEntity<>(rolService.crear(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolDTO> editarRol(@PathVariable Long id,
                                            @Valid @RequestBody RolRequestDTO dto){
        return new ResponseEntity<>(rolService.editar(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable Long id){
        rolService.borrarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
