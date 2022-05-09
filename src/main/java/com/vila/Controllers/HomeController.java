package com.vila.Controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

	
	
	@GetMapping("/inici")
	public String Inicio() {
		return "alunnos";
	}
	
	
	@GetMapping("/alumnos")
	public String ListarAlumnos() {
		return "alumnos";
	}
	
	
	
}
