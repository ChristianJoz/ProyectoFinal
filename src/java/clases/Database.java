
package clases;

public class Database {
    private String url;
    private String user;
    private String contra;
    private String driver;
    
    public  Database (){
    this.url = "jdbc:mysql://localhost:3306/bd_inventario";
    this.user = "root";
    this.contra = "";
    this.driver = "com.mysql.jdbc.Driver";
    
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getContra() {
        return contra;
    }

    public String getDriver() {
        return driver;
    }

 
    
    
}

