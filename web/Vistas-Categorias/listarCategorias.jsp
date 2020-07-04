
<%@page import="Model.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:useBean id="lista" scope="session" class="java.util.List" />
<html>
<head>
<title>Control de Inventario</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@include file="../WEB-INF/Vistas-Parciales/css-js.jspf" %>

</head>
<body>
       

<%@include file="../WEB-INF/Vistas-Parciales/encabezado.jspf" %>
        

        
<div style="width: 600px;">

<br>

<a href="<%= request.getContextPath() %>/categorias?opcion=crear" class="btn btn-success btn-group-sm" role="button">Nueva Categoria</a>
<a href="pdf.jsp" class="btn btn-primary btn-sm" role="button">PDF</a>
<h3>Listado de Categorias Registradas</h3>
<table class="table table-striped">

<tr>
<th>ID</th>
<th>NOMBRE</th>
<th>ESTADO</th>
<th>ACCION</th>
</tr>

<%
for(int i=0;i < lista.size(); i++){
Categoria categoria = new Categoria();
categoria = (Categoria)lista.get(i);
%>
<tr>
<td><%= categoria.getId_categoria() %></td>
<td><%= categoria.getNom_categoria() %></td>
<td><%= categoria.getEstado_categoria() %></td>
<td>

<a href="<%= request.getContextPath() %>/categorias?opcion=modificar&&id_cat=<%= categoria.getId_categoria() %>&&nombre_cat=<%= categoria.getNom_categoria() %>&&estado_cat=<%= categoria.getEstado_categoria() %>" class="btn btn-info btn-sm glyphicon glyphicon-edit" role="button" name="btnmodi">Editar</a>
<a href="<%= request.getContextPath() %>/categorias?opcion=eliminar&&id=<%= categoria.getId_categoria() %>" class="btn btn-danger btn-sm glyphicon glyphicon-remove" role="button">Eliminar</a>
</td>
</tr>
<%
}
%>
</table>
</div>

        
<%@include file="../WEB-INF/Vistas-Parciales/pie.jspf" %>
</body>
</html>