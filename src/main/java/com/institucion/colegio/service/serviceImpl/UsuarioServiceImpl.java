package com.institucion.colegio.service.serviceImpl;

import com.institucion.colegio.dto.*;
import com.institucion.colegio.exception.EntidadNoEncontradaException;
import com.institucion.colegio.model.Clase;
import com.institucion.colegio.model.Rol;
import com.institucion.colegio.model.Usuario;
import com.institucion.colegio.repository.ClaseRepository;
import com.institucion.colegio.repository.RolRepository;
import com.institucion.colegio.repository.UsuarioRepository;
import com.institucion.colegio.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ClaseRepository claseRepository;
    private final RolRepository rolRepository;

    @Override
    public List<UsuarioDTO> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public UsuarioDTO obtenerPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("No existe el usuario con id: " + id));

        return toDTO(usuario);
    }

    @Override
    @Transactional
    public UsuarioDTO crear(UsuarioCreateDTO dto) {
        Clase clase = claseRepository.findById(dto.idClase())
                .orElseThrow(() -> new EntidadNoEncontradaException("No exista la clase con id: " + dto.idClase()));

        Rol rol = rolRepository.findById(dto.idRol())
                .orElseThrow(() -> new EntidadNoEncontradaException("No existe el rol con id: " + dto.idRol()));

        Usuario usuario = new Usuario();
        usuario.setNombre(dto.nombre());
        usuario.setApellidos(dto.apellidos());
        usuario.setDni(dto.dni());
        usuario.setCorreo(dto.correo());
        usuario.setPassword(dto.password());
        usuario.setRol(rol);
        usuario.setClase(clase);

        Usuario usuarioCreado = usuarioRepository.save(usuario);

        return toDTO(usuarioCreado);
    }

    @Override
    @Transactional
    public UsuarioDTO editar(Long id, UsuarioUpdateDTO dto) {
        Clase clase = claseRepository.findById(dto.idClase())
                .orElseThrow(() -> new EntidadNoEncontradaException("No exista la clase con id: " + dto.idClase()));

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("No existe el usuario con id: " + id));

        usuario.setNombre(dto.nombre());
        usuario.setApellidos(dto.apellidos());
        usuario.setClase(clase);

        Usuario usuarioEditado = usuarioRepository.save(usuario);

        return toDTO(usuarioEditado);
    }

    @Override
    @Transactional
    public void borrarPorId(Long id) {
        usuarioRepository.deleteById(id);
    }

    private UsuarioDTO toDTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellidos(),
                usuario.getDni(),
                usuario.getCorreo(),
                new RolDTO(
                        usuario.getRol().getId(),
                        usuario.getRol().getNombre(),
                        usuario.getRol().getFechaCreacion()
                ),
                new ClaseDTO(
                        usuario.getClase().getId(),
                        usuario.getClase().getPeriodo(),
                        usuario.getClase().getFechaCreacion()
                )
        );
    }
}
