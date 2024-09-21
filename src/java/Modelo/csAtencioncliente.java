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
public class csAtencioncliente {
    private Connection con;
    private Statement stm;
    private ResultSet rs;

    public int actualizarAtencionCliente(int idAtencion, String descripcion, int idEmpresa, 
int idMotivo, int idEstado) {
 int respuesta = 0;
 csConexion cl = new csConexion();
 con = cl.conectar();
 
 try {
 stm = con.createStatement();
 String verificarEmpresa = "SELECT COUNT(*) AS count FROM Ticket.dbo.empresa WHERE idempresa = " + idEmpresa;
 String verificarMotivo = "SELECT COUNT(*) AS count FROM Ticket.dbo.motivo WHERE idmotivo = " + idMotivo;
 String verificarEstado = "SELECT COUNT(*) AS count FROM Ticket.dbo.estadoatencion WHERE idestado = " + idEstado;
 
 rs = stm.executeQuery(verificarEmpresa);
 if (!rs.next() || rs.getInt("count") == 0) {
 System.out.println("La empresa no existe, no se puede actualizar la atención.");
 return respuesta;
 }
 
 rs = stm.executeQuery(verificarMotivo);
 if (!rs.next() || rs.getInt("count") == 0) {
 System.out.println("El motivo no existe, no se puede actualizar la atención.");
 return respuesta;
 }
 rs = stm.executeQuery(verificarEstado);
 if (!rs.next() || rs.getInt("count") == 0) {
 System.out.println("El estado de atención no existe, no se puede actualizar la atención.");
 return respuesta;
 }
 
 respuesta = stm.executeUpdate ("UPDATE Ticket.dbo.atencion_cliente SET " + "descripcion = '" + descripcion + "', " + "idempresa = " + idEmpresa + ", " + "idmotivo = " + idMotivo + ", " + "idestado = " + idEstado + ", " + "WHERE idatencion = " + idAtencion +" ");
 cl.desconectar();
 
 con.close();
 stm.close();
 if (rs != null) rs.close();
 } catch (Exception ex) {
 ex.printStackTrace();
 }
 return respuesta;
}

   public int eliminarAtencionCliente (int idatencion)
{
int respuesta=0;
csConexion cl = new csConexion();
con=cl.conectar();
try {
stm=con.createStatement();
respuesta=stm.executeUpdate("delete from Ticket.dbo.atencion_cliente where idatencion="+ idatencion + " ");
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
