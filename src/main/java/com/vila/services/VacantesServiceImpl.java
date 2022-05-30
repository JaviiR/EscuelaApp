package com.vila.services;

import java.util.List;





import java.util.ArrayList;




import com.vila.Clases.Separador;
import com.vila.model.*;




public class VacantesServiceImpl  implements IVacantesService{
    
	
	
	
	private Separador s=new Separador();
    private List<Alumno> alumno=null;
	private List<Profesor> profe=null;
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






