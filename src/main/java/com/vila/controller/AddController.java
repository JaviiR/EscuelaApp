package com.vila.controller;

import java.util.ArrayList;
import java.util.List;

import com.vila.Clases.Separador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddController {
    Separador s=new Separador();
    
    @GetMapping("/form/alumno")
    public String AddAlumno(Model model){
        model.addAttribute("LinkAgregado", "/alumnos/agregado");
        return "add/addAlumno";
    }

    @GetMapping("/form/profesor")
    public String AddProfesor(){
        return "add/addProfesor";
    }

    @PostMapping("/alumnos/agregado")
    public String AddSuccess(@RequestParam String alumno){
        List<String>alumnos=new ArrayList<>();
        alumnos.add(alumno);
        String NombreAlumn=s.ObtenerNombreString(alumnos);
        String ApellidoAlumn="";
        try {
            ApellidoAlumn=s.ObtenerApellidoString(alumnos);    
        } catch (Exception e) {
            ApellidoAlumn="";
            System.out.println("ERror: "+e.getMessage());
        }
        
        System.out.println("Nombre: "+NombreAlumn);
        System.out.println("Apellido: "+ApellidoAlumn);
        return "add/addSuccess";
        }
}

