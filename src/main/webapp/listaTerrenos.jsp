<%@ page import="java.util.List" %>
<%@ page import="modelo.Terreno" %>

<%
    List<Terreno> terrenos = (List<Terreno>) request.getAttribute("terrenos");
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Terrenos Disponibles</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f2f2f2;
            padding: 20px;
        }

        h1 {
            text-align: center;
            color: #2c3e50;
        }

        .search-box {
            text-align: center;
            margin-bottom: 20px;
        }

        .search-box input {
            padding: 10px;
            width: 300px;
            border-radius: 5px;
            border: 1px solid #ccc;
            font-size: 1em;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: white;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #3498db;
            color: white;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        .no-data {
            text-align: center;
            padding: 20px;
            font-style: italic;
        }
    </style>
</head>
<body>

<h1>Terrenos Disponibles</h1>

<div class="search-box">
    <input type="text" id="filtro" placeholder="Buscar por zona o dirección...">
</div>

<table id="tablaTerrenos">
    <tr>
        <th>ID</th>
        <th>Dirección</th>
        <th>Zona</th>
        <th>Precio</th>
        <th>Con Pasto</th>
    </tr>
<%
    if (terrenos != null && !terrenos.isEmpty()) {
        for (Terreno t : terrenos) {
%>
    <tr>
        <td><%= t.getId() %></td>
        <td><%= t.getDireccion() %></td>
        <td><%= t.getZona() %></td>
        <td>$<%= t.getPrecio() %></td>
        <td><%= t.isPasto() ? "Sí" : "No" %></td>
    </tr>
<%
        }
    } else {
%>
    <tr>
        <td colspan="5" class="no-data">No hay terrenos disponibles.</td>
    </tr>
<%
    }
%>
</table>

<script>
    const input = document.getElementById("filtro");
    const filas = document.querySelectorAll("#tablaTerrenos tr:not(:first-child)");

    input.addEventListener("input", () => {
        const filtro = input.value.toLowerCase();

        filas.forEach(fila => {
            const direccion = fila.cells[1].textContent.toLowerCase();
            const zona = fila.cells[2].textContent.toLowerCase();
            const mostrar = direccion.includes(filtro) || zona.includes(filtro);
            fila.style.display = mostrar ? "" : "none";
        });
    });
</script>

</body>
</html>
