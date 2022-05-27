package com.vila.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FilterController {
	@GetMapping("/filtro/alumnos")
	public String FiltroAlumnos(Model model) {
		model.addAttribute("Todos", "/Lista/alumnos");
		model.addAttribute("Filtro", "/Lista/alumnos/filtro");
		model.addAttribute("titulo", "NOMBRE DEL ALUMNO");
		return "filter";
	}

	@GetMapping("/filtro/profesores")
	public String FiltroProfesores(Model model) {
		model.addAttribute("Todos", "/Lista/profesores");
		model.addAttribute("Filtro", "/Lista/profesores/filtro");
		model.addAttribute("titulo", "NOMBRE DEL PROFESOR");
		return "filter";
	}

}
