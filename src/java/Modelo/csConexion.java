/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Aroni
 */
public class csConexion {
    public String usuario, contrasena;
    public String url, driver;
    public Connection cn;
    
    public csConexion(){
        this.usuario="sa";
        this.contrasena="Admin1";
        this.url="jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=Ticket";
        this.driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        this.cn=null;
        
    }
    public Connection conectar(){
        try {
            Class.forName(this.driver);
            cn = DriverManager.getConnection(url,usuario,contrasena);
            return cn;
        } catch (Exception ex) {
            return null;
        }
    }
    public void desconectar() throws SQLException{
        cn.close();
    }
    
    
}
