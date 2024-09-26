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
public class csMotivo {
      private Connection con;
    private Statement stm;
    private ResultSet rs;
    
        public int insertar(int idmotivo, String motivo){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();
        try {
        stm = con.createStatement();
        respuesta = stm.executeUpdate("insert into Ticket.dbo.motivo(idmotivo, motivo) "
                + "values(" + idmotivo + ", '"+ motivo +"')");
        c1.desconectar();
        con.close();
        stm.close();
        }
        catch (Exception ex){
            
        }
        return respuesta; 
        }
    
    public int actualizarmotivo(int idMotivo, String motivo) {
 int respuesta = 0;
 csConexion cl = new csConexion();
 con = cl.conectar();
 
 try {
 stm = con.createStatement();
 respuesta = stm.executeUpdate ("update Ticket.dbo.motivo SET "
 + "motivo = '" + motivo + "' "
 + "WHERE idmotivo = " + idMotivo ) 
; 
 cl.desconectar();
 con.close();
 stm.close();
 } catch (Exception ex) {
 }
 
 return respuesta;
}
public int eliminarmotivo (int idmotivo)
{
int respuesta=0;
csConexion cl = new csConexion();
con=cl.conectar();
try {
stm=con.createStatement();
respuesta=stm.executeUpdate("delete from Ticket.dbo.motivo where idmotivo="+ idmotivo
+ " ");
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
   

