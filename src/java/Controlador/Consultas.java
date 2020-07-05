package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Consultas extends Conexion{
    public boolean autoenticacion(String usuario, String contraseña){
    
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            String consulta = "select * from tb_usuario where usuario = ? and clave = ?";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, usuario);
            pst.setString(2, contraseña);
            rs = pst.executeQuery();
            
            if(rs.absolute(1)){
                 return true; 
            }
        } catch (Exception e) {
            System.err.println("Error" + e);
        }finally{
            try {
                if(getConnection() != null)getConnection().close();
                if(pst != null) pst.close();
                if(rs != null)rs.close();
            } catch (Exception e) {
                System.err.println("Error" + e);
            }
        }
        
    return false;
    }
    
    public boolean registrar(String nombre, String apellido, String correo, String usuario, String clave, String tipo, String estado, String pregunta, String respuesta){
        
             PreparedStatement pst = null;
        
        try {
            String consulta = "insert into tb_usuario (nombre, apellido, correo, usuario, clave, tipo, estado, pregunta, respuesta) values(?,?,?,?,?,?,?,?,?)";
            pst = getConnection().prepareStatement(consulta);
            pst.setString(1, nombre);
            pst.setString(2, apellido);
            pst.setString(3, correo);
            pst.setString(4, usuario);
            pst.setString(5, clave);
            pst.setInt(6, 1);
            pst.setInt(7, 1);
            pst.setString(8, pregunta);
            pst.setString(9, respuesta);
            
            
            if(pst.executeUpdate() == 1){
                return true;
            }
        } catch (Exception ex) {
            System.err.println("Error" + ex);
        }finally{
             try {
                if(getConnection() != null)getConnection().close();
                if(pst != null) pst.close();
            } catch (Exception ex) {
                System.err.println("Error" + ex);
            }
        }
        
    return false;
    }
}
