package com.vila.services;

import java.util.List;
import java.util.ArrayList;
import com.vila.Clases.Separador;
import com.vila.model.*;
import org.springframework.stereotype.Service;



@Service
public class VacantesServiceImpl  implements IVacantesService{
    
	
	
	
	private Separador s=new Separador();
    private List<Alumno> alumno=null;
	private List<Profesor> profe=null;
	private List<Alumno> alumnoFiltro=null;
	private List<Profesor> profeFiltro=null;
	private Alumno Objalumno=new Alumno();
	//CONSTRUCTOR
	public VacantesServiceImpl(){
		ListarAlumnos();
		ListarProfesores();
       
	}



@Override
public List<Alumno> buscarTodosAlumnos() {
    return alumno;
}

@Override
public List<Profesor> buscartodosProfesores() {
	return profe;
}

@Override
public List<Alumno> buscarAlumno(String nomAlum) {
	
	return FiltroAlumno(nomAlum);
}

@Override
public List<Profesor> buscarProfesor(String nomProfe) {
	return FiltroProfe(nomProfe);
}

@Override
public Alumno ObtenerAlumno(String nomAlum) {
	
		Objalumno.setNombre(FiltroAlumno(nomAlum).get(0).getNombre().toString());
		Objalumno.setApellido(FiltroAlumno(nomAlum).get(0).getApellido().toString());

	return Objalumno;
}

@Override
public Profesor ObtenerProfe(String nomProfe) {
	// TODO Auto-generated method stub
	return null;
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
					alumno = new ArrayList<>();
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
					alumnoFiltro=new ArrayList<>();
					for(int i=0;i<ListarAlumnos().size();i++) {
						String nombre=NombresAlumnos().get(i).toString();
						if(nomAlum.equalsIgnoreCase(nombre)) {
							alumnoFiltro.add(ListarAlumnos().get(i));
						}
					}
					return alumnoFiltro;
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
					profe = new ArrayList<>();
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
					profeFiltro=new ArrayList<>();
					for(int i=0;i<ListarProfesores().size();i++) {
						String nombre=NombresProfesores().get(i).toString();
						if(nomProfe.equalsIgnoreCase(nombre)) {
							profeFiltro.add(ListarProfesores().get(i));
						}
					}
					return profeFiltro;
				}



				public static void main(String[] args) {
					VacantesServiceImpl v=new VacantesServiceImpl();
					//pruebas
					System.out.println("Nombre: "+v.ObtenerAlumno("Juan").getNombre());
					System.out.println("Apellido: "+v.ObtenerAlumno("Juan").getApellido());
					
				}

    
}






