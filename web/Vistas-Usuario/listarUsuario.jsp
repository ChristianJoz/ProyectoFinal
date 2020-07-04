

<%@page import="Model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="lista" scope="session" class="java.util.ArrayList"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
        <%@include file="../WEB-INF/Vistas-Parciales/css-js.jspf" %>
    </head>
    <body>
      <%@include file = "../WEB-INF/Vistas-Parciales/encabezado.jspf" %>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-12 col-md-7 col-sm-3">
                    <div style="">
                        <a href="<%= request.getContextPath() %>/Usuario?opcion=crear" class="btn btn-success btn-group-sm" role="button"> Nuevo Usaurio</a>
                        <a href="pdf3.jsp" class="btn btn-primary btn-sm" role="button">PDF</a>
                            <table class="table table-striped">
                                    <thead>
                                        <th>ID</th>
                                        <th>NOMBRE</th>
                                           <th>APELLIDO</th>
                                        <th>CORREO</th>
                                           <th>USUARIO</th>
                                        <th>CLAVE</th>
                                        <th>TIPO</th>
                                        <th>ESTADO</th>
                                           <th>PREGUNTA</th>
                                           <th>RESPUESTA</th>
                                        <th>REGRISTRO</th>
                                        <th>ACCIONES</th>
                                    </thead>
                                    <tbody>
                                        <% 
                                            for(int i = 0; i< lista.size(); i++){
                                                Usuario us = (Usuario) lista.get(i);

                                        %>
                                        <tr>                    
                                            <td><%=us.getId()%></td>
                                            <td><%=us.getNombre()%></td>
                                            <td><%=us.getApellido()%></td>
                                            <td><%=us.getCorreo()%></td>
                                            <td><%=us.getUsuario()%></td>
                                            <td><%=us.getClave()%></td>
                                                <td><%=us.getTipo()%></td>
                                            <td><%=us.getEstado()%></td>
                                            <td><%=us.getPregunta()%></td>
                                            <td><%=us.getRespuesta()%></td>
                                              <td><%=us.getFecha_registro()%></td>
                                            <td>
                      
                        
                        </td>
                                        </tr>

                                        <% }%>
                                    </tbody>
                            </table>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../WEB-INF/Vistas-Parciales/pie.jspf" %>
    </body>
</html>
