package com.vila.Clases;

import java.util.ArrayList;
import java.util.List;

public class Separador {

    private List<String> nombre;
    private List<String> apellidos;

    public List<String> ObtenerNombre(List<String> NombreCompleto) {
         this.nombre= new ArrayList<>();
        for (String cadena : NombreCompleto) {
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


    public List<String> ObtenerApellido(List<String> NombreCompleto){
        this.apellidos = new ArrayList<>();
        for (String cadena : NombreCompleto) {
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
        if(apellidos.size()!=0){
        return apellidos;
    }
    else{
        return null;
    }

    }




    public String ObtenerNombreString(List<String> NombreCompleto) {
        this.nombre= new ArrayList<>();
       for (String cadena : NombreCompleto) {
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
       if(nombre.size()!=0){
        return nombre.get(0);
    }else{
        return "";
    }

   }


    public String ObtenerApellidoString(List<String> NombreCompleto){
        this.apellidos = new ArrayList<>();
        for (String cadena : NombreCompleto) {
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
       
        if(apellidos.size()!=0){
            return apellidos.get(0);
        }else{
            return "";
        }
        
}
}