<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Inmobiliaria | Inicio</title>
    <style>
        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', sans-serif;
            background-image: url('img/fondo-inmobiliaria.jpg'); /* Reemplaza con la ruta de tu imagen */
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            min-height: 100vh;
            color: #fff;
            backdrop-filter: brightness(0.8);
        }

        .overlay {
            background-color: rgba(0, 0, 0, 0.6);
            min-height: 100vh;
            padding: 50px 20px;
        }

        h1 {
            text-align: center;
            font-size: 3em;
            margin-bottom: 20px;
            color: #f1c40f;
            text-shadow: 2px 2px 5px #000;
        }

        .menu {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
            margin-top: 40px;
        }

        .menu a {
            padding: 20px 30px;
            background: linear-gradient(135deg, #2980b9, #3498db);
            border: none;
            color: white;
            text-decoration: none;
            font-size: 1.2em;
            border-radius: 10px;
            transition: all 0.3s ease;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
        }

        .menu a:hover {
            background: linear-gradient(135deg, #1abc9c, #16a085);
            transform: scale(1.05);
        }

        footer {
            margin-top: 60px;
            text-align: center;
            color: #ccc;
            font-size: 0.9em;
        }
    </style>
</head>
<body>
<div class="overlay">
    <h1>Bienvenido a Inmobiliaria XYZ</h1>

    <div class="menu">
        <a href="inmuebles">🏘 Ver todos los inmuebles</a>
        <a href="terrenos">🌳 Terrenos disponibles</a>
        <a href="locales">🏢 Locales en renta/venta</a>
        <a href="casas">🏠 Casas disponibles</a>
        <a href="departamentos">🏬 Departamentos disponibles</a>
    </div>

    <footer>
        © 2025 Inmobiliaria XYZ - Todos los derechos reservados
    </footer>
</div>
</body>
</html>
