window.onresize =ajustar ;

function ajustar() {

    var heightt = (window.innerHeight).toString();
    var widthDivForm = document.getElementById("div_nombre").clientWidth;

    document.getElementById("div_principal").style.height = heightt + "px";
    document.getElementById("GET-name").style.width = widthDivForm + "px";
    
    
}
ajustar();