package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionMySql {
    public Connection con;
    public PreparedStatement ps;
    public ResultSet rs;
    public String SQL;

    //Metodo de conecion
    public void OpenDatabase()throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        //Localhost es la ip
        //crud_cliente = DB
        String url = "jdbc:mysql://localhost:3306/crud_cliente";
        String user = "yamileth";  //Usuario
        String password = "12345";  //Contraseña.
        con = DriverManager.getConnection(url, user, password);
    }

    //Metodo para cierra de la DB
    public void CloseDatabase() throws Exception{
        if(con != null){
            con.close();
        }
    }    
}