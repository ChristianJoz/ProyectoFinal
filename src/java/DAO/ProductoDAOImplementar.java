
package DAO;

import Factory.ConexionDB;
import Factory.FactoryConexionDB;
import Model.Categoria;
import Model.Producto;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImplementar implements ProductoDAO {
    
ConexionDB conn;  


public ProductoDAOImplementar() {
   
}

@Override
public List<Producto> Listar() {
this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
StringBuilder miSQL = new StringBuilder();

miSQL.append("SELECT * FROM tb_producto;");

List<Producto> lista = new ArrayList<Producto>();
try{
            

ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());

while(resultadoSQL.next()){
    
Producto producto = new Producto();


producto.setId_producto(resultadoSQL.getInt("id_producto"));
producto.setNom_producto(resultadoSQL.getString("nom_producto"));
producto.setDes_producto(resultadoSQL.getString("des_producto"));
producto.setStock(resultadoSQL.getFloat("stock"));
producto.setPrecio(resultadoSQL.getFloat("precio"));
producto.setUnidadMedida(resultadoSQL.getString("unidad_de_medida"));
producto.setEstado(resultadoSQL.getInt("estado_producto"));
producto.setCategoria_id(resultadoSQL.getInt("categoria")); 
producto.setFecha_entrada(resultadoSQL.getString("fecha_entrada"));



lista.add(producto); 
}
}catch(Exception ex){
            
}finally{
this.conn.cerrarConexion();
}
        
return lista;
    
}

    

@Override
public List<Producto> Listar2() {
 throw new UnsupportedOperationException("Not supported yet.");
}

    
    
@Override
public Producto editarPro(int id_pro_edit) {
    
this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);

Producto producto = new Producto();
StringBuilder miSQL = new StringBuilder();



miSQL.append("SELECT * FROM tb_producto WHERE id_producto = ").append(id_pro_edit);


try{
ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());

while(resultadoSQL.next()){
producto.setId_producto(resultadoSQL.getInt("id_producto"));
producto.setNom_producto(resultadoSQL.getString("nom_producto"));
producto.setDes_producto(resultadoSQL.getString("des_producto"));
producto.setStock(resultadoSQL.getFloat("stock"));
producto.setPrecio(resultadoSQL.getFloat("precio"));
producto.setUnidadMedida(resultadoSQL.getString("unidad_de_medida"));
producto.setEstado(resultadoSQL.getInt("estado_producto"));
producto.setCategoria_id(resultadoSQL.getInt("categoria"));
producto.setFecha_entrada(resultadoSQL.getString("fecha_entrada"));


}

}catch(Exception e){
}finally{
this.conn.cerrarConexion();
}      
return producto;
}





@Override
public boolean guardarPro(Producto producto){
 this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
 
 boolean guardar = false;
 
 try{

     if(producto.getId_producto() == 0)
     {
         

         StringBuilder miSQL = new StringBuilder();

         

         miSQL.append("INSERT INTO tb_producto(`nom_producto`, `des_producto`, `stock`, `precio`, `unidad_de_medida`, `estado_producto`, `categoria`) VALUES ('");
         miSQL.append(producto.getNom_producto()+ "','");
         miSQL.append(producto.getDes_producto()+"','");
         miSQL.append(producto.getStock()+"','");
         miSQL.append(producto.getPrecio()+"','");
         miSQL.append(producto.getUnidadMedida()+"','");
         miSQL .append(producto.getEstado()+"','");
         miSQL.append(producto.getCategoria_id());
         miSQL.append("')");
         this.conn.ejecutarSQL(miSQL.toString());

        
         
       
     }else if(producto.getId_producto()>0){
        
         
         
         
         
         StringBuilder miSQL = new StringBuilder();
    
         miSQL.append("UPDATE tb_producto SET ");
         miSQL.append(" `nom_producto` = '").append(producto.getNom_producto());
         miSQL.append("', `des_producto` = '").append(producto.getDes_producto());
         miSQL.append("', `stock` = ").append(producto.getStock());
         miSQL.append(" , `precio` = ").append(producto.getPrecio());
         miSQL.append(" , `unidad_de_medida` = '").append(producto.getUnidadMedida());
         miSQL.append("', `estado_producto` = ").append(producto.getEstado());
         miSQL.append(", `categoria` = ").append(producto.getCategoria_id());
         miSQL.append(" , `fecha_entrada` = '").append(producto.getFecha_entrada());
         miSQL.append("' WHERE `id_producto` = ").append(producto.getId_producto()).append(";");
         
         
         
          
         this.conn.ejecutarSQL(miSQL.toString());
         
       
         
         

         
     }
     guardar = true; 
 }catch(Exception e){
    
 }finally{
    this.conn.cerrarConexion();
 }
   return guardar; 
}





@Override
public boolean borrarPro(int id_pro_borrar) {
    
this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);

boolean borrar = false;
try{
    
StringBuilder miSQL = new StringBuilder();

miSQL.append("DELETE FROM tb_producto WHERE id_producto = ").append(id_pro_borrar);
this.conn.ejecutarSQL(miSQL.toString());
borrar = true;
}catch(Exception e){
            
}finally{
this.conn.cerrarConexion();  
}
       
return borrar;
}
}
    