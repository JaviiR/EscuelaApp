package com.vila.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vila.services.VacantesServiceImpl;

@Controller
public class DetalleController {
    
@GetMapping("/Alumno/view/{name}")
public String DetalleAlumno(@PathVariable("name") String nomAlum,Model model){
    VacantesServiceImpl v=new VacantesServiceImpl();
    model.addAttribute("alumno", v.ObtenerAlumno(nomAlum));
   
    return "detalle";
}


}
