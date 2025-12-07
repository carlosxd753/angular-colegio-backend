package com.institucion.colegio.service.serviceImpl;

import com.institucion.colegio.dto.ClaseDTO;
import com.institucion.colegio.dto.ClaseRequestDTO;
import com.institucion.colegio.exception.EntidadNoEncontradaException;
import com.institucion.colegio.model.Clase;
import com.institucion.colegio.repository.ClaseRepository;
import com.institucion.colegio.service.ClaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClaseServiceImpl implements ClaseService {
    private final ClaseRepository claseRepository;

    @Override
    public List<ClaseDTO> listarTodos() {
        return claseRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public ClaseDTO obtenerPorId(Long id) {
        Clase clase = claseRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("No exista la clase con id: " + id));

        return toDTO(clase);
    }

    @Override
    @Transactional
    public ClaseDTO crear(ClaseRequestDTO dto) {
        Clase clase = new Clase();
        clase.setPeriodo(dto.periodo());

        Clase claseCreada = claseRepository.save(clase);

        return toDTO(claseCreada);
    }

    @Override
    @Transactional
    public ClaseDTO editar(Long id,
                           ClaseRequestDTO dto) {
        Clase clase = claseRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("No exista la clase con id: " + id));


        clase.setPeriodo(dto.periodo());

        Clase claseActualizada = claseRepository.save(clase);

        return toDTO(claseActualizada);
    }

    @Override
    @Transactional
    public void borrarPorId(Long id) {
        claseRepository.deleteById(id);
    }

    private ClaseDTO toDTO(Clase clase){
        return new ClaseDTO(
                clase.getId(),
                clase.getPeriodo(),
                clase.getFechaCreacion()
        );
    }
}
