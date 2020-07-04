
package clases;
import java.sql.*;
import javax.ws.rs.NotFoundException;



public class Acceso {
    Database db = new Database();
    String sql="";
    Connection cor;
    PreparedStatement pt;
    ResultSet  st;
    
    
    
    public Acceso(){
    
    
    }  
    public int validar(String usuario, String contra){
    
    int tipo=0;
            try{
              Class.forName(db.getDriver());
              cor=DriverManager.getConnection(db.getUrl(),db.getUser(), db.getContra());
              sql="SELECT estado FROM tb_usuario WHERE nombre ='"+usuario+"' and clave ='"+contra+"'";
              pt=cor.prepareStatement(sql);
                      st=pt.executeQuery();
                   while (st.next())  {
                   tipo=st.getInt(1);
                   }
                   cor.close();
                   st.close();
                   return tipo;
            } catch (SQLException | ClassNotFoundException e) {
            return tipo;
            
            }
    
    }
    

}