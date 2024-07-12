<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trabajadores y Vehículos</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="container bg-secondary">
    <header>
        <nav class="navbar navbar-expand-lg text-white bg-dark border-bottom border-body navh" data-bs-theme="dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/views/home.jsp">Home</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavDropdown">
                    <ul class="navbar-nav">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/index.jsp">Salir</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>

    <main class="bg-secondary text-center text-light">
        <div class="container mt-5">
            <h2>Trabajadores y Vehículos</h2>
            <table class="table table-dark table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Rol</th>
                        <th>Vehículos</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="trabajador" items="${trabajadores}">
                        <tr>
                            <td>${trabajador.id}</td>
                            <td>${trabajador.nombre}</td>
                            <td>${trabajador.apellido}</td>
                            <td>${trabajador.rol}</td>
                            <td>
                                <c:forEach var="vehiculo" items="${trabajador.vehiculos}">
                                    ${vehiculo.marca} ${vehiculo.modelo} (${vehiculo.año})<br/>
                                </c:forEach>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </main>
    <footer class="text-center text-light bg-dark border-top border-body navh">
        <p>© 2024 Trabajadores y Vehículos</p>
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ON1aQKCP262dFyxOUqh+V8tOcwGi74nXxIr5FSTSQ41JYZ5H7bd2BPZmCmwgZLVo" crossorigin="anonymous"></script>
</body>
</html>
