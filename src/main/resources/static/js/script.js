
	/*window.onresize = ajustar;

    function ajustar() {

        var heightt = (window.innerHeight).toString();
       
        document.getElementById("div_principal").style.height = heightt + "px";
       
    }
    
    ajustar();*/
/*
    var alumno=document.getElementById("alumno");
    var addAlumno=document.getElementById("addAlumno");
    var profesor=document.getElementById("profe");
    var addProfesor=document.getElementById("addProfe");
    alumno.onmouseover=function(e){
        alumno.style.color="black";
    };
    alumno.onmouseout=function(e){
        alumno.style.color="red";
    }
    profesor.onmouseover=function(e){
        profesor.style.color="black";
    };
    profesor.onmouseout=function(e){
        profesor.style.color="red";
    }
    addAlumno.onmouseover=function(e){
        addAlumno.style.color="black";
    };
    addAlumno.onmouseout=function(e){
        addAlumno.style.color="red";
    }
    addProfesor.onmouseover=function(e){
        addProfesor.style.color="black";
    };
    addProfesor.onmouseout=function(e){
        addProfesor.style.color="red";
    }
*/
   var widthUl=document.getElementById("ul").clientWidth;
  

  
   function arreglo(){
       var cal=widthUl-60;
    document.getElementById("linkAlumno").style.width=cal+"px";
   }
   arreglo();