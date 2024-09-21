/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author Aroni
 */
public class csTicket {
     private Connection con;
    private Statement stm;
    private ResultSet rs;
    public int actualizarTicket(int idTicket, int idUsuario, int idAtencion) {
 int respuesta = 0;
 csConexion cl = new csConexion();
 con = cl.conectar();
 Statement stm = null;
 ResultSet rs = null;
 try {
 stm = con.createStatement();
 String verificarUsuario = "SELECT COUNT(*) AS count FROM Ticket.dbo.usuario WHERE idusuario = " + idUsuario;
 rs = stm.executeQuery(verificarUsuario);
 if (!rs.next() || rs.getInt("count") == 0) {
 System.out.println("El idUsuario no existe, no se puede actualizar el ticket.");
 return respuesta;
 }
 String verificarAtencion = "SELECT COUNT(*) AS count FROM Ticket.dbo.atencion_cliente WHERE idatencion = " + idAtencion;
 rs = stm.executeQuery(verificarAtencion);
 if (!rs.next() || rs.getInt("count") == 0) {
 System.out.println("El idAtencion no existe, no se puede actualizar el ticket.");
 return respuesta;
 }
 respuesta = stm.executeUpdate ("update Ticket.dbo.ticket SET " + "idusuario = " + idUsuario + ", " + "idatencion = " + idAtencion + " "+ "WHERE idticket = " + idTicket); 
 cl.desconectar();
 con.close();
 stm.close();
 if (rs != null) rs.close();
 } catch (Exception ex) {
 }
 return respuesta;
}
public int eliminarventanilla (int idticket)
{
int respuesta=0;
csConexion cl = new csConexion();
con=cl.conectar();
try {
stm=con.createStatement();
respuesta=stm.executeUpdate("delete from Ticket.dbo.ticket where idticket="+ idticket);
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
