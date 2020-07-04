package DAO;

import Factory.ConexionDB;
import Factory.FactoryConexionDB;
import Model.Categoria;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CategoriaDAOImplementar implements CategoriaDAO{
    
ConexionDB conn; 

public CategoriaDAOImplementar() {

      
}
    
  

@Override
 public List<Categoria> Listar() {
this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
StringBuilder miSQL = new StringBuilder();
miSQL.append("SELECT * FROM tb_categoria;");
List<Categoria> lista = new ArrayList<Categoria>();
try{
            

ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());

while(resultadoSQL.next()){
    
Categoria categoria = new Categoria();


categoria.setId_categoria(resultadoSQL.getInt("id_categoria"));
categoria.setNom_categoria(resultadoSQL.getString("nom_categoria"));
categoria.setEstado_categoria(resultadoSQL.getInt("estado_categoria"));
lista.add(categoria);
}
}catch(Exception ex){
            
}finally{
this.conn.cerrarConexion();
}
        
return lista;
    
}

    
@Override
public List<Categoria> Listar2() {
throw new UnsupportedOperationException("Not supported yet."); 
}



@Override
public Categoria editarCat(int id_cat_edit) {
this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
Categoria categoria = new Categoria();
StringBuilder miSQL = new StringBuilder();



miSQL.append("SELECT * FROM tb_categoria WHERE id_categoria = ").append(id_cat_edit);


try{
ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
while(resultadoSQL.next()){
categoria.setId_categoria(resultadoSQL.getInt("id_categoria"));
categoria.setNom_categoria(resultadoSQL.getString("nom_categoria"));
categoria.setEstado_categoria(resultadoSQL.getInt("estado_categoria"));
}

}catch(Exception e){
}finally{
this.conn.cerrarConexion();
}
        
return categoria;
}




@Override
public boolean guardarCat(Categoria categoria) {
this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
     
boolean guardar = false; 
try{
    
if(categoria.getId_categoria() ==0){ 

StringBuilder miSQL = new StringBuilder();


miSQL.append("INSERT INTO tb_categoria(nom_categoria, estado_categoria) VALUES (' ");
miSQL.append(categoria.getNom_categoria() + "', ").append(categoria.getEstado_categoria());
                miSQL.append(");");
                
                

                
this.conn.ejecutarSQL(miSQL.toString());



}else if(categoria.getId_categoria()>0){
    

    

    
StringBuilder miSQL = new StringBuilder();
miSQL.append("UPDATE tb_categoria SET id_categoria = ").append(categoria.getId_categoria());
miSQL.append(", nom_categoria =  '").append(categoria.getNom_categoria());
miSQL.append("', estado_categoria =  ").append(categoria.getEstado_categoria());
miSQL.append(" WHERE id_categoria = ").append(categoria.getId_categoria()).append(";");
                
this.conn.ejecutarSQL(miSQL.toString());



}

            
}catch(Exception e){
            
}finally{
this.conn.cerrarConexion();
}
return guardar;
}




@Override
public boolean borrarCat(int id_cat_borrar) {
this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
boolean borrar = false;
try{
StringBuilder miSQL = new StringBuilder();
miSQL.append("DELETE FROM tb_categoria WHERE id_categoria = ").append(id_cat_borrar);
this.conn.ejecutarSQL(miSQL.toString());
borrar = true;
}catch(Exception e){
            
}finally{
    this.conn.cerrarConexion(); 
     }
return borrar;
    }
}