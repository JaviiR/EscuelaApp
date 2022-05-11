package com.vila.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vila.model.Alumno;

@Controller
public class HomeController {
	
	@GetMapping
	public String Inicio(Model model) {
		model.addAttribute("link","Lista/alumnos");
		return "inicio";
	}

	
	@GetMapping("Lista/alumnos")
	public String MostrarAlumnos(Model model) {
		List<Alumno> alumnos=ListarAlumnos();
		model.addAttribute("alumnos", alumnos);
		return "alumnos";
	}
	
	
	
	
	
	//SIMULANDO UNA BASE DE DATOS XD
	private List<String> alumnos() {
		List<String> nombres=new ArrayList<>();
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
	
	
	//CREANDO UNA LISTA DE ALUMNOS CON SUS NOMBRES Y APELLIDOS
	private List<Alumno> ListarAlumnos(){
		List<Alumno> alumno=new ArrayList<>();
		for(int i=0;i<NombresAlumnos().size();i++) {
		Alumno alumno1=new Alumno();
		List<String> nombres=NombresAlumnos();
		List<String> apellidos=ApellidosAlumnos();
		alumno1.setNombre(nombres.get(i));
		alumno1.setApellido(apellidos.get(i));
		alumno.add(alumno1);
		}
		return alumno;
	}
	
	//CREANDO UNA LISTA SEPARANDO SOLO LOS NOMBRES DE LOS ALUMNOS
	private List<String> NombresAlumnos(){
		List<String> nombre = new ArrayList<>();
		for (String cadena : alumnos()) {
			int contador = 0;
			// (1)List<String> letras = new ArrayList<>();//lista para comprobar el contador
			for (int i = 1; i <= cadena.length(); i++) {
				String l = cadena.substring(i - 1, i);
				if (!l.equals(" ")) {
					// (1)letras.add(l);//probando si el contador esta dando la cantidad correcta
					contador += 1;
				} else if (l.equals(" ")) {
					break;
				}

			}

			// (1)System.out.println(letras);
			// (1)System.out.println(contador);
			nombre.add(cadena.substring(0, contador));

		}

		
		return nombre;
	}
	
	
	// CREANDO UNA LISTA SEPARANDO SOLO LOS APELLIDOS DE LOS ALUMNOS
	private List<String> ApellidosAlumnos(){
		List<String> apellidos = new ArrayList<>();
		for (String cadena : alumnos()) {
			int contador = 0;
			// (1)List<String> letras = new ArrayList<>();//lista para comprobar el contador
			for (int i = 1; i <= cadena.length(); i++) {
				String l = cadena.substring(i - 1, i);
				if (!l.equals(" ")) {
					// (1)letras.add(l);//probando si el contador esta dando la cantidad correcta
					contador += 1;
				} else if (l.equals(" ")) {
					break;
				}

			}

			// (1)System.out.println(letras);
			// (1)System.out.println(contador);
			apellidos.add(cadena.substring(contador + 1, cadena.length()));

		}
		return apellidos;
	}
}
