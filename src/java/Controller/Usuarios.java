package Controller;

import Model.Usuario;
import DAO.UsuarioDAO;
import DAO.UsuarioDAOImplementar;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Usuarios extends HttpServlet {

     protected void listaUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");


        UsuarioDAO Usuario = new UsuarioDAOImplementar();

        HttpSession session = request.getSession(true);
        session.setAttribute("lista", Usuario.Listar()); 

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Usuario/listarUsuario.jsp");
        dispatcher.forward(request, response);
    }

    protected void borrarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Usuario/listarUsuario.jsp");
        dispatcher.forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String parametro = request.getParameter("opcion");


        if (parametro.equals("crear")) {


            String pagina = "/Vistas-Usuario/crearUsuario.jsp";

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);

        } else if (parametro.equals("listar")) {
            this.listaUsuarios(request, response);

        } else if (parametro.equals("modificar")) {


            int id = Integer.parseInt(request.getParameter("idu"));
            String nombre = request.getParameter("nombreu");
            String apellido = request.getParameter("apellidou");
            String correo = request.getParameter("correou");
            String usuario = request.getParameter("usuariou");
            String clave = request.getParameter("claveu");
            int tipo = Integer.parseInt(request.getParameter("tipou"));
            float estado = Float.parseFloat(request.getParameter("estadou"));
            String pregunta = request.getParameter("preguntau");
            String respuesta = request.getParameter("respuestu");
            String fecha_registro = request.getParameter("fecha_registrou");

            String pagina = "/Vistas-Usuario/crearUsuario.jsp?id=" + id + "&&nombre=" + nombre + "&&apellido=" + apellido + "&&correo=" + correo + "&&usuario=" + usuario + "&&clave=" + clave + "&&tipo=" + tipo  + "&&estado=" + estado + "&&pregunta=" + pregunta  + "&&respuesta=" + respuesta +  "&&fecha_registro=" + fecha_registro + "&&senal=1";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);

        } else if (parametro.equals("eliminar")) {
            int del_id = Integer.parseInt(request.getParameter("id"));
            UsuarioDAO us = new UsuarioDAOImplementar() {};
            us.borrarUsu(del_id);
            this.listaUsuarios(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario us = new Usuario();


        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("txtnombre");
        String apellido = request.getParameter("txtApellido");
        String correo = request.getParameter("txtcorreo");
        String usuario = request.getParameter("txtusuario");
        String clave = request.getParameter("txtclave");
        int tipo = Integer.parseInt(request.getParameter("txttipo"));
        int estado= Integer.parseInt(request.getParameter("txtestado"));
        String pregunta = request.getParameter("txtpregunta");
        String respuesta = request.getParameter("txtrespuesta");
        String fecha_entrada = request.getParameter("txtFecha");
         
        us.setId(id);
        us.setNombre(nombre);
        us.setApellido(apellido);
        us.setCorreo(correo);
        us.setUsuario(usuario);
        us.setClave(clave);
        us.setTipo(tipo);
        us.setEstado(estado);
        us.setPregunta(pregunta);
        us.setRespuesta(respuesta);
        us.setFecha_registro(fecha_entrada);
        
        
        UsuarioDAO guardarUsuario = new UsuarioDAOImplementar();
        guardarUsuario.guardarUsu(us);

        this.listaUsuarios(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
