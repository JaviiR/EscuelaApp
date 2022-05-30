package com.vila.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.vila.Clases.Separador;
import com.vila.model.*;
import com.vila.services.IVacantesService;

@Controller
public class TablasController {

	@Autowired
	private IVacantesService servicio;

Separador s=new Separador();
	

	@GetMapping("Lista/alumnos")//METODO QUE LISTA TODOS LOS ALUMNOS DE LA BASE DE DATOS XD
	public String MostrarAlumnos(Model model) {
		List<Alumno> alumnos = servicio.buscarTodosAlumnos();
		model.addAttribute("alumnos", alumnos);
		return "alumnos";
	}

	@GetMapping("Lista/profesores")//METODO QUE LISTA TODOS LOS PROFESORES DE LA BASE DE DATOS XD
	public String MostrarProfesores(Model model) {
		List<Profesor> profes = servicio.buscartodosProfesores();
		model.addAttribute("profes", profes);
		return "listaProfesores";
	}
	
	@GetMapping("Lista/alumnos/filtro")//METODO QUE LISTA UN ALUMNO EN ESPECIFICADO SEGUN EL NOMBRE
	public String FiltrarAlumno(Model model,@RequestParam String nombre) {
			model.addAttribute("alumnos", servicio.buscarAlumno(nombre));
			return "alumnos";
	}
	
	@GetMapping("Lista/profesores/filtro")//METODO QUE LISTA UN PROFESOR EN ESPECIFICO SEGUN EL NOMBRE
	public String FiltrarProfesor(Model model,@RequestParam String nombre) {
		model.addAttribute("profes", servicio.buscarProfesor(nombre));
		return "listaProfesores";
	}
	

	
	
	// ================================================================BASES DE DATOS================================================================================
	// SIMULANDO UNA BASE DE DATOS PARA ALUMNOS XD
	private List<String> alumnos() {
		List<String> nombres = new ArrayList<>();
		nombres.add("Juan Perez");
		nombres.add("Pepe Galvez");
		nombres.add("Tito Rios");
		nombres.add("Nelly Gonzales");
		nombres.add("Pedro Maldini");
		nombres.add("Gilberto Cruz");
		nombres.add("Piter MacKay");
		nombres.add("Jaimito Raval");
		return nombres;
	}

	// SIMULANDO UNA BASE DE DATOS PARA PROFESORES XD
	private List<String> profesores() {
		List<String> nombres = new ArrayList<>();
		nombres.add("Joe Fatheree");
		nombres.add("Richard Johnson");
		nombres.add("Aqueela Asifi");
		nombres.add("Robin Chaurasiya");
		nombres.add("Colin Hegarty");
		nombres.add("Ayub Mohamud");
		nombres.add("Maarit Rossi");
		return nombres;
	}
	
	
}

















