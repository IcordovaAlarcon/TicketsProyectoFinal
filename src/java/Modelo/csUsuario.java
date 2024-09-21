/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Aroni
 */
public class csUsuario {
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    
    
    public int actualizarUsuario(int idUsuario, int idSolicitante, String nombre, String 
contraseña) {
 int respuesta = 0;
 csConexion cl = new csConexion();
 con = cl.conectar();
 try {
 stm = con.createStatement();
 respuesta = stm.executeUpdate ("update Ticket.dbo.usuario SET "
 + "nombre = '" + nombre + "', "
 + "contraseña = '" + contraseña + "' "
 + "WHERE idusuario = " + idUsuario + " "
 + "AND idsolicitante = " + idSolicitante)
;
 cl.desconectar();
 con.close();
 stm.close();
 }
catch (Exception ex) {
 }
 return respuesta;
}

    
    public int eliminarusuario (int idusuario)
{
int respuesta=0;
csConexion cl = new csConexion();
con=cl.conectar();
try {
stm=con.createStatement();
respuesta=stm.executeUpdate("delete from Ticket.dbo.usuario where idusuario="+
idusuario + " ");
cl.desconectar();
con.close();
stm.close();
}
catch (Exception ex)
{
    }
return respuesta;
}

    
    
}
