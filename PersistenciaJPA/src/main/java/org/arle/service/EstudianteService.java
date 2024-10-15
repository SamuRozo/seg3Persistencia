package org.arle.service;

import org.arle.entity.Estudiante;
import org.arle.repository.EstudianteRepository;

import java.util.List;

public class EstudianteService {

    private final EstudianteRepository repository;

    public EstudianteService() {
        this.repository = new EstudianteRepository();
    }

    public void crearEstudiante(Estudiante estudiante) {
        repository.crear(estudiante);
    }

    public Estudiante obtenerEstudiante(Long id) {
        return repository.leer(id);
    }

    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return repository.leerTodos();
    }

    public void actualizarEstudiante(Estudiante estudiante) {
        repository.actualizar(estudiante);
    }

    public void eliminarEstudiante(Long id) {
        repository.eliminar(id);
    }

    public void cerrar() {
        repository.cerrar();
    }
}
