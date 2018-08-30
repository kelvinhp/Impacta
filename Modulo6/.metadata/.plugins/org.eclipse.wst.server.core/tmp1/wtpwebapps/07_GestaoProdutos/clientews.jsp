<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Lista de Produtos - WebService(REST)</h1>
	<form>
		<input type="button" value="Acessar WeService" id="btnacesso">
		<ul id="lista">

		</ul>
	</form>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
		function getXmlHttpRequest() {
			if (window.XMLHttpRequest)
				return new XMLHttpRequest;
			else
				return new ActiveXObject("Microsoft.XMLHTTP");
		}
		$(document)
				.ready(
						function() {
							$("#btnacesso")
									.click(
											function() {
												let xmlhttp = getXmlHttpRequest();
												xmlhttp.open('GET','http://localhost:8080/07_GestaoProdutos/wsjson', true);

												xmlhttp.onreadystatechange = function() {
													if (xmlhttp.readyState == 4) {
														if (xmlhttp.status == 200) {
															let resposta = JSON.parse(xmlhttp.responseText);
															console.log(resposta);
															let lista = document.getElementById("lista");
															console.log("entrou aqui")
															for (let i = 0; i < resposta.length; i++) {
																let item = document.createElement('li')
																item.textContent = resposta[i].codigo + ":" + resposta[i].descricao;
																lista.appendChild(item);
															}
														}else {
															alert("Erro !")
														}
													} 
												};
												xmlhttp.send();
											})
						})
	</script>
</body>
</html>