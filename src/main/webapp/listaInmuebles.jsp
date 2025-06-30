<%@ page import="java.util.*,modelo.Inmueble" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Inmuebles</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f0f0f5;
            margin: 0;
            padding: 20px;
        }

        h1 {
            text-align: center;
            color: #2c3e50;
        }

        .search-container {
            text-align: center;
            margin: 20px auto;
        }

        .search-container input {
            padding: 10px;
            width: 300px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 1em;
        }

        .inmuebles-grid {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
            padding-top: 20px;
        }

        .card {
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            width: 280px;
            overflow: hidden;
            transition: transform 0.2s;
        }

        .card:hover {
            transform: scale(1.03);
        }

        .card img {
            width: 100%;
            height: 180px;
            object-fit: cover;
        }

        .card-body {
            padding: 15px;
        }

        .card-body h3 {
            margin: 0 0 10px;
            font-size: 1.2em;
            color: #34495e;
        }

        .card-body p {
            margin: 5px 0;
            color: #555;
        }

        .ver-mas {
            display: inline-block;
            margin-top: 10px;
            padding: 8px 15px;
            background-color: #3498db;
            color: white;
            text-decoration: none;
            border-radius: 6px;
            transition: background-color 0.2s;
        }

        .ver-mas:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>

<h1>Inmuebles Disponibles</h1>

<div class="search-container">
    <input type="text" id="busqueda" placeholder="Buscar por tipo, dirección o zona...">
</div>

<div class="inmuebles-grid" id="lista-inmuebles">
<%
    List<Inmueble> lista = (List<Inmueble>) request.getAttribute("inmuebles");
    if (lista != null && !lista.isEmpty()) {
        for (Inmueble i : lista) {
%>
    <div class="card" data-tipo="<%= i.getTipo().toLowerCase() %>" data-direccion="<%= i.getDireccion().toLowerCase() %>" data-zona="<%= i.getZona().toLowerCase() %>">
        <img src="<%= i.getImagenUrl() %>" alt="Imagen inmueble">
        <div class="card-body">
            <h3><%= i.getTipo().substring(0, 1).toUpperCase() + i.getTipo().substring(1) %></h3>
            <p><strong>Dirección:</strong> <%= i.getDireccion() %></p>
            <p><strong>Zona:</strong> <%= i.getZona() %></p>
            <p><strong>Precio:</strong> $<%= i.getPrecio() %></p>
            <a class="ver-mas" href="detalleInmueble?id=<%= i.getId() %>">Ver más</a>
        </div>
    </div>
<%
        }
    } else {
%>
    <p style="text-align: center;">No hay inmuebles disponibles.</p>
<%
    }
%>
</div>

<script>
    const input = document.getElementById("busqueda");
    const cards = document.querySelectorAll(".card");

    input.addEventListener("input", function () {
        const filtro = input.value.toLowerCase();

        cards.forEach(card => {
            const tipo = card.dataset.tipo;
            const direccion = card.dataset.direccion;
            const zona = card.dataset.zona;

            if (tipo.includes(filtro) || direccion.includes(filtro) || zona.includes(filtro)) {
                card.style.display = "block";
            } else {
                card.style.display = "none";
            }
        });
    });
</script>

</body>
</html>
