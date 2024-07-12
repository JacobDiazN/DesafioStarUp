<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/style.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body class="container bg-secondary">
	<header>
		<nav
			class="navbar navbar-expand-lg text-white bg-dark border-bottom border-body navh"
			data-bs-theme="dark">
			<div class="container-fluid">
				<a class="navbar-brand"
					href="${pageContext.request.contextPath}/views/home.jsp">Home</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
					aria-controls="navbarNavDropdown" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNavDropdown">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page"
							href="${pageContext.request.contextPath}/index.jsp">Salir</a>
						</li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page"
							href="${pageContext.request.contextPath}/mostrarTrabajadores">Mostrar Trabajadores</a>
						</li>
					</ul>
				</div>
			</div>
		</nav>
	</header>

	<main class="bg-secondary">
		<div class="container mt-5 text-light">
			<h2>Bienvenido, ${sessionScope.usuario.nombre}</h2>
		</div>
		<div class="container mt-1 text-light">
			<h4>Usuario:</h4>
			<p>${sessionScope.usuario.nick}</p>
		</div>

	</main>
	<footer class="text-center text-white bg-dark pb-2 pt-2">
		<p>
			Escríbenos a <a href="mailto:contacto@lacosa.com">Contacto</a>
		</p>
	</footer>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous">
		
	</script>
</body>
</html>
