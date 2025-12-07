package com.institucion.colegio.service.serviceImpl;

import com.institucion.colegio.dto.CursoDTO;
import com.institucion.colegio.dto.CursoRequestDTO;
import com.institucion.colegio.model.Curso;
import com.institucion.colegio.repository.CursoRepository;
import com.institucion.colegio.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {
    private final CursoRepository cursoRepository;

    @Override
    public List<CursoDTO> listarTodos() {
        return cursoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public CursoDTO obtenerPorId(Long id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("No existe el curso con id: " + id));

        return toDTO(curso);
    }

    @Override
    @Transactional
    public CursoDTO crear(CursoRequestDTO dto) {
        Curso curso = new Curso();
        curso.setNombre(dto.nombre());

        Curso cursoCreado =  cursoRepository.save(curso);

        return toDTO(cursoCreado);
    }

    @Override
    @Transactional
    public CursoDTO editar(Long id,
                           CursoRequestDTO dto) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("No existe el curso con id: " + id));

        curso.setNombre(dto.nombre());

        Curso cursoActualizado  = cursoRepository.save(curso);

        return toDTO(cursoActualizado);
    }

    @Override
    @Transactional
    public void borrarPorId(Long id) {
        cursoRepository.deleteById(id);
    }

    private CursoDTO toDTO(Curso curso) {
        return new CursoDTO(
                curso.getId(),
                curso.getNombre(),
                curso.getFechaCreacion()
        );
    }
}
