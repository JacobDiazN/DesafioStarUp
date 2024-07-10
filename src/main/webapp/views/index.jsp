<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head class="bg-secondary">
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/style.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link
	href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/81a2ed02b0.js"
	crossorigin="anonymous"></script>
</head>
<body class="container bg-secondary">
	<header>
		<nav
			class="navbar navbar-expand-lg text-white bg-dark border-bottom border-body navh"
			data-bs-theme="dark">
			<div class="container-fluid">
				<a class="navbar-brand"
					href="${pageContext.request.contextPath}/views/index.jsp">Bienvenidos</a>
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
							href="${pageContext.request.contextPath}/views/index.jsp">Home</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/views/registro.jsp">Registro</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/views/login.jsp">Login</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<main class="bg-secondary">
		<div class="main-container">
			<div class="image-container">
				<img src="${pageContext.request.contextPath}/assets/img/luna.jpg"
					alt="Main Image" class="main-image">
				<div class="welcome-text">Bienvenidos...</div>
				<div class="welcome-text2 d-none d-md-block">Gestión y Administración</div>
				<div class="button-container">
					<a href="${pageContext.request.contextPath}/views/registro.jsp"
						class="button">Registro</a> <a
						href="${pageContext.request.contextPath}/views/login.jsp"
						class="button">Login</a>
				</div>
			</div>
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
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"
		integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
		crossorigin="anonymous">
    </script>
	<script
		src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
	<script>
        $(document).ready(() => {
            $('#tblActor').DataTable();
        })
    </script>
</body>
</html>