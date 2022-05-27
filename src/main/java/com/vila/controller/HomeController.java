package com.vila.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {
	
	@GetMapping("")
	public String Inicio(Model model) {
		model.addAttribute("linkAlumno","filtro/alumnos");
		model.addAttribute("imgAlumn","/imgs/alumno.jpg");
		model.addAttribute("linkProfe","filtro/profesores");
		model.addAttribute("imgProfe","/imgs/profe.png");
		model.addAttribute("linkAlumnoAgree","/form/alumno");
		model.addAttribute("linkProfeAgree","/form/profesor");
		return "inicio";
	}

	
	
}

