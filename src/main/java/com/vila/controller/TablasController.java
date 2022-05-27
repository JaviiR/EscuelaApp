package com.vila.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.vila.Clases.Separador;
import com.vila.model.*;

@Controller
public class TablasController {


Separador s=new Separador();
	

	@GetMapping("Lista/alumnos")//METODO QUE LISTA TODOS LOS ALUMNOS DE LA BASE DE DATOS XD
	public String MostrarAlumnos(Model model) {
		List<Alumno> alumnos = ListarAlumnos();
		model.addAttribute("alumnos", alumnos);
		return "alumnos";
	}

	@GetMapping("Lista/profesores")//METODO QUE LISTA TODOS LOS PROFESORES DE LA BASE DE DATOS XD
	public String MostrarProfesores(Model model) {
		List<Profesor> profes = ListarProfesores();
		model.addAttribute("profes", profes);
		return "listaProfesores";
	}
	
	@GetMapping("Lista/alumnos/filtro")//METODO QUE LISTA UN ALUMNO EN ESPECIFICADO SEGUN EL NOMBRE
	public String FiltrarAlumno(Model model,@RequestParam String nombre) {
			model.addAttribute("alumnos", FiltroAlumno(nombre));
			return "alumnos";
	}
	
	@GetMapping("Lista/profesores/filtro")//METODO QUE LISTA UN PROFESOR EN ESPECIFICO SEGUN EL NOMBRE
	public String FiltrarProfesor(Model model,@RequestParam String nombre) {
		model.addAttribute("profes", FiltroProfe(nombre));
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
	
	
	//=======================================================SEPARANDO NOMBRE Y APELLIDOS DE LOS ALUMNOS=============================================================
		// CREANDO UNA LISTA SEPARANDO SOLO LOS NOMBRES DE LOS ALUMNOS
		/*private List<String> NombresAlumnos() {
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
		}*/
		
		public List<String> NombresAlumnos(){
			return s.ObtenerNombre(alumnos());
		}

		// CREANDO UNA LISTA SEPARANDO SOLO LOS APELLIDOS DE LOS ALUMNOS
		private List<String> ApellidosAlumnos() {
			return s.ObtenerApellido(alumnos());
		}
		

		// CREANDO UNA LISTA DE ALUMNOS CON SUS NOMBRES Y APELLIDOS SEPARADOS
				private List<Alumno> ListarAlumnos() {
					List<Alumno> alumno = new ArrayList<>();
					for (int i = 0; i < NombresAlumnos().size(); i++) {
						Alumno alumno1 = new Alumno();
						List<String> nombres = NombresAlumnos();
						List<String> apellidos = ApellidosAlumnos();
						alumno1.setNombre(nombres.get(i));
						alumno1.setApellido(apellidos.get(i));
						alumno.add(alumno1);
					}
					return alumno;
				}
				
				
				
		//CREANDO UNA LISTA FILTRADA POR EL NOMBRE DEL ALUMNO
				private List<Alumno> FiltroAlumno(String nomAlum){
					List<Alumno> alumnos=new ArrayList<>();
					for(int i=0;i<ListarAlumnos().size();i++) {
						String nombre=NombresAlumnos().get(i).toString();
						if(nomAlum.equalsIgnoreCase(nombre)) {
							alumnos.add(ListarAlumnos().get(i));
						}
					}
					return alumnos;
				}
		//=======================================================SEPARANDO NOMBRE Y APELLIDOS DE LOS PROFESORES=================================================
		// CREANDO UNA LISTA SEPARANDO SOLO LOS NOMBRES DE LOS PROFESORES
		private List<String> NombresProfesores() {
			return s.ObtenerNombre(profesores());
		}

		
		// CREANDO UNA LISTA SEPARANDO SOLO LOS APELLIDOS DE LOS PROFESORES
		private List<String> ApellidosProfesores() {
			return s.ObtenerApellido(profesores());
		}
		
		
		// CREANDO UNA LISTA DE PROFESORES CON SUS NOMBRES Y APELLIDOS JUNTOS
				private List<Profesor> ListarProfesores() {
					List<Profesor> profe = new ArrayList<>();
					for (int i = 0; i < NombresProfesores().size(); i++) {
						Profesor profe1 = new Profesor();
						List<String> nombres = NombresProfesores();
						List<String> apellidos = ApellidosProfesores();
						profe1.setNombre(nombres.get(i));
						profe1.setApellido(apellidos.get(i));
						profe.add(profe1);
					}
					return profe;
				}
		
				//CREANDO UNA LISTA FILTRADA POR EL NOMBRE DEL PROFESOR
				private List<Profesor> FiltroProfe(String nomProfe){
					List<Profesor> profesores=new ArrayList<>();
					for(int i=0;i<ListarProfesores().size();i++) {
						String nombre=NombresProfesores().get(i).toString();
						if(nomProfe.equalsIgnoreCase(nombre)) {
							profesores.add(ListarProfesores().get(i));
						}
					}
					return profesores;
				}
}















//CONTINUANDO EL CURSO DE SPRING BOOT

