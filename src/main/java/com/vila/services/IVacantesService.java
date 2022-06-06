package com.vila.services;

import java.util.List;

import com.vila.model.Alumno;
import com.vila.model.Profesor;

public interface IVacantesService {
    

    List<Alumno> buscarTodosAlumnos();
    List<Profesor> buscartodosProfesores();
    List<Alumno> buscarAlumno(String nomAlum);
    List<Profesor> buscarProfesor(String nomProfe);
    Alumno ObtenerAlumno(String nomAlum);
    Profesor ObtenerProfe(String nomProfe);
}
