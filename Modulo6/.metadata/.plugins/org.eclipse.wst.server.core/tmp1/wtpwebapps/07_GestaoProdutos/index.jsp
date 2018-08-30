<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Site Gest�o de Produtos</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css">
<link href="estilos/style.css" type="text/css">

</head>
<body>

	<header>
		<nav>
			<ul class="menu" id="menuTopo">
				<li><a href="index.jsp"><span class="glyphicon glyphicon-gift"></span></a></li>
				<li><a href="cadastro.jsp">Cadastro de Produtos</a></li>
				<li><a href="consulta.jsp">Buscar</a></li>
			</ul>
		</nav>
	</header>

	<section>
		<div class="row">
		<div class="col-xs-12">
			<div id="slides" class="carousel slide" data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#slides" data-slide-to="0" class="active"></li>
					<li data-target="#slides" data-slide-to="1"></li>
					<li data-target="#slides" data-slide-to="2"></li>
				</ol>

				<!-- conteudo dos slides -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="" />
					</div>
					<div class="item">
						<img src="" />
					</div>
					<div class="item">
						<img src="" />
					</div>
				</div>

				<a class="left carousel-control" href="#slides" role="button"
					data-slide="prev"><span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Anterior</span> </a> <a
					class="right carousel-control" href="#slides" role="button"
					data-slide="next"><span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Pr�xima</span> </a>

			</div>

		</div>
	</div>
	</section>
	
	<footer class="footer">
				<p>Desenvolvido para os estagi�rios da Senior Solution</p>
				<p>Copyright 2017 - Todos os direitos reservados</p>
	</footer>
	

	<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript"  src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript"  src=""></script>
</body>
</html>