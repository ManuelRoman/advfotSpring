var x;
x=$(document);
x.ready(inicializarEventos);
function inicializarEventos() {
	var x;
	$("#mostrarLogin").click(function() {
		mostrarOcultarElemento("#login");
	});
	$("#mostrarRegistro").click(function() {
		mostrarOcultarElemento("#registro");
	});
	$("#terminar").click(function(event) {
        if(!confirm('¿Estás seguro que quieres terminar de jugar?') ) 
            event.preventDefault();
    });
    x=$("#titulo");
    x.on("keyup",function(event){
    	sugerenciaTitulo(event);
	})
	x=$("#buscarTitulo");
    x.on("click",function(event){
    	event.preventDefault();
    	buscarTitulo();
	})
	$("#comprobarLogin").click(function() {
		comprobarLogin("loginAComprobar="+$("#login3").val());
	});
    $('[data-toggle=confirmation]').confirmation({
    	  rootSelector: '[data-toggle=confirmation]',
    });
}

function mostrarOcultarElemento(elemento){
	$(elemento).toggle();
    $("#general").toggle();
}

function sugerenciaTitulo(event){
	var dato = $("#titulo").val();
	console.log("Antes del if: "+dato);
	console.log($('#formulario').attr('action'));
	if((event.keyCode>=48 && event.keyCode<=57) || (event.keyCode>=65 && event.keyCode<=90) || (event.keyCode >= 96 && event.keyCode <= 105)){
		console.log("Después del if: "+dato);
		$.ajax({ //Con esto se trabaja con ajax a través de jquery
	        async:true,
	        type: "POST",
	        dataType: "json", //tipo de dato que se va ha recibir
	        contentType: "application/x-www-form-urlencoded", //como se envia los datos
	        url:"/ejer3ajaxfotperdido/controlador?accion=verInfoPelicula", //url a la que se envia
	        //url:$('#formulario').attr('action'),
	        //data:$("#formulario").serialize(), //cadena, los datos de la petición
	        data:"titulo="+$("#titulo").val(),
	        beforeSend: inicioEnvio,
	        success: llegadaDatos, //función que recupera los datos devueltos
	        timeout: 4000, //tiempo máximo a esperar para la respuesta
	        error: problemas //Si hay algún problema, se ejecuta
	    });
	}
}

function buscarTitulo(){
	$.ajax({ //Con esto se trabaja con ajax a través de jquery
        async:true,
        type: "POST",
        dataType: "json", //tipo de dato que se va ha recibir
        contentType: "application/x-www-form-urlencoded", //como se envia los datos
        //url:"/ejer3ajaxfotperdido/controlador?accion=verInfoPelicula", //url a la que se envia
        url:$('#formulario').attr('action'),
        data:$("#formulario").serialize(), //cadena, los datos de la petición
        //data:"titulo="+$("#titulo").val(),
        beforeSend: inicioEnvio,
        success: llegadaLista, //función que recupera los datos devueltos
        timeout: 4000, //tiempo máximo a esperar para la respuesta
        error: problemas //Si hay algún problema, se ejecuta
    });
}

function inicioEnvio() {
    //no se hace nada
}

function llegadaDatos(datos) {
	console.log(datos);
	//var titulos = jQuery.parseJSON(datos);
	jQuery.each( datos, function( i, val ) {
		console.log(i+"->"+val);
		});
	$("#Titulos").empty()
	jQuery.each( datos, function( i, val ) {
		$("#titulos").append("<option value=\""+val+"\">");
		});
}

function llegadaLista(datos){
	console.log(datos);
	jQuery.each( datos, function( i, val ) {
		console.log(i+"->"+datos[i].idFotograma+" - "+ datos[i].titPelicula+" - "+ datos[i].anyoEstreno+" - " + 
				datos[i].director+" - "+ datos[i].archivo + " - " + datos[i].genero);
		});
	$("#datosTabla").empty();
	jQuery.each( datos, function( i, val ) {
		datosTabla += $("#datosTabla").append("<tr><td>"+ datos[i].titPelicula+"</td><td>" + datos[i].director+"</td><td>" + datos[i].genero + "</td><td>"
				+ datos[i].anyoEstreno+"</td></tr>");
		});
}

function problemas() {
	console.log("Hay un problema en el servidor.");
}

function comprobarLogin(login){
	$.ajax({
        async:true,
        type: "POST",
        dataType: "json", //tipo de dato que se va ha recibir
        contentType: "application/x-www-form-urlencoded", //como se envia los datos
        //url:"/ejer3ajaxfotperdido/controlador?accion=verInfoPelicula", //url a la que se envia
        url:$('#formRegistro').attr('action')+"?accion=registro&peticion=comprobarLogin",
        data:login, //cadena, los datos de la petición
        //data:"titulo="+$("#titulo").val(),
        beforeSend: inicioEnvio,
        success: existeLogin, //función que recupera los datos devueltos
        timeout: 4000, //tiempo máximo a esperar para la respuesta
        error: problemas //Si hay algún problema, se ejecuta
    });
}

function existeLogin(datos){
	console.log(datos);
	if(datos){
		console.log("existe el login");
		$("#errorLoginExiste").empty();
		$("#errorLoginExiste").append("<h4 class='bg-warning'>El login ya está en uso</h4>");
		
	} else {
		console.log("no existe el login");
		$("#errorLoginExiste").empty();
		$("#errorLoginExiste").append("<h4 class='bg-info'>El login no está en uso</h4>");
	}
}
