<%@ page import="modelo.Inmueble" %>
<%
    Inmueble i = (Inmueble) request.getAttribute("inmueble");
    if (i == null) {
%>
    <h2>No se encontró el inmueble</h2>
    <a href="listarInmuebles">← Volver</a>
<%
    } else {
%>
<html>
<head><title>Detalle del Inmueble</title></head>
<body>
    <h1>Detalles del Inmueble</h1>
    <p><strong>Tipo:</strong> <%= i.getTipo() %></p>
    <p><strong>Dirección:</strong> <%= i.getDireccion() %></p>
    <p><strong>Zona:</strong> <%= i.getZona() %></p>
    <p><strong>Precio:</strong> $<%= i.getPrecio() %></p>
    <img src="<%= i.getImagenUrl() %>" width="300" /><br><br>
    <a href="listarInmuebles">← Volver a la lista</a>
</body>
</html>
<%
    }
%>
