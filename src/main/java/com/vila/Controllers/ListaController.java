package com.vila.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


public class ListaController {

	
	public String ListarAlumnos(Model model) {
		model.addAttribute("id","7737894");
		model.addAttribute("nombre","Juan");
		model.addAttribute("PApellido","Vila");
		model.addAttribute("SApellido","Ircañaupa");
		model.addAttribute("tlf","950188918");
		model.addAttribute("direccion","Chaclacayo");
		return "listaAlumnos";
	}
	
	
	public String ListarProfesores(Model model) {
		model.addAttribute("id","773345");
		model.addAttribute("nombre","Javier");
		model.addAttribute("PApellido","Serma");
		model.addAttribute("SApellido","Alpaca");
		model.addAttribute("tlf","958178467");
		model.addAttribute("direccion","Chaclacayo");
		return "listaProfesores";
	}
	
	
	
	
}
