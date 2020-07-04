

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
        <div align="center">
        <h1>FORMULARIO LOGUEO</h1>
        <hr>
        
        
        <form action="SERVLOGIN" method="POST">
            <input type="text" name="txtusuario" placeholder="Ingrese su usuario"><br> 
            <input type="password" name="txtclave" placeholder="Contraseña"><br> 
            <br>
            
            <input type="submit" name="btnIniciar" value="Iniciar Sesion">
            
      
        </form>
        </div>
        <%
            
            
       HttpSession sesion = request.getSession();
       int tipo=0;
       if(request.getAttribute("tipo")!=null){
       tipo = (Integer)request.getAttribute("tipo");
       if(tipo==1)
           sesion.setAttribute("usuario", request.getAttribute("usuario"));
       sesion.setAttribute("tipo", tipo);
       response.sendRedirect("index.jsp");
       
       
       
       }
            
            
            
            
            
            
            
       %>
    
    
    
    
    
    
    
    
    
    </body>
</html>
