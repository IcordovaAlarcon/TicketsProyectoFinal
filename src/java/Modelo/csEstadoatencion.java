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

/**
 *
 * @author Aroni
 */
public class csEstadoatencion {
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    public int actualizarestadoatencion(int idEstado, String estado) {
 int respuesta = 0;
 csConexion cl = new csConexion();
 con = cl.conectar();
 
 try {
 stm = con.createStatement();
 respuesta = stm.executeUpdate ("update Ticket.dbo.estadoatencion SET "
 + "estado = '" + estado + "' "
 + "where idestado = " + idEstado);
 cl.desconectar();
 con.close();
 stm.close();
 } 
catch (Exception ex) 
{
 }
 return respuesta;
}

 public int eliminarestado (int idestado)
{
int respuesta=0;
csConexion cl = new csConexion();
con=cl.conectar();
try {
stm=con.createStatement();
respuesta=stm.executeUpdate("delete from Ticket.dbo.estado where idestado="+ idestado);
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