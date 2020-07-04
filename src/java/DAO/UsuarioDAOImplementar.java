package DAO;

import Factory.ConexionDB;
import Factory.FactoryConexionDB;
import Model.Usuario;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImplementar implements UsuarioDAO {

ConexionDB conn;  

public UsuarioDAOImplementar() {
    

      
}




    
@Override
 public List<Usuario> Listar() {
     
this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);

StringBuilder miSQL = new StringBuilder();

miSQL.append("SELECT * FROM tb_usuario;");
List<Usuario> lista = new ArrayList<Usuario>();
try{
            

ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());

while(resultadoSQL.next()){
    
Usuario Usu = new Usuario();


Usu.setId(resultadoSQL.getInt("id"));
Usu.setNombre(resultadoSQL.getString("nombre"));
Usu.setApellido(resultadoSQL.getString("apellido"));
Usu.setCorreo(resultadoSQL.getString("correo"));
Usu.setUsuario(resultadoSQL.getString("usuario"));
Usu.setClave(resultadoSQL.getString("clave"));
Usu.setTipo(resultadoSQL.getInt("tipo"));
Usu.setEstado(resultadoSQL.getInt("estado"));
Usu.setPregunta(resultadoSQL.getString("pregunta"));
Usu.setRespuesta(resultadoSQL.getString("respuesta"));
Usu.setFecha_registro(resultadoSQL.getString("fecha_registro"));

lista.add(Usu); 
}
}catch(Exception ex){
            
}finally{
this.conn.cerrarConexion();
}
        
return lista;
    
}
    

@Override
public List<Usuario> Listar2() {
throw new UnsupportedOperationException("Not supported yet."); 
}





@Override
public Usuario editarUsu(int id_usu_edit) {
 this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
 
Usuario usuario = new Usuario();
StringBuilder miSQL = new StringBuilder();



miSQL.append("SELECT * FROM tb_usuario  WHERE id = ").append(id_usu_edit);


try{
ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
while(resultadoSQL.next()){
    
usuario.setId(resultadoSQL.getInt("id"));
usuario.setNombre(resultadoSQL.getString("nombre"));
usuario.setApellido(resultadoSQL.getString("apellido"));
usuario.setCorreo(resultadoSQL.getString("correo"));
usuario.setUsuario(resultadoSQL.getString("usuario"));
usuario.setClave(resultadoSQL.getString("clave"));
usuario.setTipo(resultadoSQL.getInt("tipo"));
usuario.setEstado(resultadoSQL.getInt("estado"));
usuario.setPregunta(resultadoSQL.getString("pregunta"));
usuario.setRespuesta(resultadoSQL.getString("respuesta"));
usuario.setFecha_registro(resultadoSQL.getString("fecha_registro"));

}

}catch(Exception e){
}finally{
this.conn.cerrarConexion();
}
        
return usuario;
}





    @Override
public boolean guardarUsu(Usuario usuario) {
 this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
 
 boolean guardar = false;
 
 try{

     if(usuario.getId() == 0)
     {
         

         StringBuilder miSQL = new StringBuilder();

         

         miSQL.append("INSERT INTO tb_usuario(`nombre`, `apellido`, `correo`, `usuario`, `clave`, `tipo`, `estado`, `pregunta`, `respuesta`) VALUES ('");
         miSQL.append(usuario.getNombre()+ "','");
         miSQL.append(usuario.getApellido()+"','");
         miSQL.append(usuario.getCorreo()+"','");
         miSQL.append(usuario.getUsuario()+"','");
         miSQL.append(usuario.getClave()+"','");
         miSQL .append(usuario.getTipo()+"','");
         miSQL .append(usuario.getEstado()+"','");
          miSQL .append(usuario.getPregunta()+"','");
           miSQL .append(usuario.getRespuesta()+"','");
         miSQL.append("')");
         this.conn.ejecutarSQL(miSQL.toString());
   
         
        
         
       
     }else if(usuario.getId()>0){
         System.out.println("Entramos...");
         
         
         StringBuilder miSQL = new StringBuilder();
    
         miSQL.append("UPDATE tb_usuario SET ");
         miSQL.append(" `usuario` = '").append(usuario.getNombre());
         miSQL.append("', `apellido` = '").append(usuario.getApellido());
         miSQL.append("', `correo` = ").append(usuario.getCorreo());
         miSQL.append(" , `usuario` = ").append(usuario.getUsuario());
         miSQL.append(" , `clave` = '").append(usuario.getClave());
         miSQL.append("', `tipo` = ").append(usuario.getTipo());
         miSQL.append(", `estado` = ").append(usuario.getEstado());
         miSQL.append(", `pregunta` = ").append(usuario.getPregunta());
         miSQL.append(", `respuesta` = ").append(usuario.getRespuesta());
         miSQL.append(" , `fecha_entrada` = '").append(usuario.getFecha_registro());
         miSQL.append("' WHERE `id` = ").append(usuario.getId()).append(";");
         
          
           this.conn.ejecutarSQL(miSQL.toString());
             
                }
           
          return guardar;
        }catch(Exception e){
            
       
            
        }finally{
            this.conn.cerrarConexion();
        }
        return guardar;
    }



    @Override
    public boolean borrarUsu(int id_usu_borrar) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);

boolean borrar = false;
try{
    
StringBuilder miSQL = new StringBuilder();

miSQL.append("DELETE FROM tb_usuario WHERE id = ").append(id_usu_borrar);
this.conn.ejecutarSQL(miSQL.toString());
borrar = true;
}catch(Exception e){
            
}finally{
this.conn.cerrarConexion();  
}
       
return borrar;
}

    }

    
    


    
    
    

