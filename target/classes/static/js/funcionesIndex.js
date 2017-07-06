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
}

function mostrarOcultarElemento(elemento){
	$(elemento).toggle();
    $("#general").toggle();
}