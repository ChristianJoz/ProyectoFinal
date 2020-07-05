

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="Usuario" scope="session" class="Model.Usuario" />
    <%
String id = "";
String nombre = "";
String apellido = "";
String correo = "";
String usuario = "";
String clave = "";
String tipo = "";
String estado = "";
String pregunta = "";
String respuesta = "";
    String fecha_registro = "";

if(request.getParameter("senal")!=null){
        
          id = request.getParameter("idu");
nombre = request.getParameter("nombreu");
apellido = request.getParameter("apellidou");
correo = request.getParameter("correou");
usuario = request.getParameter("usuariou");
clave = request.getParameter("claveu");
tipo = request.getParameter("tipou");
estado = request.getParameter("estadou");
pregunta = request.getParameter("preguntau");
respuesta = request.getParameter("respuestau");
fecha_registro = request.getParameter("fecha_registrou");

}else{

    id = String.valueOf(Usuario.getId());    
nombre = Usuario.getNombre();
apellido = Usuario.getApellido();
correo = Usuario.getCorreo();
usuario = Usuario.getUsuario();
clave = Usuario.getClave();
tipo = String.valueOf(Usuario.getTipo());
estado = String.valueOf(Usuario.getEstado());
pregunta = Usuario.getFecha_registro();
}
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../WEB-INF/Vistas-Parciales/css-js.jspf" %>
        <title>JSP Page</title>
    </head>
    <body>
        
<%@include file="../WEB-INF/Vistas-Parciales/encabezado.jspf" %>
        <h3>CREAR NUEVO USUARIO</h3>
        
                 
        <form class="form-horizontal" id="frmCategoria" name="frmCategoria" action="<%= request.getContextPath() %>/Usuario" method="post">
        <input type="hidden" name="id" value="<%= id %>" >
            
        <div class="form-group">
            <label for="txtNomUsuario" class="col-sm-2 control-label">Nombre:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="txtnombre" value="<%= nombre %>" required>
            </div>
        </div>
            
        <div class="form-group">
            <label for="txtApellUsuario" class="col-sm-2 control-label">Apellido:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="txtApellido" value="<%= apellido %>" required>
            </div>
        </div>
                
            
            
            
        <div class="form-group">
            <label for="txtcorrUsuario" class="col-sm-2 control-label">Correo:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="txtcorreo" value="<%= correo %>" required>
            </div>
        </div>
                
        <div class="form-group">
            <label for="txtUsUsuario" class="col-sm-2 control-label">Usuario:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="txtusuario" value="<%= usuario %>" required>
            </div>
        </div>
                
        <div class="form-group">
            <label for="txtClaUsuario" class="col-sm-2 control-label">Clave:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="txtclave" value="<%= clave %>" required>
            </div>
        </div>
                
        <div class="form-group">
            <label for="txtTipUsuario" class="col-sm-2 control-label">Tipo:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="txttipo" value="<%= tipo %>" required>
            </div>
        </div>
                
        <div class="form-group">
            <label for="txtestado" class="col-sm-2 control-label">Estado:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="txtestado" value="<%= estado %>" required>
            </div>
        </div>
                
            
            
        <div class="form-group">
            <label for="txtpregunta" class="col-sm-2 control-label">Pregunta:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="txtpregunta" value="<%= pregunta %>" required>
            </div>
        </div>
                
            
            
        <div class="form-group">
            <label for="txtrespuesta" class="col-sm-2 control-label">Respuesta:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="txtrespuesta" value="<%= respuesta %>" required>
            </div>
        </div>
                
            
            
      <div class="form-group">
            <label for="txtFecha" class="col-sm-2 control-label">Fecha de registro:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="txtFecha" value="<%= fecha_registro %>" required>
            </div>
        </div>
                
            
            
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
            <%
                if(request.getParameter("senal")!=null){
            %>

            
            
            <input type="submit" class="btn btn-default btn-sm" name="btnModificar" value="Actualizar" />
            <%
 
            }else{   

            %>    
            <input type="submit" class="btn btn-success btn-sm" name="btnGuardar" value="Guardar" />
            <%
            }  
            %> 
            
            
            <input type="button" class="btn btn-info btn-sm" onclick="regresar('<%= request.getContextPath() %>/categorias?opcion=listar')" 
                name="btnRegresar" value="Regresar" />
            </div>
        </div>   
        </form>
        
        <script type="text/javascript">
    
       
        function regresar(url){
        location.href = url;
        }
        </script>
    </body>

</html>
