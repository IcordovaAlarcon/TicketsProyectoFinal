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
public class csAtencioncliente {
    private Connection con;
    private Statement stm;
    private ResultSet rs;

        public int insertar(int idAtencion, String descripcion, int idEmpresa, int idMotivo, int idEstado, int idticket){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();
        try {
        stm = con.createStatement();
        respuesta = stm.executeUpdate("insert into Ticket.dbo.atencion_cliente(idatencion, descripcion, idempresa, idmotivo, idestado, idticket) "
                + "values(" + idAtencion + ", '"+ descripcion +"', "+ idEmpresa +", "+ idMotivo +", "+ idEstado + ", "+ idticket +")");
        c1.desconectar();
        con.close();
        stm.close();
        }
        catch (Exception ex){
            
        }
        return respuesta;
        }
    
    public int actualizarAtencionCliente(int idAtencion, String descripcion, int idEmpresa, int idMotivo, int idEstado, int idticket) {
 int respuesta = 0;
 csConexion cl = new csConexion();
 con = cl.conectar();
 
 try {
 stm = con.createStatement();
 String verificarEmpresa = "SELECT COUNT(*) AS count FROM Ticket.dbo.empresa WHERE idempresa = " + idEmpresa;
 String verificarMotivo = "SELECT COUNT(*) AS count FROM Ticket.dbo.motivo WHERE idmotivo = " + idMotivo;
 String verificarEstado = "SELECT COUNT(*) AS count FROM Ticket.dbo.estadoatencion WHERE idestado = " + idEstado;
  String verificarTicket = "SELECT COUNT(*) AS count FROM Ticket.dbo.estadoatencion WHERE idestado = " + idticket;
 
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
 rs = stm.executeQuery(verificarTicket);
 if (!rs.next() || rs.getInt("count") == 0) {
 System.out.println("La empresa no existe, no se puede actualizar la atención.");
 return respuesta;
 }
 
 
 respuesta = stm.executeUpdate ("UPDATE Ticket.dbo.atencion_cliente SET " + "descripcion = '" + descripcion + "', " + "idempresa = " + idEmpresa + ", " + "idmotivo = " + idMotivo + ", " + "idestado = " + idEstado + ", " + idticket + ", " +"WHERE idatencion = " + idAtencion +" ");
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
   
     public ArrayList<Select_Atencion> listarAtencion(){
        
    Select_Atencion S = null;
    ArrayList<Select_Atencion> lista = new ArrayList<Select_Atencion>();
    lista = null;
    
    csConexion c1 = new csConexion();
    con = c1.conectar();
    rs = null;
    
    try{
        stm = con.createStatement();
        rs = stm.executeQuery("Select * from Ticket.dbo.atencion_cliente");
        
        while(rs.next()){
        S = new Select_Atencion(rs.getInt(1), rs.getString("Descripcion"), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
        lista.add(S);
        }
        c1.desconectar();
        con.close();
        stm.close();
    }
    catch (Exception ex){
        
    }
    return lista;
}
}
