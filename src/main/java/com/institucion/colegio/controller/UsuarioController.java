package com.institucion.colegio.controller;

import com.institucion.colegio.dto.UsuarioCreateDTO;
import com.institucion.colegio.dto.UsuarioDTO;
import com.institucion.colegio.dto.UsuarioUpdateDTO;
import com.institucion.colegio.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios(@RequestParam(required = false) String rol){
        if (rol == null){
            return ResponseEntity.ok(usuarioService.listarTodos());
        }

        return ResponseEntity.ok(usuarioService.listarPorRol(rol));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable Long id){
        return new ResponseEntity<>(usuarioService.obtenerPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> crearUsuario(@Valid @RequestBody UsuarioCreateDTO dto){
        return new ResponseEntity<>(usuarioService.crear(dto),  HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> editarUsuario(@PathVariable Long id,
                                                    @Valid @RequestBody UsuarioUpdateDTO dto){
        return new ResponseEntity<>(usuarioService.editar(id,dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id){
        usuarioService.borrarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
