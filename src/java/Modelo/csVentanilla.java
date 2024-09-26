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

public class csVentanilla {
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    
        public int insertar(int idescritorio, String sistema, int idempleado){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();
        try {
        stm = con.createStatement();
        respuesta = stm.executeUpdate("insert into Ticket.dbo.escritorio(idescritorio, sistema, idempleado) "
                + "values(" + idescritorio + ", '"+ sistema +"', "+ idempleado +"')");
        c1.desconectar();
        con.close();
        stm.close();
        }
        catch (Exception ex){
            
        }
        return respuesta;
        }
    
    
    public int actualizarVentanilla(int idVentanilla, String estado, int idEmpleado, int 
idTicket) {
 int respuesta = 0;
 csConexion cl = new csConexion();
 con = cl.conectar();
 Statement stm = null;
 ResultSet rs = null;
 try {
 stm = con.createStatement();
 String verificarEmpleado = "SELECT COUNT(*) AS count FROM dbo.empleado WHERE idempleado = " + idEmpleado;
 rs = stm.executeQuery(verificarEmpleado);
 if (!rs.next() || rs.getInt("count") == 0) {
 System.out.println("El idEmpleado no existe, no se puede actualizar la ventanilla.");
 return respuesta;
 }
 String verificarTicket = "SELECT COUNT(*) AS count FROM dbo.ticket WHERE idticket = " + idTicket;
 rs = stm.executeQuery(verificarTicket);
 if (!rs.next() || rs.getInt("count") == 0) {
 System.out.println("El idTicket no existe, no se puede actualizar la ventanilla.");
 return respuesta;
 }
 respuesta = stm.executeUpdate ("update dbo.ventanilla SET "
 + "estado = '" + estado + "', "
 + "idempleado = " + idEmpleado + ", "
 + "idticket = " + idTicket + " "
 + "WHERE idventanilla = " + idVentanilla) 
; 
 cl.desconectar();
 con.close();
 stm.close();
 if (rs != null) rs.close();
 } catch (Exception ex) {
 }
 return respuesta;

   } 
    
    public int eliminarescritorio (int idescritorio)
{
int respuesta=0;
csConexion cl = new csConexion();
con=cl.conectar();
try {
stm=con.createStatement();
respuesta = stm.executeUpdate("delete from Ticket.dbo.escritorio where idescritorio="+ idescritorio);
cl.desconectar();
con.close();
stm.close();
}
catch (Exception ex)
{
}
    return respuesta;
 }
    
        public ArrayList<Select_Escritorio> listarEscritorio(){
        
    Select_Escritorio S = null;
    ArrayList<Select_Escritorio> lista = new ArrayList<Select_Escritorio>();
    lista = null;
    
    csConexion c1 = new csConexion();
    con = c1.conectar();
    rs = null;
    
    try{
        stm = con.createStatement();
        rs = stm.executeQuery("Select * from Ticket.dbo.escritorio");
        
        while(rs.next()){
        S = new Select_Escritorio(rs.getInt(1), rs.getString("Sistema"), rs.getInt(3));
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