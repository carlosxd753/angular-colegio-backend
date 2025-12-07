package com.institucion.colegio.service.serviceImpl;

import com.institucion.colegio.dto.RolDTO;
import com.institucion.colegio.dto.RolRequestDTO;
import com.institucion.colegio.exception.EntidadNoEncontradaException;
import com.institucion.colegio.model.Rol;
import com.institucion.colegio.repository.RolRepository;
import com.institucion.colegio.service.RolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolServiceImpl implements RolService {
    private final RolRepository rolRepository;


    @Override
    public List<RolDTO> listarTodos() {
        return rolRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public RolDTO obtenerPorId(Long id) {
        Rol rol = rolRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("No existe el rol con id: " + id));

        return toDTO(rol);
    }

    @Override
    @Transactional
    public RolDTO crear(RolRequestDTO dto) {
        Rol rol = new Rol();
        rol.setNombre(dto.nombre());

        Rol rolCreado = rolRepository.save(rol);

        return toDTO(rolCreado);
    }

    @Override
    @Transactional
    public RolDTO editar(Long id, RolRequestDTO dto) {
        Rol rol = rolRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("No existe el rol con id: " + id));
        rol.setNombre(dto.nombre());

        Rol rolEditado = rolRepository.save(rol);

        return toDTO(rolEditado);
    }

    @Override
    @Transactional
    public void borrarPorId(Long id) {
        rolRepository.deleteById(id);
    }

    private RolDTO toDTO(Rol rol) {
        return new RolDTO(
                rol.getId(),
                rol.getNombre(),
                rol.getFechaCreacion()
        );
    }
}
