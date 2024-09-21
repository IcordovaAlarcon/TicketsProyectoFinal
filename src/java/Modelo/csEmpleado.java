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
public class csEmpleado {
     private Connection con;
    private Statement stm;
    private ResultSet rs;
    
public int actualizarempleado(int idEmpleado, String nombre, String apellido, long 
dpi, String puesto) {
 int respuesta = 0;
 csConexion cl = new csConexion();
 con = cl.conectar();
 
 try {
 stm = con.createStatement();
 respuesta = stm.executeUpdate ("update Ticket.dbo.empleado SET "
 + "nombre = '" + nombre + "', "
 + "apellido = '" + apellido + "', "
 + "dpi = " + dpi + ", "
 + "puesto = '" + puesto + "' "
 + "WHERE idempleado = " + idEmpleado )
; 
 cl.desconectar();
 con.close();
 stm.close();
 } catch (Exception ex) {
 } 
 return respuesta;
}
public int eliminarempleado (int idempleado)
{
int respuesta=0;
csConexion cl = new csConexion();
con=cl.conectar();
try {
stm=con.createStatement();
respuesta=stm.executeUpdate("delete from Ticket.dbo.empleado where idempleado="+
idempleado + " ");
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

