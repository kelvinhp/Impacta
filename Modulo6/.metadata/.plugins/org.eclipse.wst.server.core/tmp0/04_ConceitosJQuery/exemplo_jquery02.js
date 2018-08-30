/**
 * 
 */

$(document).ready(function(){
	var cursos = ["Java","PHP","HTML", "Python"];
	
	$.each(cursos, function(indice, elemento) {
		$("#lista").append($("<option>", {
			value: indice,
			text: elemento
			}));
	});
	
	//cursos.forEach(function(e, i, a){
	//	$("#lista").append("<option value=" + i + ">" + e + "</option>");
	//})
	
	//for(var i = 0; i < cursos.length; i++){
	//	$("#lista").append("<option value=" + i + ">" + cursos[i] + "</option>");
	//}
	
	$("#btn_enviar").click(function(){
		//obetendo o conteúdo dos componentes
		var nome = $("#nome").val();
		var idade = $("#idade").val();
		var curso = $("lista").val();
		
		var resultado;
		
		if($("#resposta").hasClass("erro")){
			$("#resposta").removeClass("erro");
		}
		if($("#resposta").hasClass("ok")){
			$("#resposta").removeClass("ok")
		}
		
		if(idade == ""){
			resultado = "Idade inválida";
			$("#resposta").addClass("erro");
		}else{
			resultado = (idade < 18) ? "Menor de idade" : "Maior de idade";
			$("#resposta").addClass("ok");
		}
		
		$("#resposta").hide();
		$("#resposta").html(resultado);
		$("#resposta").fadeIn(150);
		$("#resposta").delay(800);
		$("#resposta").fadeOut(150);
	});
});