package com.vila.services;

import java.util.List;

import com.vila.model.Alumno;
import com.vila.model.Profesor;

public interface IVacantesService {
    

    List<Alumno> buscarTodosAlumnos();
    List<Profesor> buscartodosProfesores();
}