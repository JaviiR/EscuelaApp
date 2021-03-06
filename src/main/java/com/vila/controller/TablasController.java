package com.vila.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vila.Clases.Separador;
import com.vila.services.IVacantesService;

@Controller
public class TablasController {

	@Autowired
	private IVacantesService servicioV;
	Separador s = new Separador();

	@GetMapping("Lista/alumnos") // METODO QUE LISTA TODOS LOS ALUMNOS DE LA BASE DE DATOS XD
	public String MostrarAlumnos(Model model) {
		model.addAttribute("alumnos", servicioV.buscarTodosAlumnos());
		
		return "tables/alumnos";
	}

	@GetMapping("Lista/profesores") // METODO QUE LISTA TODOS LOS PROFESORES DE LA BASE DE DATOS XD
	public String MostrarProfesores(Model model) {
		model.addAttribute("profes", servicioV.buscartodosProfesores());
		return "tables/listaProfesores";
	}

	@GetMapping("Lista/alumnos/filtro") // METODO QUE LISTA UN ALUMNO EN ESPECIFICADO SEGUN EL NOMBRE
	public String FiltrarAlumno(Model model, @RequestParam String nombre) {
		model.addAttribute("alumnos", servicioV.buscarAlumno(nombre));
		if (servicioV.buscarAlumno(nombre).size() > 0) {
			return "tables/alumnos";
		} else {
			model.addAttribute("Todos", "/Lista/alumnos");
			model.addAttribute("titulo", "NOMBRE DEL ALUMNO");
			return "filter";
		}
	}

	@GetMapping("Lista/profesores/filtro") // METODO QUE LISTA UN PROFESOR EN ESPECIFICO SEGUN EL NOMBRE
	public String FiltrarProfesor(Model model, @RequestParam String nombre) {
		model.addAttribute("profes", servicioV.buscarProfesor(nombre));
		if (servicioV.buscarProfesor(nombre).size() > 0) {
			return "tables/listaProfesores";
		} else {
			model.addAttribute("Todos", "/Lista/profesores");
			model.addAttribute("titulo", "NOMBRE DEL PROFESOR");
			return "filter";
		}
	}

}
